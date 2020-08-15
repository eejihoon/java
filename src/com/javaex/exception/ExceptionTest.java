package com.javaex.exception;

import java.io.IOException;
import java.util.List;

public class ExceptionTest {
    public static void main(String[] args) {
        int number = 5;
        int result = 0;

        for(int i = 0; i < 10; i ++) {
            try{
                result = number / (int)(Math.random() * 10);
                System.out.println(result);
            } catch (ArithmeticException ae) {
                System.out.println("예외");
            }
        }
    }
}

