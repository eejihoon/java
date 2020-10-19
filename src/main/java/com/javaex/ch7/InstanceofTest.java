package com.javaex.ch7;

public class InstanceofTest{
    public static void main(String[] args) {
        MotorCyle motorCycle = new MotorCyle();

        if(motorCycle instanceof MotorCyle) {
            System.out.println("MotorCyle Instance");
        }
        if(motorCycle instanceof Cycle) {
            System.out.println("Cycle Instance");
        }
        if(motorCycle instanceof Object) {
            System.out.println("Object Instance");
        }
    }
}

class Cycle {}
class MotorCyle extends Cycle{}