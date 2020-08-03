package com.javaex.lambda;

public class LambdaEx3 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        inner.method(100);
    }
}


@FunctionalInterface
interface MyFunction{
    void myMethod();
}

class Outer {
    int val = 10;   //Outer.this.val

    class Inner {
        int val = 20;   //this.val

        void method(int i) {    //(final int i)
            int val = 30;   //final int val = 30;
//            i = 10;       //final이므로 변경 불가

            MyFunction f = () -> {
                System.out.println("i : "+ i);
                System.out.println("val : " + val);
                System.out.println("this.val : " + ++this.val);
                System.out.println("Outer.this.val : " + Outer.this.val);
            };

            f.myMethod();
        }
    }
}
