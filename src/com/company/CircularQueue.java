package com.company;

import java.rmi.AccessException;

public class CircularQueue<E> {
    private int size;
    private E arr[]= (E[]) new Object[8];
    private int f,r;

    public CircularQueue() {
        size=0;
        f=-1;
        r=-1;
    }

    public E add(E element) throws Exception {
        if(isFull())
            throw new Exception("Full Queue");
        if(f==-1) {
            f++;
            r++;
        }
        else {
            f=(f+1)%arr.length;
        }
        arr[f]=element;
        E added = arr[f];
        size++;
        return added;
    }

    public E remove() throws Exception {
        if(f==-1)
            throw new Exception("Empty Queue");
        E removed = arr[r];
        r=(r+1)%arr.length;
        size--;
        if(size==0)
            r=f=-1;
        return removed;
    }

    private boolean isFull() {
        if((f%arr.length==arr.length-1 && r%arr.length==0)||(f==r-1))
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