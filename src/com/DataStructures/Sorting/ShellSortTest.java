package com.DataStructures.Sorting;

import java.util.Arrays;

public class ShellSortTest {

    private static void shellSort(int[] arr){
        int n = arr.length;
        int gap = n/2;
        while(gap>0){
            for(int i=gap ; i<n ; i++){
                int key = arr[i];
                int j = i-gap;
                while (j>=0 && arr[j] > key){
                    arr[j+gap] = arr[j];
                    j-=gap;
                }
                arr[j + gap] = key;
            }
            gap/=2;
        }

    }

    public static void main(String[] args) {
        int []arr = {2,13,77,23,14,11,8,90,0};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
