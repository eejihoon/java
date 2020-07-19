package com.easy.ex4;

public class ControlEx3 {
    public static void main(String[] args) {
        /*
         * [4-3] 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)을 계산하시오
         *
         * 풀이 :
         * 1     //1
         * 12    //4
         * 123   //7
         * 1234  //11
         * 12345 //16
         * 123456 //22
         * 1234567   //29
         * 12345678  //37
         * 123456789 //46
         *           //56
         * */
        int num = 0;
        int total = 0;
        for (int i=1; i<=10; i++) {
            System.out.println(i+"번 루프");
            num += i;
            //0 + 1 = 1
            //1 + 2 = 3
            //3 + 3 = 6
            //6 + 4 = 10
            //10 + 5 = 15
            //15 + 6 = 21
            //21 + 7 = 28
            //28 + 8 = 36
            //36 + 9 = 45
            //45 + 10 = 55
            //--------------> 55

            System.out.printf("%d + %d%n", total, num);
            total += num;

        }
        System.out.println(total);
    }
}
