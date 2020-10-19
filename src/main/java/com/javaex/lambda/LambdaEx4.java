package com.javaex.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaEx4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i ++) {
            list.add(i);
        }

        //list의 모든 요소 출력
        list.forEach(i -> System.out.println(i));

        //list에서 2 또는 3의 배수 제거
        list.removeIf(x -> x%2==0 || x%3==0);   //removeIf(Predicate<E> filter)
        System.out.println(list);

        //list의 각 요소에 10을 곱한다.
        list.replaceAll(i -> i*10); //void replaceAll(UnaryOperator<E> operator)
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        //void forEach(BiConsumer<K,V> action)
        map.forEach((k,v) -> System.out.println("["+k+","+v+"]"));
    }
}
