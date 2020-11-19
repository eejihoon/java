package com.algorithm.sort;

import java.util.Arrays;

public class SelectionSort {
    /**
    * 배열 array와 array의 두 인덱스(i, j)를 매개변수로 받아서 
    * i번 인덱스와 j번 인덱스에 저장된 요소를 바꾸는 메소드
    */
    public static void swapElements(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;     
    }

    /**`
     *  배열 array와 start값을 매개변수로 받는다.
     *  array[]의 start번째 인덱스부터 시작하여 마지막 인덱스까지 반복하면서
     *  가장 작은 값이 저장된 인덱스를 찾는다. 
     */
    public static int indexLowest(int[] array, int start) {
        /**
         *  가장 작은 값을 가진 인덱스를 저장할 변수
         *  일단 start번째 인덱스가 가장 작은 값을 가진 인덱스라고 가정한다.
         */
        int lowIndex = start;
        
        /**
         *  start번째 인덱스부터 배열의 끝까지 반복
         *  두 인덱스를 비교하고, 더 작은 값을 가지고 있는 인덱스를
         *  lowIndex에 저장한다.
         */
        for (int i = start; i<array.length;i++){
            if (array[i] < array[lowIndex]) {
                lowIndex = i;
            }
        } //for

        //가장 작은 값을 가진 인덱스를 리턴
        return lowIndex;
    } //indexLowest() 

    /**
     *  선택정렬으로 요소를 정렬하는 메소드
     *  오름차순ascending으로 정렬한다.
     */
    public static void selectionSort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int j = indexLowest(array, i);
            swapElements(array, i, j);
        }
    } //selectionSort()

    public static void main(String[] args) {
        int[] arr = {5,2,67,8,3,2,4,6,89,0,5,2,35,1};

        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
