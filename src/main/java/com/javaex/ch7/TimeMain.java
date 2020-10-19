package com.javaex.ch7;

public class TimeMain {
    public static void main(String[] args) {
        Time time = new Time(13, 47, 22);
        //time.hour = 22; 이제 이런식으로 수정하지 않는다.
        time.setHour(time.getHour()+1);
        System.out.println(time);
    }
}
