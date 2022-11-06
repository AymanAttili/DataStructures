package com.DataStructures.Non_generic.LinkedLists;

public class MyDoublyLinkedList<T> {
    private DoublyNode head;
    private DoublyNode tail;

    public MyDoublyLinkedList() {
    }

    public DoublyNode getHead() {
        return head;
    }

    public void setHead(DoublyNode head) {
        this.head = head;
    }

    public DoublyNode getTail() {
        return tail;
    }

    public void setTail(DoublyNode tail) {
        this.tail = tail;
    }


    ///Basic Methods/////////////////////
    public int size(){
        int count = 0;
        DoublyNode curr = head;
        while(curr!=null){
            count++;
            curr = curr.getNext();
        }
        return count;
    }
    public int get(int ind){
        if(head==null)
            throw new RuntimeException("No data found!!!");
        if(ind<1 || ind>size())
            throw new NullPointerException("Out of link bounds");

        DoublyNode curr = head;
        while(ind>1){
            curr = curr.getNext();
            ind--;
        }
        return curr.getData();
    }

    public void set(int ind,int data){
        if(head==null)
            throw new RuntimeException("No data found!!!");
        if(ind<1 || ind>size())
            throw new NullPointerException("Out of link bounds");

        DoublyNode curr = head;
        while(ind>1){
            curr = curr.getNext();
            ind--;
        }
        curr.setData(data);
    }

    public void addFirst(int data){
        DoublyNode temp = new DoublyNode(data);
        if(head==null)
            head=tail=temp;
        else{
            temp.setNext(head);
            head.setPrevious(temp);
            head=temp;
        }
    }

    public void addByIndex(int ind,int data){
        if(ind<1 || ind>size()+1)
            throw new RuntimeException("Out of list bounds");
        if(ind==1)
            addFirst(data);
        else if(ind==size()+1)
            addLast(data);
        else {
            DoublyNode temp = new DoublyNode(data);
            DoublyNode curr = head;
            while (ind > 2) {
                curr = curr.getNext();
                ind--;
            }
            temp.setNext(curr.getNext());
            temp.getNext().setPrevious(temp);
            curr.setNext(temp);
            temp.setPrevious(curr);
        }
    }

    public void addLast(int data){
        DoublyNode temp = new DoublyNode(data);
        if(head==null)
            head=tail=temp;
        else{
            temp.setPrevious(tail);
            tail.setNext(temp);
            tail=temp;
        }
    }

    public int removeFirst() {
        if (head == null)
            throw new RuntimeException("There is no data!!!");
        int data = head.getData();
        if (head == tail) {
            head = tail = null;
        }
        else {
            head = head.getNext();
            head.setPrevious(null);
        }
        return data;
    }

    public int removeLast() {
        if (head == null)
            throw new RuntimeException("There is no data!!!");
        int data = tail.getData();
        if (head == tail) {
            head = tail = null;
        } else {
            tail=tail.getPrevious();
            tail.setNext(null);
        }
        return data;
    }

    public boolean contains(int data){
        if(head == null)
            throw new RuntimeException("No data found!!!");
        DoublyNode curr = head;
        while(curr!=null){
            if(curr.getData()==data)
                return true;
            curr = curr.getNext();
        }
        return false;
    }

    public void clear(){
        head=tail=null;
    }

    @Override
    public boolean equals(Object obj) {
        MyDoublyLinkedList ml2 = (MyDoublyLinkedList) obj;
        if(this.size()!=ml2.size())
            return false;
        DoublyNode curr1 = this.getHead();
        DoublyNode curr2 = ml2.getHead();
        while(curr1!=null){
            if(!(curr1.getData()==curr2.getData()))
                return false;
            curr1 = curr1.getNext();
            curr2 = curr2.getNext();
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "[ ";
        DoublyNode curr = head;
        while(curr!=null){
            if(curr==tail)
                s+=curr.getData();
            else
                s+=curr.getData()+", ";
            curr = curr.getNext();
        }
        return s + " ]";
    }
}
