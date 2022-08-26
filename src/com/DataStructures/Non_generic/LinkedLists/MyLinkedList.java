package com.DataStructures.Non_generic.LinkedLists;

public class MyLinkedList {
    private Node head;
    private Node tail;

    public MyLinkedList() {
    }
    public MyLinkedList(int[] elements) {
        for(int i=0 ; i<elements.length ; i++){
            addLast(elements[i]);
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }


    ///Basic Methods/////////////////////
    public int size(){
        int count = 0;
        Node curr = head;
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

        Node curr = head;
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

        Node curr = head;
        while(ind>1){
            curr = curr.getNext();
            ind--;
        }
        curr.setData(data);
    }

    public void addFirst(int data){
        Node temp = new Node(data);
        if(head==null)
            head=tail=temp;
        else{
            temp.setNext(head);
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
            Node temp = new Node(data);
            Node curr = head;
            while (ind > 2) {
                curr = curr.getNext();
                ind--;
            }
            temp.setNext(curr.getNext());
            curr.setNext(temp);
        }
    }

    public void addLast(int data){
        Node temp = new Node(data);
        if(head==null)
            head=tail=temp;
        else{
            Node curr = head;
            while(curr.getNext()!=null) {
                curr = curr.getNext();
            }
            curr.setNext(new Node(data));
            tail = curr.getNext();
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
            Node curr = head;
            while(curr.getNext()!=tail){
                curr=curr.getNext();
            }
            curr.setNext(null);
            tail=curr;
        }
        return data;
    }

    public boolean contains(int data){
        if(head == null)
            throw new RuntimeException("No data found!!!");
        Node curr = head;
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
        MyLinkedList ml2 = (MyLinkedList) obj;
        if(this.size()!=ml2.size())
            return false;
        Node curr1 = this.getHead();
        Node curr2 = ml2.getHead();
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
        Node curr = head;
        while(curr!=null){
            if(curr==tail)
                s+=curr.getData();
            else
                s+=curr.getData()+", ";
            curr = curr.getNext();
        }
        return s + " ]";
    }



    //Extra Methods/////////////
    public void addRec(int data){
        if(head==null){
            head=tail=new Node(data);
        }
        else addRec(head,data);
    }
    private void addRec(Node curr, int data) {
        if(curr.getNext()==null) {
            curr.setNext(new Node(data));
            tail = curr.getNext();
            return;
        }
        addRec(curr.getNext(),data);
    }

    public void addAll1(int ind , int[] elements){
        for(int i=0 ; i<elements.length ; i++)
            addByIndex(ind+i,elements[i]);
    }

    public void addAll2(int ind ,int[] elements){
        if(ind<1 || ind>size()+1)
            throw new RuntimeException("Out of list bounds");
        MyLinkedList ml2= new MyLinkedList();
        for(int i=0 ; i<elements.length ; i++)
            ml2.addLast(elements[i]);
        if(ind==1) {
            ml2.getTail().setNext(this.head);
            this.head = ml2.getHead();
        }
        else if(ind==size()+1){
            this.tail.setNext(ml2.getHead());
            this.tail = ml2.getTail();
        }
        else{
            Node curr = this.head;
            while(ind>2){
                curr = curr.getNext();
                ind--;
            }
            ml2.getTail().setNext(curr.getNext());
            curr.setNext(ml2.getHead());
        }
    }

    public int removeByIndex(int ind){
        if (head == null)
            throw new RuntimeException("There is no data!!!");
        if(ind<1 || ind>size())
            throw new NullPointerException("Out of link bounds");
        int data;
        if (ind == 1)
            data = removeFirst();
        else if(ind == size())
            data = removeLast();
        else {
            Node curr = head;
            while (ind > 2) {
                curr = curr.getNext();
                ind--;
            }
            data = curr.getNext().getData();
            curr.setNext(curr.getNext().getNext());
        }
        return data;
    }

    public int printMid() {
        if (head == null)
            throw new RuntimeException("No data found!!!");

        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.getNext() !=null){
            fast=fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow.getData();

    }

    public void rightShift1(int numOfShifts){
        if(head == null)
            throw new RuntimeException("No data found!!!");
        int num = numOfShifts%size();
        while(num>0){
            addFirst(removeLast());
            num--;
        }
    }

    public void leftShift1(int numOfShifts){
        if(head == null)
            throw new RuntimeException("No data found!!!");
        int num = numOfShifts%size();
        while(num>0){
            addLast(removeFirst());
            num--;
        }
    }

    public void rightShift2(int numOfShifts){
        if(head == null)
            throw new RuntimeException("No data found!!!");
        Node curr=head;
        tail.setNext(head);
        int n = size()-1-numOfShifts%size();
        while(n>0){
            curr=curr.getNext();
            n--;
        }
        head=curr.getNext();
        curr.setNext(null);
        tail=curr;

    }

    public void leftShift2(int numOfShifts){
        if(head == null)
            throw new RuntimeException("No data found!!!");
        if(numOfShifts%size()!=0) {
            Node curr = head;
            tail.setNext(head);
            int n = numOfShifts % size() - 1;
            while (n > 0) {
                curr = curr.getNext();
                n--;
            }
            head = curr.getNext();
            curr.setNext(null);
            tail = curr;
        }
    }

    public int indexOf(int data){
        if(head == null)
            throw new RuntimeException("No data found!!!");
        int ind = -1;
        Node curr = head;
        int i=1;
        while(curr!=null){
            if(curr.getData()==data){
                ind = i;
                break;
            }
            curr = curr.getNext();
            i++;
        }
        return ind;
    }

    public int lastIndexOf(int data){
        if(head == null)
            throw new RuntimeException("No data found!!!");
        int ind = -1;
        Node curr = head;
        int i=1;
        while(curr!=null){
            if(curr.getData()==data){
                ind = i;
            }
            curr = curr.getNext();
            i++;
        }
        return ind;
    }

    public MyLinkedList removeRange1(int ind1 , int ind2){
        if(head==null)
            throw new RuntimeException("No data found!!!");
        if(ind1>ind2 || (ind1<1&&ind1>size()) || (ind1<1&&ind1>size()))
            throw new NullPointerException("Out of link bounds");
        MyLinkedList ml2 = new MyLinkedList();
        int ind = ind1;
        while(ind1<=ind2){
            ml2.addLast(this.removeByIndex(ind));
            ind1++;
        }
        return ml2;

    }

    public MyLinkedList removeRange2(int ind1 , int ind2){
        if(head==null)
            throw new RuntimeException("No data found!!!");
        if(ind1>ind2 || (ind1<1&&ind1>size()) || (ind1<1&&ind1>size()))
            throw new NullPointerException("Out of link bounds");
        MyLinkedList ml2 = new MyLinkedList();
        //////////////////////////////////
        if(ind1==1 && ind2==size()){
            ml2.setHead(getHead());
            ml2.setTail(getTail());
            this.clear();
        }
        ///////////////////////////////

        else if(ind1==1){
            ml2.setHead(getHead());
            Node temp = head;
            while(ind2>1) {
                temp = temp.getNext();
                ind2--;
            }
            setHead(temp.getNext());
            temp.setNext(null);
            ml2.setTail(temp);
        }
        //////////////////////////////////

        else if(ind2==size()){
            Node curr = head;
            while(ind1>2){
                curr = curr.getNext();
                ind1--;
            }
            ml2.setHead(curr.getNext());
            curr.setNext(null);
            ml2.setTail(getTail());
            setTail(curr);

        }
        /////////////////////

        else {
            Node curr = head;
            Node temp = head;

            while (ind1 > 2) {
                curr = curr.getNext();
                ind1--;
            }
            while (ind2>1) {
                temp = temp.getNext();
                ind2--;
            }
            ml2.setHead(curr.getNext());
            curr.setNext(temp.getNext());
            temp.setNext(null);
            ml2.setTail(temp);
        }
        //////////////////////////////
        return ml2;

    }

    public MyLinkedList subList(int ind1 , int ind2){
        if(head==null)
            throw new RuntimeException("No data found!!!");
        if(ind1>ind2 || (ind1<1&&ind1>size()) || (ind1<1&&ind1>size()))
            throw new NullPointerException("Out of link bounds");
        MyLinkedList ml2 = new MyLinkedList();
        int ind = ind1;
        while(ind1<ind2){
            ml2.addLast(this.get(ind1));
            ind1++;
        }
        return ml2;
    }

    public int[] toArray(){
        if(head == null)
            throw new RuntimeException("No data found!!!");
        int [] arr =  new int[size()];
        Node curr = head;
        int i=0;
        while(curr!=null){
            arr[i++] = curr.getData();
            curr = curr.getNext();
        }
        return arr;
    }

    public void printRevRecursion(){
        if(head==null)
            return ;
        int temp  = removeFirst();
        printRevRecursion();
        System.out.print(temp+ " ");
        addFirst(temp);
        return;
    }

    public void revRecursion1(){
        if(head==null)
            return ;
        int temp  = removeFirst();
        revRecursion1();
        addLast(temp);
        return;
    }

    public void revRecursion2() {
        if(head==tail) {
            return;
        }
        Node temp = head;
        head = head.getNext();
        revRecursion2();
        tail.setNext(temp);
        tail = temp;
        tail.setNext(null);
        return;
    }

    public void swap(int index1,int index2){
        if(index1<1||index1<1||index2>size()||index1>size())
            return;
        if(head==tail || index1==index2)
            return;
        if(index1>index2) {
            int temp = index1;
            index1 = index2;
            index2 = temp;
        }

        Node curr1=head;
        Node curr2=head;
        Node pre1=null;
        Node pre2=null;

        for(int i=1 ; i<index1 ; i++) {
            curr1 = curr1.getNext();
            if (i < index1 - 1)
                pre1 = curr1;
        }
        for(int i=1 ; i<index2 ; i++) {
            curr2 = curr2.getNext();
            if (i < index2 - 1)
                pre2 = curr2;
        }

        pre1.setNext(curr2);
        pre2.setNext(curr1);
        Node temp = curr1.getNext();
        curr1.setNext(curr2.getNext());
        curr2.setNext(temp);
    }
}




