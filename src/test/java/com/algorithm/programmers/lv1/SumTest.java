package com.algorithm.programmers.lv1;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SumTest {
    @Test
    public void test() {
        Sum sum = new Sum();
        int[] numbers = {2,1,3,4,1};
        int[] result = {2,3,4,5,6,7};

        assertThat(sum.solution(numbers), is(result));
    }
}
