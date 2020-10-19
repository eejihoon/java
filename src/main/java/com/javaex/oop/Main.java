package com.javaex.oop;

class Nemo extends Animals implements Swimable {

    @Override
    void feed() {
    }

    @Override
    void eat() {

    }

    @Override
    void run() {
    }

    @Override
    public void swim() {
    }
}

class AngryBird extends Animals implements Flyable {

    @Override
    void feed() {

    }

    @Override
    void eat() {

    }

    @Override
    void run() {

    }

    @Override
    public void fly() {

    }
}

class Bolt extends Animals implements Runnable {

    @Override
    void feed() {

    }

    @Override
    void eat() {

    }

    @Override
    public void run() {

    }
}

class MCQueen extends Machines implements Runnable {

    @Override
    void maintennance() {

    }

    @Override
    void support() {

    }

    @Override
    void used() {

    }

    @Override
    public void run() {

    }
}

class Siddeley extends Machines implements Flyable {

    @Override
    public void fly() {

    }

    @Override
    void maintennance() {

    }

    @Override
    void support() {
    }

    @Override
    void used() {

    }
}

public class Main {
    public static void main(String[] args) {
        Animals nemo = new Nemo();
        Swimable nemo2 = new Nemo();

        System.out.println(nemo2);
    }

}
