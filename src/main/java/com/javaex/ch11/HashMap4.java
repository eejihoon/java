package com.javaex.ch11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMap4 {
    public static void main(String[] args) {
        String[] data = {"A","K","A","K","D","K","A","K","K","K","Z","D"};

        HashMap map = new HashMap();

        for(int i=0; i < data.length; i++) {
            if(map.containsKey(data[i])) { //map에 저장된 key 중에 data[i]가 있다면,
                Integer value = (Integer)map.get(data[i]);  //key의 value를 Integer에 저장.
                /*
                ???value.intValue()와 value의 결과값이 같은데 왜 intValue()를 쓸까?
                */
                map.put(data[i], value.intValue() + 1); //map에 data[i]와, value+1 값을 저장
            } else {
                map.put(data[i], 1);   //없다면 map에 data[i]의 값과, 1을 저장
            }
        } // end - for

        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry entry =(Map.Entry) iterator.next();
            int value = ((Integer)entry.getValue()).intValue();
//            System.out.println("entry.getKey() : " + entry.getKey());
//            System.out.println("entry.getValue() : " + entry.getValue());
            System.out.println(entry.getKey() + " : " + printBar('#',value)+ " " + value);
        }
    } //main()

    public static String printBar(char ch, int value) {
        char[] bar = new char[value];

        for (int i = 0; i < bar.length; i++) {
            bar[i] = ch;
        }
            return new String(bar);
    }
}
