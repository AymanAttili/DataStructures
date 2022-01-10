package com.DataStructures.sort;

public class HeapSortTest {

    static int Heap_Size;

    private static void sort(int[] arr) {
        buildHeap(arr);
        for(int i=arr.length-1 ; i>0 ; i--){
            int temp = arr[i];
            arr[i]=arr[0];
            arr[0] = temp;
            Heap_Size--;
            heapify(arr,0);
        }
    }

    private static void buildHeap(int [] arr) {
        Heap_Size=arr.length;
        int lastParent = arr.length/2-1;
        for(int i= lastParent; i>=0 ; i--){
            heapify(arr,i);
        }
    }

    private static void heapify(int[] arr, int i) {
        int left = 2*i+1;
        int right = 2*i+2;
        int max = i;
        if(left<Heap_Size && arr[left]>arr[max])
            max=left;
        if(right<Heap_Size && arr[right]>arr[max])
            max=right;

        if(max!=i){
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr,max);
        }
    }


    public static void main(String[] args) {
        int []arr = {2,13,77,23,14,11,8,90,0};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        sort(arr);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }
}
