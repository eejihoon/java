package com.algorithm;

/*
*   1부터 100까지 숫자를 출력하는데,
*   3, 6, 9가 한 번씩 들어가는 숫자는 '*'로 출력하고,
*   두 번씩 들어가는 숫자(33, 96, ...)는 '**'로 출력한다.
*   그 외 숫자는 그냥 숫자를 출력한다.
 *
* */
public class ThreeSixNineGame {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            int firstNumber = i / 10;
            int secondNumber = i >= 10 ? i % 10 : i;

            boolean is306090 = is369(firstNumber);
            boolean is369 = is369(secondNumber);

            if (getStar(is369, is306090) != "") {
                System.out.println(getStar(is369, is306090));
            } else {
                System.out.println(i);
            }
        } //for
    }

    /*
    *   입력값이 3, 6, 9 중 하나라면 true를 반환한다.
    * */
    static boolean is369(int number) {
        return number == 3 || number == 6 || number == 9;
    }

    /*
    * 입력값이 모두 true면 **을, 하나만 true면 *을 리턴한다.
    * */
    static String getStar(boolean is369, boolean is306090) {
        if (is369 && is306090) {
            return "**";
        } else if (is369 || is306090) {
            return "*";
        }
        return "";
    }
}
