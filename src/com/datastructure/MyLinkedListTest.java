package com.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MyLinkedListTest {
    private List<Integer> myLinkedList;

    @Before
    public void setup() {
        myLinkedList = new MyLinkedList<>();

        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);

    }


    @Test
    public void testAddElement() {
        assertThat(myLinkedList.add(4), is(true));
        assertThat(myLinkedList.add(5), is(true));
//        assertThat(myLinkedList.size(), is(5));
//
//        System.out.println(myLinkedList);
    }
}
