package com.javaex.lambda;

public class CoffeeMain {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine() {
            @Override
            public String getCoffee(int coin) {
                return coin+"원 커피";
            }
        };

        //람다로 구현
        CoffeeMachine lambdaMachine = coin -> coin+"원 커피";

        System.out.println(machine.getCoffee(2000));
        System.out.println(lambdaMachine.getCoffee(5000));
    }
}

