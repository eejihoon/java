package com.datastructure;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MyLinkedList2Test {

    private MyLinkedList2<Integer> list;

    @Before
    public void setup() {
        list = new MyLinkedList2<>();
    }

    @Test
    public void testAdd() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertThat(list.size(), is(3));
        System.out.println(list);

        list.addFirst(10);
        System.out.println(list);

        list.addLast(10);
        System.out.println(list);

        list.add(2, 123);
        System.out.println(list);
    }

    @Test
    public void testRemoveFirst() {
        list.addFirst(1);
        assertThat(list.removeFirst(), is(1));
    }



}
