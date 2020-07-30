package com.javaex.ch11;

import java.util.*;

public class TreeMapEx1 {
    public static void main(String[] args) {
        String[] data = {"A", "K", "A", "K", "D","K","A","K","K","K","K","Z","D"};

        TreeMap map = new TreeMap();

        for (int i = 0; i < data.length; i ++) {
            if(map.containsKey(data[i])) {
                Integer value = (Integer)map.get(data[i]);
                map.put(data[i],value+1);
            } else {
                map.put(data[i], 1);
            }
        }

        Iterator iterator = map.entrySet().iterator();

        System.out.println("==기본정렬==");
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            int value = ((Integer)entry.getValue()).intValue();
            System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
        }
        System.out.println();

        //map -> ArrayList -> Collections.sort() 정렬
        Set set = map.entrySet();
        List list = new ArrayList(set);

        //static void sort(List list, Comparator c)
        Collections.sort(list, (Object o1, Object o2) -> {   //람다
            if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
                Map.Entry entry1 = (Map.Entry) o1;
                Map.Entry entry2 = (Map.Entry) o2;

                int value1 =((Integer)entry1.getValue()).intValue();
                int value2 =((Integer)entry2.getValue()).intValue();

                return value2 - value1;
            }
            return -1;
        });

        iterator = list.iterator();

        System.out.println("==값의 크기가 큰 순서로 정렬==");
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            int value = ((Integer)entry.getValue()).intValue();
            System.out.println(entry.getKey() + " : " + printBar('#',value) + " " + value);
        }

    } //main()


    public static String printBar(char ch, int value) {
        char[] bar = new char[value];

        for(int i = 0; i < bar.length; i ++) {
            bar[i] = ch;
        }

        return new String(bar);
    }
}
