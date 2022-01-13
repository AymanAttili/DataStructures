package com.DataStructures.Sorting;

import java.util.Arrays;

public class InsertionSortTest {

    private static void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j --;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int []arr = {2,13,77,23,14,11,8,90,0};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
