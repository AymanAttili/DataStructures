package com.DataStructures.Generic.Stacks;

import com.DataStructures.Generic.LinkedLists.Node;

import java.util.EmptyStackException;

public class MyLinkedListStack<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public MyLinkedListStack(){
        size=0;
        head=null;
        tail=null;
    }

    public T push(T element){
        Node<T> temp =new Node<T>(element);
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

    public T pop() {
        if (head == null)
            throw new EmptyStackException();
        T temp = tail.getData();
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

    public T peek(){
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
