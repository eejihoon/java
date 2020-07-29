package com.javaex.ch11;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList(10);    //크기 10

        list1.add(new Integer(5));
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));

        //list2를 list1[1]~list1[4]사이의 값으로 초기화한다.(from포함, to미포함)
        ArrayList list2 = new ArrayList(list1.subList(1,4));
        print(list1, list2);

        /*오름차순 정렬*/
        Collections.sort(list1);
        Collections.sort(list2);
        print(list1, list2);

        System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));


        /*
         * add(int index, Object element)와
         * set(int Index, Object element)의 차이
         * 
         * add()는 기존의 값을 한 칸씩 뒤로 미루고,
         * set은 기존의 값을 지운다.
         * */
        list2.add("B");
        list2.add("C");
        list2.add(3,"A");

        System.out.println("-------------------------------");
        System.out.println("list2 : " + list2);

        list2.set(3, "AA");

        System.out.println("-------------------------------");
        System.out.println("list2 : " +list2);

        /*list1과 list2를 비교하여 공통된 것만 남기고 모두 지운다.*/
        System.out.println("list1.retainAll(list2) : " +list1.retainAll(list2));

        print(list1, list2);

        /*
        * 변수 i를 증가시키면서 삭제하면 한 요소가 삭제될 때마다,
        * 빈 공간을 채우기 위해 나머지 요소들이 자리 이동을 하므로
        * 올바른 결과를 얻을 수 없다.
        * */
        //list2에서 list1에 포함된 객체들을 삭제한다.
        for (int i = list2.size()-1; i >= 0; i--) {
            if (list1.contains(list2.get(i))) {
                System.out.println("list2.get(i) : " + list2.get(i));
                list2.remove(i);
            }
        }


        print(list1, list2);

    }   //main()

    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("-------------------------------");
        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
    }
} // end - class
