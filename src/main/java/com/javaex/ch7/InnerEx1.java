package com.javaex.ch7;

public class InnerEx1 {
    /*iv처럼 사용할 수 있는 인스턴스 내부 클래스*/
    class InstanceInnerClass {
        /*내부 클래스의 멤버*/
        int iv = 200;
//        static int cv = 100; //인스턴스 내부 클래스에는 static변수를 정의할 수 없다.
        final static int CONST = 100; //final변수에는 static을 붙일 수 있다.
    }

    static class StaticInnerClass {
        int iv = 200;
        static int cv = 200;    //static내부클래스에만 static멤버 정의 가능.
    }

    void myMethod() {
        class LocalInnerClass { //지역변수처럼 다뤄지는 local inner class
            int iv = 300;
//            static int cv = 300;  //당연히 불가능
            final static int CONST = 300;   //final static은 가능.
        }
    }

    public static void main(String[] args) {
        System.out.println("InstanceInnerClass.CONST : " + InstanceInnerClass.CONST);
        System.out.println("StaticInnerClass.cv : " + StaticInnerClass.cv );
    }
}
