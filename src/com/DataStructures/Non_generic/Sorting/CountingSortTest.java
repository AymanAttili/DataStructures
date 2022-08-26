package com.DataStructures.Non_generic.Sorting;

public class CountingSortTest {
    ////Average complexity = O(n+k) {where k is the largest element in array}./////
    ////Space complexity = O(k)./////

    private static void sort(int[] a){
        int [] b = new int[a.length];
        int k = maX(a);
        int c[] = new int[k+1];// Initialize count array with all zeros.

        for(int i=0 ; i<a.length ; i++)// Store the count of each element
            c[a[i]]++;

        for(int i=1 ; i<=k ; i++)// Store the cumulative count of each array
            c[i]+=c[i-1];

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for(int i=a.length-1 ; i>=0 ; i--){
            b[c[a[i]]-1]=a[i];
            c[a[i]]--;
        }

        for(int i=0 ; i<a.length ; i++)// Copy the sorted elements into original array
            a[i]=b[i];
    }

    private static int maX(int[] arr) {// Find the largest element of the array
        int mx=0;
        for(int i=0 ; i< arr.length ; i++){
            mx = Math.max(mx,arr[i]);
        }
        return mx;
    }


    public static void main(String[] args) {
        int []a = {2,13,77,23,14,11,8,90,0};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
        sort(a);
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }
}
