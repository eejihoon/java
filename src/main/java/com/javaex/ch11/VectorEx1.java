package com.javaex.ch11;

import java.util.Vector;

public class VectorEx1 {
    public static void main(String[] args) {
        Vector vector = new Vector(5);  //Capacity가 5인 Vector객체
        vector.add("1");
        vector.add("2");
        vector.add("3");
        print(vector);

        vector.trimToSize();    //빈공간 없앤다.
        System.out.println("============================AFTER trimToSize()");
        print(vector);

        vector.ensureCapacity(6);
        System.out.println("============================after ensureCapacity(6)");
        print(vector);

        vector.setSize(7);
        System.out.println("================================setSize(7)");
        print(vector);

        vector.clear();
        System.out.println("==================================clear()");
        print(vector);

    }

    static void print(Vector vector) {
        System.out.println("===============================================");
        System.out.println(vector);
        System.out.println("size : " + vector.size());
        System.out.println("capacity : " + vector.capacity());
    }

}
