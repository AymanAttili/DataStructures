package com.DataStructures;

public abstract class MyAbstract<E> {
    private int size=0;

    public int getSize(){
        return size;
    }
    public int setSize(int x){
        size=x;
        return 0;
    }
    public abstract void add(E e);
    public abstract void add(int index ,E e);
    public abstract void clear();
    public abstract boolean equals(Object o);
    public abstract E get(int index);
    public abstract int indexOf(E e);
    public abstract int lastIndexOf(E e);
    public abstract E remove(int index);
    public abstract E[] removeRange(int fromInd,int toInd);
    public abstract void set(int index,E e);
    public abstract E[] subList(int fromInd,int toInd);
    public abstract boolean contains(E e);
    public abstract E[] toArray();
}