
# 선택정렬 SelectionSort
## 전체 코드
```java
package com.algorithm;

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

    /**
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
}

```
 ## swapElements 메서드
  첫 번째 메서드 ```swapElements```는 배열에 있는 두 요소의 값을 바꾼다. 요소를 읽고 쓰는 것은 상수 시간 연산이다. 요소의 크기와 첫 번째 위치를 알고 있다면 한 번의 곱셈과 덧셈으로 어떤 요소의 위치라도 알 수 있다. ```swapElements``` 메서드에 있는 모든 연산이 상수 시간이다. 따라서 전체 메서드는 상수 시간이 된다.

 ## indexLowest 메서드
  두 번째 메서드 ```indexLoswest```는 주어진 위치인 start에서 시작하여 배열에 있는 가장 작은 요소 인덱스를 찾는다. **반복문을 돌 때마다 배열의 두 요소에 접근하고 한 번의 비교 연산을 한다.** 이것은 모두 상수 시간 연산이다. 그러므로 어느 것을 세든 중요하지 않다. 간단하게 비교 횟수를 센다면,
  1. ```start```인자가 0이면 ```indexLow```메서드는 전체 배열을 검색하고 전체 비교 횟수는 배열 길이인 n이 된다.
  2. ```start```인자가 1이면 비교 횟수는 n-1이 된다.
  3. 일반적으로 비교 횟수는 n-start가 되어 ```indexLowest``` 메서드는 선형이 된다.

  ## selectionSort 메서드
   배열을 정렬하는 메서드다. 0에서 n-1까지 반복하므로 n번 반복 실행된다. 매번 ```indexLowest```메서드를 호출하고 상수 시간 연산인 ```swapElements```를 실행한다.
   ```indexLowest```메서드가 처음 호출되면 n번 비교 연산 한다. 두 번째는 n-1번, 이런 식으로 n-2, n-3...번 비교 연산한다. 이렇게 했을 때 총 비교 횟수는 n + n-1 + n-2 + n-3 + n-4 ... + 1 + 0이다.
   이 수열의 합은 n(n+1)/2이고, n^2에 비례한다. 이것은 selectionSort메서드가 이차라는 것을 말한다.