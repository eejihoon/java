package com.algorithm.programmers.lv1;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 *
 */
class CraneGame {
    public int solution(int[][] board, int[] moves) {
        return removedElement(board, moves);
    }

    public int removedElement(int[][] board, int[] moves) {
        List<Integer> list = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < moves.length; i++) {
            //moves에 저장되는 수는 1~5이니 실제 인덱스 값으로 맞춘다.
            int index = moves[i] - 1;
            for (int j = 0; j < board.length; j++) {
                //0번째 줄부터 순회하며 0이 아닌 다른 요소가 있을 경우 list에 저장한다.
                //그 다음 해당 위치의 값 0으로 바꾼다.
                //compareAndRemove()를 호출하여 마지막 값과 그 이전 값을 비교하고
                //삭제했다면 삭제된 요소의 수를 반환 받는다.
                if (board[j][index] > 0) {
                    int element = board[j][index];
                    list.add(element);
                    board[j][index] = 0;
                    result += compareAndRemove(list);
                    break;
                }
            }
        }
        return result;
    }

    /*
    *   마지막 요소와 그 전 요소를 비교해서 같다면 삭제한다.
    * */
    public int compareAndRemove(List list) {
        int removeCount = 0;
        if (list.size() > 1) {
            int compareTargetIndex = list.size()-2;
            int target1 = (int) list.get(compareTargetIndex+1);
            int target2 = (int) list.get(compareTargetIndex);

            /*
            *   맨 마지막 요소와 그전 요소가 같다면 삭제하고
            *   삭제한 요소의 개수인 2 카운트를 증가시킨다.
            * */
            if (target1 == target2) {
                list.remove(compareTargetIndex+1);
                list.remove(compareTargetIndex);
                removeCount += 2;
            }
        }
        return removeCount;
    }

}

