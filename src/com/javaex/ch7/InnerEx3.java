package com.javaex.ch7;

public class InnerEx3 {
    private int outerIv = 0;
    private int outerCv = 0;

    class InstanceInnerClass{
        int innerInstance = outerIv;  //외부클래스의 private 멤버로 접근할 수 있다.
        int innerInstance2 = outerCv;
    }

    static class StaticInnerClass {
        /*static클래스는 외부클래스의 인스턴스 멤버에 접근할 수 없다.
        int staticIv = outerIv;*/
    }

    void myMethod() {
        int lv = 0;
        final int LV = 0;   //fianl생략 가능

        class LocalInner {
            int localClassIv = outerIv;
            int localClassIv2 = outerCv;


            /*외부클래스의 지역변수는 fianl변수만 가능하지만
            fianl이 붙지 않은 변수의 경우 컴파일러가 자동으로 붙인다.*/
            int localClassIv3 = lv;
            int localClassIv4 = LV;
        }
    }

}
