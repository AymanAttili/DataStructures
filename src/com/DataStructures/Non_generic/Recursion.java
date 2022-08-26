package com.DataStructures.Non_generic;

import com.DataStructures.Generic.Queues.MyQueue;

import java.util.*;
import java.lang.*;

public class Recursion {


    ///////A method that reverses the array

    public static void revArray(int[] arr){
        revArray(arr,0);
    }
    public static void revArray(int[] arr,int i){
        if(i>=arr.length-1-i)
            return;
        int temp = arr[i];
        arr[i]=arr[arr.length-1-i];
        arr[arr.length-1-i] = temp;
        revArray(arr,i+1);
    }


    ///////A recursive binary search method.

    public static boolean binarySearch(int[] arr,int target){
        return binarySearch(arr,target,0,arr[arr.length-1]);
    }
    private static boolean binarySearch(int[] arr,int target , int l, int r) {
        if(l>r)
            return false;
        int mid = (r-l)/2;
        if(arr[mid]>target)
            return binarySearch(arr,target,l,mid-1);
        if(arr[mid]<target)
            return binarySearch(arr,target,mid+1,r);
        return true;
    }


    ////A method to compute x^n for a positive integer n.

    public static int power(int x , int n){
        if(n==0)
            return 1;
        return x*power(x,n-1);
    }


    ////A method to reverse a string.

    public static String revString(String str){
        if(str.length()<=1)
            return str;
        return revString(str.substring(1))+str.charAt(0);
    }


    ////A method to compute the GCD (greatest common divisor).

    public static int GCD(int x , int y){
        if(y==0)
            return x;
        return GCD(y,x%y);
    }


    ////A method checks if a string is palindrome.

    public static boolean isPalindrome(String str){
        if(str.length()<=1){
            return true;
        }
        if(str.charAt(0)==str.charAt(str.length()-1))
            return isPalindrome(str.substring(1,str.length()-1));
        return false;
    }


    ////A method that removes the middle element in the stack(recursion).

    public static void removeMidOfStack(Stack<Integer> s){
        removeMidOfStack(s,s.size());
    }
    private static void removeMidOfStack(Stack<Integer> s, int size) {
        if(size%2!=0)
            size++;
        if(s.size()==size/2) {
            s.pop();
            return;
        }
        int temp = s.pop();
        removeMidOfStack(s,size);
        s.push(temp);
    }


    ////A method that reverses the given linked list.

    public static void revLL(LinkedList<Integer> l){
        if(l.isEmpty())
            return ;
        int temp = l.remove(0);
        revLL(l);
        l.add(temp);
    }


    /////A method to find the occurrence of a specific character in a string

    public static int occ(String str , char c){
        if(str.length()==0)
            return 0;
        if(str.charAt(0)==c)
            return 1 + occ(str.substring(1),c);
        return occ(str.substring(1),c);
    }


    ////A method that reverses the given stack.

    public static void revStack(Stack<Integer> s){
        if(!s.isEmpty()) {
            int temp = s.pop();
            revStack(s);
            putBottom(s,temp);
        }
        return;
    }


    ////to put the element x int the bottom of stack.

    private static void putBottom(Stack<Integer> s, int x){
        if(s.isEmpty())
            s.push(x);
        else{
            int temp = s.pop();
            putBottom(s,x);
            s.push(temp);
        }
    }


    ////A method that reverses the queue(recursion).

    public static void revQueue(MyQueue q){
        if(q.isEmpty())
            return;
        int temp = q.dequeue();
        revQueue(q);
        q.enqueue(temp);
    }


}
