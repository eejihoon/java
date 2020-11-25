package com.algorithm.programmers.lv1;

import java.util.*;
import java.util.stream.Collectors;

public class PracticeTest {

    //answer = {1,4,3,2,1,3,4,5,2,3,1}
    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 3, 2, 4, 2});
        System.out.println(Arrays.toString(result));

    }
    public static int[] solution(int[] answers) {
        int[] firstWay = {1,2,3,4,5};
        int[] secondWay = {2,1,2,3,2,4,2,5};
        int[] thirdWay = {2,1,2,3,2,4,2,5};

        int firstWayScore = 0;
        int secondWayScore = 0;
        int thirdWayScore = 0;

        for (int i=0; i<answers.length;i++){
            if (answers[i] == firstWay[i%firstWay.length])
                firstWayScore++;
            if (answers[i] == secondWay[i%secondWay.length])
                secondWayScore++;
            if (answers[i] == thirdWay[i%thirdWay.length])
                thirdWayScore++;
        }

        List<Integer> result = new ArrayList<>();
        int max = Math.max(Math.max(firstWayScore, secondWayScore), thirdWayScore);

        if (max == firstWayScore)
            result.add(1);

        if (max == secondWayScore)
            result.add(2);

        if (max == thirdWayScore)
            result.add(3);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}