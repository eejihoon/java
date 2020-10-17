package com.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class MyLinkedList3Test {

    private MyLinkedList3<Integer> list;

    @Before
    public void setup() {
        list = new MyLinkedList3<>();

        for (int i = 0; i < 10; i++) {
            assertThat(list.add(i+1), is(true));
        }
    }

    @Test
    public void testGet() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            assertThat(list.get(i), is(i+1));
        }
        try {
            list.get(-123);
            fail();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("인덱스 예외처리");
        }
    }

    @Test
    public void test_원하는_위치에_데이터_추가하기() {
        assertThat(list.size(), is(10));
        list.add(1, 10);
        list.add(8, 10);
        assertThat(list.get(1), is(10));
        assertThat(list.get(8), is(10));
        assertThat(list.size(), is(12));
        list.add(12, 999);
        assertThat(list.get(12), is(999));
        assertThat(list.size(), is(13));

        try {
            list.add(123, 999);
            fail();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("예외 처리");
        }
    }

    @Test
    public void testToString() {
        System.out.println(list);
    }

    @Test
    public void testIndexOf() {
        assertThat(list.indexOf(0), is(-1));
        assertThat(list.indexOf(10), is(9));
        list.add(null);
        assertThat(list.indexOf(null), is(10));
        List linkedList = new LinkedList();
    }

    @Test
    public void testRemove() {
        assertThat(list.size(), is(10));
        //맨 마지막 인덱스 삭제
        assertThat(list.remove(9), is(10));
        assertThat(list.size(), is(9));

        //중간 데이터 삭제
        assertThat(list.remove(5), is(6));
        assertThat(list.size(), is(8));

        //첫 번째 데이터 삭제
        assertThat(list.remove(0), is(1));
        assertThat(list.size(), is(7));
    }
}
