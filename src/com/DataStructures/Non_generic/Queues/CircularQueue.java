package com.DataStructures.Non_generic.Queues;

import java.util.NoSuchElementException;

public class CircularQueue {
    private int size;
    private int arr[]= new int[8];
    private int f,r;

    public CircularQueue() {
        size=0;
        f=-1;
        r=-1;
    }
    public CircularQueue(int length) {
        size=0;
        f=-1;
        r=-1;
        arr = new int[length];
    }

    public boolean add(int element){
        if(isFull())
            return false;
        if(f==-1) {
            f++;
            r++;
        }
        else {
            f=(f+1)%arr.length;
        }
        arr[f]=element;
        size++;
        return true;
    }

    public int remove(){
        if(f==-1)
            throw new NoSuchElementException();
        int removed = arr[r];
        r=(r+1)%arr.length;
        size--;
        if(size==0)
            r=f=-1;
        return removed;
    }

    private boolean isFull() {
        if((f==arr.length-1 && r==0)||(f==r-1))
            return true;
        return false;
    }

    @Override
    public String toString() {
        String st = "[";
        if(r>-1) {
            for (int i = r,j=0; j<size; j++) {
                i=i%arr.length;
                if(i==f)
                    st += arr[i++];

                else
                    st+=arr[i++]+", ";
            }
        }
        return st+"]";
    }
}