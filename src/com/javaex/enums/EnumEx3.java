package com.javaex.enums;

public class EnumEx3 {
    public static void main(String[] args) {
        System.out.println("bus fare : " + Transportation.BUS.fare(100));
        System.out.println("train fare : " + Transportation.TRAIN.fare(100));
        System.out.println("ship fare : " + Transportation.SHIP.fare(100));
        System.out.println("airplane fare : " + Transportation.AIRPLANE.fare(100));
    }
}
enum Transportation {
    /*{}안에서 추상 메서드 구현*/
    BUS(100) {
        int fare(int distance) {
            return distance*BASIC_FARE;
        }
    },
    TRAIN(150) {
        int fare(int distance) {
            return distance*BASIC_FARE;
        }
    },
    SHIP(100){
        int fare(int distance) {
            return distance*BASIC_FARE;
        }
    },
    AIRPLANE(300){
        int fare(int distance) {
            return distance*BASIC_FARE;
        }
    };

    protected final int BASIC_FARE; //protected로 잡아야 상수에서 접근 가능

    Transportation(int basicFare) {
        BASIC_FARE = basicFare;
    }

    public int getBasicFare() {
        return BASIC_FARE;
    }

    /*추상 메서드*/
    abstract int fare(int distance);
}

