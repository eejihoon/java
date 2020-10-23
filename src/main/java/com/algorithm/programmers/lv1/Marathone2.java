package com.algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Marathone2 {
    public String solution(String[] participant, String[] completion) {
        List<String> list = new ArrayList<>(Arrays.asList(participant));
        for (int i = 0; i < completion.length; i++) {
            list.remove(completion[i]);
        }
        return list.get(0);
    }
}