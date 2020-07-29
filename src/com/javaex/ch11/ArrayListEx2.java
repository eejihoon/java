package com.javaex.ch11;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx2 {
    public static void main(String[] args) {
        final int LIMIT = 10;   //자르려고 하는 글자의 개수
        String source ="00000000000000000000000000000000000000000000";
        int length = source.length();

        List list = new ArrayList(length/LIMIT + 10);

        /*i+LIMIT의 크기가 length보다 작다면,
        * i~i+LIMIT 사이의 문자열을 잘라서 list에 저장하고,
        * i+LIMIT의 크기가 length보다 크다면,
        * i번째부터 마지막 문자열까지 list에 저장한다.
        * */
        for (int i = 0; i < length; i+=LIMIT) {
            if (i+LIMIT < length) {
                list.add(source.substring(i,i+LIMIT));
            } else {
                list.add(source.substring(i));
            }
        } // end - for

        //list의 모든 요소 출력
        list.forEach(element -> System.out.println(element));
    }

}
