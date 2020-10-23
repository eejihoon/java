package com.algorithm.programmers.lv1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MarathoneTest {

    @Test
    public void marathone1Test() {
        Marathone marathone = new Marathone();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        assertThat(marathone.solution(participant, completion), is("leo"));

        participant = new String[]{"marina", "josipa","nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        assertThat(marathone.solution(participant, completion), is("vinko"));

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        assertThat(marathone.solution(participant, completion), is("mislav"));
    }

    @Test
    public void marathone2Test() {
        Marathone2 marathone = new Marathone2();

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        assertThat(marathone.solution(participant, completion), is("leo"));

        participant = new String[]{"marina", "josipa","nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        assertThat(marathone.solution(participant, completion), is("vinko"));

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        assertThat(marathone.solution(participant, completion), is("mislav"));
    }
}
