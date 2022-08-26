package com.DataStructures.Non_generic.Stacks;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyArrayListStack {
    private ArrayList<Integer> arr = new ArrayList();
    private int size;

    public MyArrayListStack() {
    }

    public int getSize() {
        return size;
    }

    public int push(int element){
        arr.add(element);
        size++;
        return arr.get(size-1);
    }

    public int pop(){
        if(isEmpty())
            throw new EmptyStackException();
        return arr.remove(--size);
    }

    public int peek(){
        if(isEmpty())
            throw new EmptyStackException();
        return arr.get(size-1);
    }

    public boolean isEmpty(){
        return (size==0);
    }

    public int search(int element){
        if(isEmpty())
            throw new EmptyStackException();
        int i=size;
        while(i>=1){
            if(element == arr.get(i-1))
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
