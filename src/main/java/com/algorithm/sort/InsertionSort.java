package com.algorithm.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {6,2,7,89,3,233,5,3,37,8,9,0,4,2};

        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    private static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int prev = i - 1;

            while ((prev >= 0) && (arr[prev] > temp)) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = temp;
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
}
