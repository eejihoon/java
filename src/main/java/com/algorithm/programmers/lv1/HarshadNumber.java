package com.algorithm.programmers.lv1;

import java.util.Scanner;

/*
*   양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 한다.
*   예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수가 맞다.
*   자연수 x를 입력 받아 x가 하샤드 수인지 아닌지 검사하는 함수 solution을 완성한다.
* */
public class HarshadNumber {
        public static void main(String[] args) {
            Solution solution = new Solution();
            Scanner sc = new Scanner(System.in);

            System.out.println("숫자를 입력하세요.");
            int num = sc.nextInt();
            boolean result = solution.solution(num);
            System.out.println("결과는 " + result);
            sc.close();
        }
}

class Solution {
    public boolean solution(int x) {
        if(x > 10000 || x < 0)
            throw new IllegalArgumentException();
        return checkHarshadNumber(x);
    }

    /*
    *   입력 받은 숫자를 자릿수별로 분리해서 더한 수를 반환한다.
    * */
    public boolean checkHarshadNumber(int number) {
        int num = number;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return number%sum == 0 ? true: false;
    }
}