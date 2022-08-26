package com.DataStructures.Non_generic.ArrayList;

public class MyArrayList {
    private static final int capacity = 5;
    int[] arr = new int[capacity];
    int size = getSize();

    public void add(int x) {
        if (getSize() == arr.length)
            ensureCapacity();

        arr[getSize()] = x;
        setSize(getSize() + 1);
    }

    private void setSize(int s) {
        this.size = s;
    }

    private int getSize() {
        return arr.length;
    }


    public void add(int index, int x) {
        if (index < 0 || index > getSize())
            throw new ArrayIndexOutOfBoundsException("Index : " + index);

        else if (index == getSize())
            add(x);
        else {
            if (getSize() == arr.length)
                ensureCapacity();
            for (int i = getSize(); i > index; i--)
                arr[i] = arr[i - 1];
            arr[index] = x;
            setSize(getSize() + 1);
        }

    }


    public void clear() {
        setSize(0);
    }

    @Override
    public boolean equals(Object o) {
        MyArrayList n = (MyArrayList) o;
        if (n.getSize() == this.getSize()) {
            for (int i = 0; i < this.getSize(); i++)
                if (this.arr[i] != n.arr[i])
                    return false;
            return true;
        }
        return false;
    }

    public int get(int index) {
        if (index < 0 || index > getSize())
            throw new ArrayIndexOutOfBoundsException("Index : " + index);

        return arr[index];
    }

    public int indexOf(int e) {
        for (int i = 0; i < getSize(); i++)
            if (arr[i] == e)
                return i;
        return -1;
    }

    public int lastIndexOf(int e) {
        for (int i = getSize() - 1; i >= 0; i--)
            if (arr[i] == e)
                return i;
        return -1;
    }


    public int remove(int index) {
        if (index < 0 || index > getSize())
            throw new ArrayIndexOutOfBoundsException("Index : " + index);
        else {
            int temp = arr[index];
            for (int i = index; i < getSize(); i++)
                arr[i] = arr[i + 1];
            setSize(getSize() - 1);
            return temp;
        }
    }


    public int[] removeRange(int fromInd, int toInd) {
        int[] e = new int[toInd - fromInd];
        int ind = 0;
        for (int i = fromInd; i < toInd; i++)
            e[ind++] = remove(i);
        return e;
    }


    public void set(int index, int e) {
        if (index < 0 || index > getSize())
            throw new ArrayIndexOutOfBoundsException("Index : " + index);
        arr[index] = e;
    }


    public int[] subList(int fromInd, int toInd) {
        int[] e = new int[toInd - fromInd];
        int ind = 0;
        for (int i = fromInd; i < toInd; i++)
            e[ind++] = get(i);
        return e;
    }

    public boolean contains(int e) {
        return indexOf(e) >= 0;
    }

    public int[] toArray() {
        int[] temp = new int[getSize()];
        for (int i = 0; i < getSize(); i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    private void ensureCapacity() {
        int[] arr2 = new int[arr.length * 2];
        for (int i = 0; i < getSize(); i++) {
            arr2[i] = arr[i];
        }
        arr = arr2;
    }
}
