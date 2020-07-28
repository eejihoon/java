package com.javaex.ch7;

public class InnerEx2 {
    /*내부 클래스 선언*/
    class InstanceInner {}
    static class StaticInner {}

    /*인스턴스멤버 간에는 직접 접근 가능*/
    InstanceInner iv = new InstanceInner();

    /*static멤버 간에는 직접 접근 가능*/
    static StaticInner cv = new StaticInner();

    static void staticMethod() {
        /*static멤버는 인스턴스 멤버에 직접 접근할 수 없다.
        static멤버가 생성된 시점에 인스턴스가 존재하지 않을 수 있기 때문에.
        InstanceInner obj1 = new InstanceInner();*/

        StaticInner obj = new StaticInner();

        /*굳이 접근하려면 아래와 같이 객체를 생성해야 한다.
        * 인스턴스클래스는 외부 클래스를 먼저 생성해야만 생성할 수 있다.*/
        InnerEx2 outer = new InnerEx2();
        InstanceInner obj1 = outer.new InstanceInner();
    }

    void intanceMethod() {
        //인스턴스 메서드에서는 인스턴스 멤버와 static멤버 모두 접근 가능
        InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();
    }

    void myMethod() {
        class LocalInner {
            //...
        }

        LocalInner localInner = new LocalInner();
    }
}

