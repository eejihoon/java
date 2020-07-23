package com.javaex.ch6;

import java.awt.*;

class ColorBall {

    String ballColor;

    /* 어떤 색의 공이든 노란색 공으로 바꾸는 메서드 */
    String ballColorChange(String ball) { //선언부 return type - method name(parameter type)
        ball = "YellowBall";
        return ball;
    }
}

public class MethodEx {
    public static void main(String[] args) {

        ColorBall ball = new ColorBall();

        String ball1 = ball.ballColor = "red ball";
        String ball2 = ball.ballColor = "blue ball";

        System.out.println("----------before------------");
        System.out.println("ball1 : " + ball1);
        System.out.println("ball2 : " + ball2);

        System.out.println("-----------after------------");
        System.out.println("ball1 : " + ball.ballColorChange(ball1));
        System.out.println("ball2 : " + ball.ballColorChange(ball2));

    }
}
