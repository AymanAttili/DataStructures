package com.DataStructures.Sorting;

import java.util.Arrays;

public class SelectionSortTest {
    ////Average complexity = O(n^2)./////
    ////Space complexity = O(1)./////

    private static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int []arr = {2,13,77,23,14,11,8,90,0};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
