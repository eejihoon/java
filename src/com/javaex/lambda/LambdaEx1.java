//package com.javaex.lambda;
//
//@FunctionalInterface
//interface MyFunction {
//    void run(); //public abstract 생략
//}
//
//public class LambdaEx1 {
//    static void execute(MyFunction f) {
//        f.run();
//    }
//
//    static MyFunction getMyFunction() {
//        return () -> System.out.println("f3.run()");
//    }
//
//    public static void main(String[] args) {
//        //람다로 MyFunction의 run()구현
//        MyFunction f1 = () -> System.out.println("f1.run()");
//
//        MyFunction f2 = new MyFunction() {
//            @Override
//            public void run() {
//                System.out.println("f2.run().....익명클래스....");
//            }
//        };
//
//        MyFunction f3 = getMyFunction();
//
//        f1.run();
//        f2.run();
//        f3.run();
//
//        execute(()-> System.out.println("parameter type is functional interface..."));
//    }
//}
