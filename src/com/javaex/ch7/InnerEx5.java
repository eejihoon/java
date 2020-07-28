package com.javaex.ch7;


class OuterClass {
    int value = 10; //OuterClass.this.value

    class Inner {
        int value = 20; //this.value

        void testMethod() {
            int value = 30;
            System.out.println("value : " + value);
            System.out.println("this.value : " + this.value);
            System.out.println("OuterClass.this.value : " + OuterClass.this.value);
        }
    } //inner
} //end-class

public class InnerEx5 {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.Inner inner = outer.new Inner();

        inner.testMethod();
    }
}
