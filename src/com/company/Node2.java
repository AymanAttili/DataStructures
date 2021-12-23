package com.company;

public class Node2<E> {
    private E data;
    private Node2<E> previous;
    private Node2<E> next;

    public Node2(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node2<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node2<E> previous) {
        this.previous = previous;
    }

    public Node2<E> getNext() {
        return next;
    }

    public void setNext(Node2<E> next) {
        this.next = next;
    }
}
