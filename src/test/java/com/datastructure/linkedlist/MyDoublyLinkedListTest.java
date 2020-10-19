package com.datastructure.linkedlist;

import org.junit.Before;
import org.junit.Test;

public class MyDoublyLinkedListTest {
    private MyDoublyLinkedList list;


    @Before
    public void setup() {
        list = new MyDoublyLinkedList();
        for (int i =0; i<100; i++) {
            list.add(i, i+1);
        }
    }

    @Test
    public void testGet() {
        //사이즈/2 보다 큰 인덱스를 찾을 때
        System.out.println(list.get(88));
        //사이즈/2보다 작은 인데스를 찾을 때
        System.out.println(list.get(20));
    }
}