package com.datastructure.linkedlist;

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

    @Test
    public void testRemoveIndex() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertThat(list.remove(2), is(3));
        assertThat(list.size(), is(2));
    }

    @Test
    public void testGet() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), is(3));
    }

    @Test
    public void testIndexOfData() {
        for (int i = 0; i < 10; i++) {
            list.addLast(i+1);
        }
        System.out.println(list.size());
        assertThat(list.indexOf(5), is(4));
        System.out.println(list);
        System.out.println(list.indexOf(10));
    }

    @Test
    public void testIterator() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        MyLinkedList2.ListIterator it = list.listIterator();

        int value = 1;
        while (it.hasNext()) {
            assertThat(it.next(), is(value++));
        }
    }

    @Test
    public void testIteratorAdd() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        MyLinkedList2.ListIterator it = list.listIterator();

        it.add(111);

        assertThat(list.get(0), is(111));
        assertThat(it.next(), is(1));
    }

    @Test
    public void testIteratorRemove() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        MyLinkedList2.ListIterator it = list.listIterator();

        while (it.hasNext()) {
            if((int)it.next() == 2) {
                it.remove();
            }
        }
        assertThat(list.indexOf(2), is(-1));
        assertThat(list.size(), is(2));
    }
}
