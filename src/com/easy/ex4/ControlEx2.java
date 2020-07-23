package com.easy.ex4;

public class ControlEx2 {
    public static void main(String[] args) {
        /*
         * 4-2 연습문제
         *   1부터 20까지 정수 중, 2 또는 3의 배수가 아닌 수의 총합을 구하시오.
         *   풀이:
         *   1.반복문으로 1부터 20까지 loop를 돌린다.
         *   2.if문 또는 삼항 연산자로 2의 배수와 3의 배수를 거른다.
         * */
        for(int i=1; i<=20; i++) { //4-2
            System.out.println(i%2 == 0 || i%3==0 ? "" : i);
        }
    }
}
