package com.DataStructures.Generic.ArrayList;

public class MyArrayList<E>{
    private static final int capacity = 5;
    E[] arr = (E[]) new Object[capacity];
    int size = getSize();

    public int getSize(){
        return size;
    }

    public int setSize(int x){
        size=x;
        return 0;
    }

    public void add(E e) {
        if(getSize()==arr.length)
            ensureCapacity();
        arr[getSize()]=e;
        setSize(getSize()+1);
    }

    public void add(int index, E e) {
        if(index<0 || index>getSize())
            throw new ArrayIndexOutOfBoundsException("Index : " + index);

        else if(index==getSize())
            add(e);
        else{
            if(getSize()==arr.length)
                ensureCapacity();
            for(int i=getSize() ; i>index ; i--)
                arr[i]=arr[i-1];
            arr[index]=e;
            setSize(getSize()+1);
        }

    }

    public void clear() {
        setSize(0);
    }

    @Override
    public boolean equals(Object o) {
        MyArrayList n = (MyArrayList)o;
        if(n.getSize()==this.getSize()){
            for(int i=0 ; i<this.getSize() ; i++)
                if(this.arr[i]!=n.arr[i])
                    return false;
            return true;
        }
        return false;
    }

    public E get(int index) {
        if(index<0 || index>getSize())
            throw new ArrayIndexOutOfBoundsException("Index : " + index);

        return arr[index];

    }

    public int indexOf(E e) {
        for(int i=0 ; i<getSize() ; i++)
            if(arr[i]==e)
                return i;
        return -1;
    }

    public int lastIndexOf(E e) {
        for(int i=getSize()-1 ; i>=0 ; i--)
            if(arr[i]==e)
                return i;
        return -1;
    }

    public E remove(int index) {
        if(index<0 || index>getSize())
            throw new ArrayIndexOutOfBoundsException("Index : " + index);
        else{
            E temp = arr[index];
            for(int i=index ; i<getSize() ; i++)
                arr[i]=arr[i+1];
            setSize(getSize()-1);
            return temp;
        }
    }

    public E[] removeRange(int fromInd, int toInd) {
        E[] e = (E[]) new Object[toInd-fromInd];
        int ind=0;
        for(int i=fromInd ; i<toInd ; i++)
            e[ind++]=remove(i);
        return e;
    }

    public void set(int index, E e) {
        if(index<0 || index>getSize())
            throw new ArrayIndexOutOfBoundsException("Index : " + index);
        arr[index]=e;
    }

    public E[] subList(int fromInd, int toInd) {
        E[] e = (E[]) new Object[toInd-fromInd];
        int ind=0;
        for(int i=fromInd ; i<toInd ; i++)
            e[ind++]=get(i);
        return e;
    }

    public boolean contains(E e) {
        return indexOf(e)>=0;
    }

    public E[] toArray() {
        E[] temp = (E[]) new Object[getSize()];
        for(int i=0 ; i<getSize() ; i++){
            temp[i] = arr[i];
        }
        return temp;
    }

    private void ensureCapacity() {
        E[] arr2 = (E[]) new Object[arr.length * 2];
        for(int i = 0; i < getSize(); i++) {
            arr2[i] = arr[i];
        }
        arr = arr2;
    }
}
