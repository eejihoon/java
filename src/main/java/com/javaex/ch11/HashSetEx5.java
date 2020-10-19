package com.javaex.ch11;

import java.util.HashSet;
import java.util.Iterator;

//교집합, 차집합, 합집합
public class HashSetEx5 {
    public static void main(String[] args) {
        HashSet setA = new HashSet();
        HashSet setB = new HashSet();
        HashSet union = new HashSet();
        HashSet intersection = new HashSet();
        HashSet relativeA = new HashSet();
        HashSet relativeB = new HashSet();


        setA.add("1");
        setA.add("2");
        setA.add("3");
        setA.add("4");
        setA.add("5");

        setB.add("4");
        setB.add("5");
        setB.add("6");
        setB.add("7");
        setB.add("8");

        Iterator iterator = setB.iterator();
        while (iterator.hasNext()) {
            Object tmp = iterator.next();
            if(setA.contains(tmp)) { intersection.add(tmp); }
        }

        iterator = setA.iterator();
        while (iterator.hasNext()) {
            Object tmp = iterator.next();
            if(!setB.contains(tmp)) { relativeA.add(tmp); }
        }

        iterator = setB.iterator();
        while(iterator.hasNext()) {
            Object tmp = iterator.next();
            if(!setA.contains(tmp)){ relativeB.add(tmp); }
        }

        iterator = setA.iterator();
        while(iterator.hasNext()) {
            union.add(iterator.next());
        }

        iterator = setB.iterator();
        while(iterator.hasNext()) {
            union.add(iterator.next());
        }

        System.out.println("A : " + setA);
        System.out.println("B : " + setB);
        System.out.println("교집합 A ∩ B : " + intersection);
        System.out.println("합집합 A ∪ B : " + union);
        System.out.println("차집합 A - B : " + relativeA);
        System.out.println("차집합 B - A : " + relativeB);
    }
}
