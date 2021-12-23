package com.company;

import java.util.EmptyStackException;

public class MyStack2<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public MyStack2(){
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
}
