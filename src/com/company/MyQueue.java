package com.company;

import java.rmi.AccessException;
import java.util.ArrayList;

public class MyQueue {
    private ArrayList<Integer> arr = new ArrayList<>();
    private int size = 0;

    public MyQueue() {
    }

    public void enqueue(Integer x){
        arr.add(0,x);
        size++;
    }

    public Integer dequeue(){
        if(size==0)
            throw new IndexOutOfBoundsException();
        int temp = arr.remove(size-1);
        size--;
        return temp;
    }

    public void rev(){
        if(arr.isEmpty())
            return;
        int temp = arr.remove(arr.size()-1);
        rev();
        arr.add(0,temp);
    }
    public boolean isEmpty(){
        return (size==0);
    }

    public Integer peek() {
        return arr.get(size-1);
    }
    @Override
    public String toString() {
        return arr.toString();
    }


}
