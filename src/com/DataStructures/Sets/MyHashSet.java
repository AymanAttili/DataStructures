package com.DataStructures.Sets;

import com.DataStructures.Node;

public class MyHashSet{
    private int size = 10;
    private Node[] set = new Node[size];

    public MyHashSet() {
    }

    public void add(Integer data){
        int index = hashCode(data);
        if(set[index]==null)
            set[index]=new Node<Integer>(data);
        else{
            Node curr = set[index];
            while(curr.getNext()!=null){
                if(curr.getData()==data)
                    return;
                curr=curr.getNext();
            }
            if(curr.getData()==data)
                return;
            curr.setNext(new Node<Integer>(data));
        }
    }


    public void remove(int data) {
        int index = hashCode(data);
        if(set[index]==null)
            return;
        if(set[index].getData().equals(data)){
            set[index]=set[index].getNext();
        }
        else{
            Node pre = set[index];
            Node curr = set[index].getNext();

            while (!curr.getData().equals(data)){
                if(curr==null)
                    return;
                curr = curr.getNext();
                pre = pre.getNext();
            }
            pre.setNext(curr.getNext());
        }
    }

    public boolean contains(int data) {
        int index = hashCode(data);
        Node curr = set[index];
        if(curr==null)
            return false;
        while(curr!=null){
            if(curr.getData().equals(data))
                return true;
            curr = curr.getNext();
        }
        return false;
    }



    public int hashCode(Integer value){
        return value%size;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i=0 ; i<size ; i++){
            Node curr = set[i];
            while(curr!=null){
                str+=curr.getData()+" ";
                curr = curr.getNext();
            }
        }
        return str;
    }

}
