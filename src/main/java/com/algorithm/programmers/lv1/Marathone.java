package com.algorithm.programmers.lv1;

import java.util.*;

public class Marathone {
    public String solution(String[] participant, String[] completion) {
        /**
         *   1. 참여 선수(participant)와 완주 선수(completion)을 비교한다.
         ㄴ 완주 선수 안에 포함되는 참여 선수를 모두 제외한다.(중복 제거)
         2. 제외되지 않고 남은 선수, 즉 완주하지 못한 선수를 return한다.
         */
        checkValid(participant, completion);
        List<String> temp1 = new ArrayList(Arrays.asList(participant));
        List<String> temp2 = new ArrayList(Arrays.asList(completion));
        for (String str : temp2) {
            temp1.remove(str);
        }
        String answer =
                temp1.isEmpty() ? "모두 완주했습니다." : temp1.get(0);
        return answer;
    }

    /**
    *   마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
    *   completion의 길이는 participant의 길이보다 1 작습니다.
    *   참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
    *   참가자 중에는 동명이인이 있을 수 있습니다.
    */
    public void checkValid(String[] temp1, String[] temp2) {
        if (temp1.length < 0 || temp1.length > 100000
                || temp2.length > temp1.length) {
            throw new IllegalArgumentException();
        }
    }
}
