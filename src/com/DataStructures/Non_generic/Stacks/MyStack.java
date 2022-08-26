package com.DataStructures.Non_generic.Stacks;

import java.util.EmptyStackException;

public class MyStack {
    private int arr[] = new int[5];
    private int size = 0;


    public MyStack() {
        size=0;
    }

    public int Size() {
        return size;
    }


    public void ensureCap(){
        int[] arr2 = new int[arr.length*2];
        for(int i=0 ; i<size ; i++)
            arr2[i] = arr[i];
        arr=arr2;
    }

    public int push(int element){
        if(size==arr.length)
            ensureCap();
        arr[size]=element;
        return arr[size++];
    }

    public int peek(){
        if(size==0)
            throw new EmptyStackException();
        return arr[size-1];
    }
    public int pop(){
        if(size==0)
            throw new EmptyStackException();
        int temp = arr[size-1];
        size--;
        return temp;
    }

    public boolean isEmpty(){
        return(size==0);
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < size; i++) {
            if (i == size - 1)
                s += arr[i];
            else
                s += arr[i] + ",";
        }
        return s+"]";
    }
}
