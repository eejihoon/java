package com.algorithm.programmers.lv1;

import java.util.*;

class Sum {
    /**
     *	정수 배열 numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑은 다음,
     *	더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return한다.
     *
     *	Logic
     *	배열의 0번 인덱스부터 마지막 인덱스까지 반복하면서
     *	같은 인덱스를 제외한 모든 인덱스를 한 번씩 더한다.(numbers[0] + number[1~n] = n)
     *	더한 결과 값을 set에 저장하고
     *	배열로 바꿔서 반환한다.
     *
     */
    public int[] solution(int[] numbers) {
        int[] answer = {};
//        Set sumAscSortList = sumAscSort(numbers);
//        answer = setToArray(sumAscSortList);
        answer = sumAscSort(numbers);
        return answer;
    }

    private int[] setToArray(Set set) {
        List<Integer> resultList = new ArrayList<>(set);
        Collections.sort(resultList);
        int[] result = new int[resultList.size()];
        for(int i = 0 ; i < resultList.size(); i++ ) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    private int[] sumAscSort(int numbers[]) {
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i<numbers.length;i++) {
            for(int j = i+1; j<numbers.length;j++) {
                int sum = numbers[i] + numbers[j];
                resultSet.add(sum);
            }
        }
        return resultSet.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}