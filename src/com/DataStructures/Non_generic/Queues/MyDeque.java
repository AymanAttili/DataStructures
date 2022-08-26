package com.DataStructures.Non_generic.Queues;

import com.DataStructures.Non_generic.LinkedLists.DoublyNode;

import java.util.NoSuchElementException;

public class MyDeque {
    private int size;
    private DoublyNode head;
    private DoublyNode tail;

    public MyDeque() {
        size=0;
        head=null;
        tail=null;
    }

    public int size() {
        return size;
    }

    public int addFirst(int data){
        DoublyNode temp = new DoublyNode(data);
        if(head==null){
            head=tail=temp;
        }
        else{
            temp.setNext(head);
            head=temp;
        }
        size++;
        return head.getData();
    }


    public int addLast(int data){
        DoublyNode temp = new DoublyNode(data);
        if(head==null){
            head=tail=temp;
        }
        else{
            tail.setNext(temp);
            temp.setPrevious(tail);
            tail=temp;
        }
        size++;
        return tail.getData();
    }

    public int removeFirst(){
        if(head==null)
            throw new NoSuchElementException("Empty deque");
        int temp = head.getData();
        if(head==tail){
            head=tail=null;
        }
        else{
            head=head.getNext();
        }
        size--;
        return temp;
    }

       public int removeLast(){
        if(head==null)
            throw new NoSuchElementException("Empty deque");
        int temp = head.getData();
        if(head==tail){
            head=tail=null;
        }
        else{
            tail=tail.getPrevious();
            tail.setNext(null);
        }
        size--;
        return temp;
    }

    public int getFirst(){
        if(head==null)
            throw new NoSuchElementException("Empty deque");
        return head.getData();
    }


    public int getLast() {
        if(head==null)
            throw new NoSuchElementException("Empty deque");
        return tail.getData();
    }

    @Override
    public String toString() {
        String st = "[";
        DoublyNode curr = head;
        while(curr!=null){
            if(curr==tail)
                st+=curr.getData();

            else
                st+=curr.getData()+", ";

            curr = curr.getNext();
        }
        return st+"]";
    }
}
