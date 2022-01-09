package com.company;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyArrayListStack<E> {
    private ArrayList<E> arr = new ArrayList<>();
    private int size;

    public MyArrayListStack() {
    }

    public int getSize() {
        return size;
    }

    public E push(E element){
        arr.add(element);
        size++;
        return arr.get(size-1);
    }

    public E pop(){
        if(isEmpty())
            throw new EmptyStackException();
        return arr.remove(--size);
    }

    public E peek(){
        if(isEmpty())
            throw new EmptyStackException();
        return arr.get(size-1);
    }

    public boolean isEmpty(){
        return (size==0);
    }

    public int search(E element){
        if(isEmpty())
            throw new EmptyStackException();
        int i=size;
        while(i>=1){
            if(element.equals(arr.get(i-1)))
                return size-i+1;
            i--;
        }
        return -1;

    }
    @Override
    public String toString() {
        return arr.toString();
    }


}
