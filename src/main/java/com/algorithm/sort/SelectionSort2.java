package com.algorithm.sort;

import java.util.Arrays;

public class SelectionSort2 {
    public static void main(String[] args) {
        int[] arr = {6,2,36,7,8,9,2,124,65,74,3,2,1,6,8,9,0};

        System.out.println(Arrays.toString(selectionSort(arr)));

    }

    static int[] selectionSort(int[] arr) {
        int minIndex;
        int temp;

        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i+1; j <arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        } //for

        return arr;
    }

}
