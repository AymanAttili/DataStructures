package com.DataStructures.Sorting;

import java.util.Arrays;

public class MergeSortTest {
    ////Average complexity = O(nlog n)./////
    ////Space complexity = O(n)./////

    private static int[] merge(int[] a,int[] b){
        int i=0,j=0,k=0;
        int [] c = new int[a.length+b.length];

        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                c[k]=a[i];
                i++;
            }
            else {
                c[k] = b[j];
                j++;
            }
            k++;
        }

        while(i<a.length){
            c[k]=a[i];
            i++;
            k++;
        }
        while(j<b.length){
            c[k]=b[j];
            j++;
            k++;
        }
        return c;
    }

    private static int [] mergeSort(int [] arr){//we divide the given array into two sub-arrays and after sort them, we merge them.
        if(arr.length>1){
            int mid = arr.length/2;//the index of the middle of array.
            int[] a = Arrays.copyOfRange(arr,0,mid);//subArray no.1 (from begin to middle).
            int[] b = Arrays.copyOfRange(arr,mid,arr.length);//subArray no.2 (from middle to end).
            a = mergeSort(a);//to sort the first subArray.
            b = mergeSort(b);//to sort the first subArray.

            arr = merge(a,b);//to merge the 2 subArrays in one array.
        }
        return arr;
    }

    public static void main(String[] args) {
        int []a = {14,2,7,19,22,1,21,7};
        a = mergeSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
