package com.DataStructures.Generic.LinkedLists;


import java.util.*;

public class linkedListMethods {

    ////A method that reverses the given linked list (recursion).

    public static void revLL(LinkedList<Integer> l){
        if(l.isEmpty())
            return ;
        int temp = l.remove(0);
        revLL(l);
        l.add(temp);
    }


    ////A method that merge two sorted linked lists with keeping the resultant linked list sorted.

    public static MyLinkedList<Integer> mergeSorted(MyLinkedList<Integer> l1 , MyLinkedList<Integer> l2) {
        MyLinkedList<Integer> l3 = new MyLinkedList<Integer>();
        Node curr1 = l1.getHead();
        Node curr2 = l2.getHead();
        while (curr1 != null && curr2 != null) {
            if ((Integer) curr1.getData() < (Integer) curr2.getData()) {
                l3.addLast((Integer) curr1.getData());
                curr1 = curr1.getNext();
            } else{
                l3.addLast((Integer) curr2.getData());
                curr2 = curr2.getNext();
            }
        }
        while(curr1!=null){
            l3.addLast((Integer) curr1.getData());
            curr1 = curr1.getNext();
        }

        while(curr2!=null){
            l3.addLast((Integer) curr2.getData());
            curr2 = curr2.getNext();
        }

        return l3;
    }


    ////A method that converts boolean linked list to integer (True--> 1  , False--> 0).

    public static int toInt(MyLinkedList<Boolean> x){
        int z=0,y=0,i=0;
        Node curr = x.getHead();
        while(curr!=null){
            z*=10;
            boolean e = (Boolean)curr.getData();
            if(e)
                z+=1;
            curr = curr.getNext();
        }
        while(z>0){
            if(z%10==1)
                y+=Math.pow(2,i);
            z/=10;
            i++;
        }
        return y;
    }
}
