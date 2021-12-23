package com.company;

import java.util.NoSuchElementException;

public class MyDeque<E> {
    private int size;
    private Node2<E> head;
    private Node2<E> tail;

    public MyDeque() {
        size=0;
        head=null;
        tail=null;
    }

    public int size() {
        return size;
    }

    public E addFirst(E data){
        Node2<E> temp = new Node2<>(data);
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


    public E addLast(E data){
        Node2<E> temp = new Node2<>(data);
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

    public E removeFirst(){
        if(head==null)
            throw new NoSuchElementException("Empty deque");
        E temp = head.getData();
        if(head==tail){
            head=tail=null;
        }
        else{
            head=head.getNext();
        }
        size--;
        return temp;
    }

    public E pollFirst(){
        if(head==null)
            return null;
        E temp = head.getData();
        if(head==tail){
            head=tail=null;
        }
        else{
            head=head.getNext();
        }
        size--;
        return temp;
    }

    public E removeLast(){
        if(head==null)
            throw new NoSuchElementException("Empty deque");
        E temp = head.getData();
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
    public E pollLast(){
        if(head==null)
            return null;
        E temp = head.getData();
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

    public E getFirst(){
        if(head==null)
            throw new NoSuchElementException("Empty deque");
        return head.getData();
    }

    public E peekFirst(){
        if(head==null)
            return null;
        return head.getData();
    }
    public E getLast() {
        if(head==null)
            throw new NoSuchElementException("Empty deque");
        return tail.getData();
    }

    public E peekLast() {
        if(head==null)
            return null;
        return tail.getData();
    }


    @Override
    public String toString() {
        String st = "[";
        Node2 curr = head;
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
