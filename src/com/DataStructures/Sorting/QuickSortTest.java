package com.DataStructures.Sorting;

import java.util.Arrays;

public class QuickSortTest {

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


    ///pivot is the first element////////
    public static void sort1(int[] arr){
        sort1(arr,0,arr.length-1);
    }

    private static void sort1(int[] arr , int start , int end){
        if(start>=end)
            return;
        int l = start;
        int r = end;
        int pivot = arr[start];
        boolean left = true;
        while(l<r){
            while(arr[l]<pivot) {
                l++;
                left = false;
            }
            while(arr[r]>pivot) {
                r--;
                left = true;
            }
            swap(arr,l,r);
            if(left)
                l++;
            else
                r--;
        }
        sort1(arr,start,l-1);
        sort1(arr,r+1,end);
    }



    ///pivot is the middle element/////////
    public static void sort2(int[] arr){
        sort2(arr,0,arr.length-1);
    }
    public static void sort2(int[] arr , int start , int end) {
        if(start>=end)
            return;
        int l = start;
        int r = end;
        int mid = (start+end)/2;
        int pivot = arr[mid];
        while(l<r){
            while(arr[l]<pivot)
                l++;
            while(arr[r]>pivot)
                r--;
            if(r<l)
                break;
            swap(arr,l++,r--);
        }
        sort2(arr,start,r);
        sort2(arr,l,end);
    }




    ///pivot is the last element////////
    public static void sort3(int[] arr){
        sort3(arr,0,arr.length-1);
    }
    public static void sort3(int[] arr , int start , int end) {
        if(start>=end)
            return;
        int l = start;
        int r = end;
        int pivot = arr[end];
        boolean left = true;
        while(l<r){
            while(arr[l]<pivot) {
                l++;
                left = false;
            }
            while(arr[r]>pivot) {
                r--;
                left = true;
            }
            swap(arr,l,r);
            if(left)
                l++;
            else
                r--;
        }
        sort3(arr,start,l-1);
        sort3(arr,r+1,end);
    }


    public static void main(String[] args) {
        int [] arr = {2,4,1,7,9,9,4};
        System.out.println(Arrays.toString(arr));
        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
