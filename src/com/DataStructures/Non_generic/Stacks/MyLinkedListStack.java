package com.DataStructures.Non_generic.Stacks;

import com.DataStructures.Non_generic.LinkedLists.Node;

import java.util.EmptyStackException;

public class MyLinkedListStack {
    private Node head;
    private Node tail;
    private int size = 0;

    public MyLinkedListStack(){
        size=0;
        head=null;
        tail=null;
    }

    public int push(int element){
        Node temp =new Node(element);
        if(head==null){
            head=tail=temp;
        }
        else{
            tail.setNext(temp);
            tail=temp;
        }
        size++;
        return tail.getData();
    }

    public int pop() {
        if (head == null)
            throw new EmptyStackException();
        int temp = tail.getData();
        if (head == tail)
            head = tail = null;
        else {
            Node curr = head;
            while (curr.getNext()!=tail)
                curr=curr.getNext();
            tail=curr;
        }
        size--;
        return temp;
    }

    public int peek(){
        if(head==null)
            throw new EmptyStackException();
        return tail.getData();
    }

    @Override
    public String toString() {
        String s = "[ ";
        Node curr = head;
        while(curr!=null){
            if(curr==tail)
                s+=curr.getData();
            else
                s+=curr.getData()+", ";
            curr = curr.getNext();
        }
        return s + " ]";
    }
}
