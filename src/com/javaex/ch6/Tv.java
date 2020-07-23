package com.javaex.ch6;

public class Tv {
    public static void main(String[] args) {
        TvProps tv = new TvProps();
        TvProps tv2 = new TvProps();

        tv.channelUp(); //2
        tv.channelUp(); //3
        tv.channelUp(); //4

        tv2.channelUp(); //2

        System.out.println("tv.channel : " + tv.getChannel());

        System.out.println("tv2.channel : " + tv2.getChannel());

        tv.channelDown();

        System.out.println("tv.channel : " + tv.getChannel());

        /* 참조하는 객체의 주소가 다르다. */
        System.out.println("==========before========");
        System.out.println("tv : " + tv);
        System.out.println("tv2: " + tv2);

        /*tv2에 tv를 주입한다.*/
        tv2 = tv;

        /* 참조하는 객체의 주소가 같다. */
        System.out.println("==========After========");
        System.out.println("tv : " + tv);
        System.out.println("tv2: " + tv2);
    }
}
