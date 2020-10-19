package com.javaex.ch7;

class Outer {
    class InstanceInner {
        int iv = 100;
    }

    static class StaticInner {
        int iv = 200;
        static int cv = 300;
    }

    void myMethod() {
        class LocalInner {
            int iv = 400;
        }
    }
}

public class InnerEx4 {
    public static void main(String[] args) {
        /*
        * 인스턴스내부클래스의 인스턴스를 생성하려면
        * 외부클래스의 인스턴스가 먼저 필요하다.
        * */
        Outer outer = new Outer();
        Outer.InstanceInner instanceInner = outer.new InstanceInner();

        System.out.println("instanceInner.iv : " + instanceInner.iv);
        System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);

        /*static 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도 된다.*/
        Outer.StaticInner staticInner = new Outer.StaticInner();
        System.out.println("staticInner.iv : " + staticInner.iv);
        System.out.println("staticInner.iv : " + staticInner);
    }
}
