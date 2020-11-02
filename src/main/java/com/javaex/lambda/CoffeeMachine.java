package com.javaex.lambda;

@FunctionalInterface
public interface CoffeeMachine {
    public abstract String getCoffee(int coin);
}