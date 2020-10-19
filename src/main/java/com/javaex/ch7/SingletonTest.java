package com.javaex.ch7;
final class Singleton {
    private Singleton() {}

    public static Singleton getInstance() {
        return new Singleton();
    }
}

public class SingletonTest {
    public static void main(String[] args) {
//        Singleton singleton = new Singleton(); //ERROR
        Singleton singleton = Singleton.getInstance();
    }
}
