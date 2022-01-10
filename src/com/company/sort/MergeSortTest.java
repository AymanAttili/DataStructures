package com.company.sort;

import java.util.Arrays;

public class MergeSortTest {
    public static int[] merge(int[] a,int[] b){
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
    public static int [] mergeSort(int [] arr){
        if(arr.length>1){
            int mid = arr.length/2;
            int[] a = Arrays.copyOfRange(arr,0,mid);
            int[] b = Arrays.copyOfRange(arr,mid,arr.length);
            a = mergeSort(a);
            b = mergeSort(b);

            arr = merge(a,b);
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
