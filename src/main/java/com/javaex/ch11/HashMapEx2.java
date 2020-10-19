package com.javaex.ch11;

import java.util.*;

public class HashMapEx2 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("김코코", 90);
        map.put("김코코", 100);
        map.put("이쿠쿠", 100);
        map.put("최쿠쿠", 40);
        map.put("박코코", 88);
        System.out.println("map : " + map);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            //next()의 반환타입이 Object이므로 원래 타입으로 변환 필요
            Map.Entry e = (Map.Entry)iterator.next();
            System.out.println("이름 : " + e.getKey());
            System.out.println("점수 : " + e.getValue());
        } //end - while

        set = map.keySet();
        System.out.println("참가자 명단 : " + set);

        //Map -> Collection
        Collection values = map.values();
        iterator = values.iterator();

        int total = 0;

        while (iterator.hasNext()) {
            Integer integer = (Integer) iterator.next();
            total += integer.intValue();
        }

        System.out.println(" 총점   : " + total);
        System.out.println(" 평균   : " + (float)total/set.size());
        System.out.println("최고점수 : " +Collections.max(values));
        System.out.println("최저점수 : " +Collections.min(values));
    }
}
