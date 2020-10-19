package com.datastructure.linkedlist;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
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
        System.out.println(myLinkedList);
    }

    @Test
    public void testAdd() {

        System.out.println(myLinkedList.get(0));
        //1번 인덱스에 저장된 요소는 지금 2다.
      //  assertThat(myLinkedList.get(1), is(2));
//        assertThat(myLinkedList.get(2), is(3));

        //1번 인덱스를 123으로 변경
      //  myLinkedList.add(1, 123);

       // assertThat(myLinkedList.get(1), is(123));
     //   assertThat(myLinkedList.get(2), is(2));

    }
}
