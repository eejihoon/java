package com.javaex.ch6;

class Ironman2{
    boolean power;
    int strong;

    Ironman2(boolean power, int strong) {
        this.power = power;
        this.strong = strong;
    }

}

public class Avengers2 {
    public static void main(String[] args) {
        Ironman2 iron = new Ironman2(true, 100);
        System.out.println(iron.power);
        System.out.println(iron.strong);
    }
}
