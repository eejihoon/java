package com.javaex.ch7;
class Car {
    String color;
    int door;

    void drive() {
        System.out.println("drive, brrr....");
    }

    void stop() {
        System.out.println("stop...");
    }
}

class FireEngine extends Car {
    void water() {
        System.out.println("water...");
    }
}
public class CastingTest {
    public static void main(String[] args) {
        Car car = null;
        //FireEngine fire = (FireEngine)new Car(); //ERROR
        FireEngine fireEngine = new FireEngine();
        FireEngine fireEngine2 = new FireEngine();
        fireEngine.water();

        car = fireEngine;
        //car.warter //사용 불가
        car.stop();
        fireEngine2 = (FireEngine)car;
        fireEngine2.water();
    }
}
