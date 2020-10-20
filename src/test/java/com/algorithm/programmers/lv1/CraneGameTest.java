package com.algorithm.programmers.lv1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class CraneGameTest {
    @Test
    public void test01() {
        CraneGame craneGame = new CraneGame();

        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };

        int[] moves = {1,5,3,5,1,2,1,4};

        assertThat(craneGame.solution(board,moves), is(4));
    }
}
