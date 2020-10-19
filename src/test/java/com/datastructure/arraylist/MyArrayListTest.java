package com.datastructure.arraylist;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class MyArrayListTest {
    protected List<Integer> myList;

    @Before
    public void setUp() throws Exception {
        myList = new MyArrayList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
    }

    @Test
    public void testMyList() {
        assertThat(myList.size(), is(3));
    }

    @Test
    public void testAddT() {
        for(int i = 4; i <29; i++) {
            myList.add(i);
        }
        assertThat(myList.get(18), is(19));
    }

    @Test
    public void testAddIntT() {
        myList.add(1,5);
        assertThat(myList.get(1), is(5));
        assertThat(myList.get(2), is(2));
        assertThat(myList.size(), is(4));
    }

    @Test
    public void testGet() {
        assertThat(myList.get(2), is(3));
    }

    @Test
    public void testSet() {
        Integer val = myList.set(1, 5);
        assertThat(val, is(2));

        val = myList.set(0,6);
        assertThat(val, is(1));

        val = myList.set(2, 7);
        assertThat(val, is(3));

        assertThat(myList.get(0), is(6));
        assertThat(myList.get(1), is(5));
        assertThat(myList.get(2), is(7));

        try{
            myList.set(-4, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Good");
        }
    }

    @Test
    public void testIndexOf() {
        assertThat(myList.indexOf(3), is(2));
        assertThat(myList.indexOf(2), is(1));
        assertThat(myList.indexOf(1), is(0));
        assertThat(myList.indexOf(10), is(-1));
        assertThat(myList.indexOf(null), is(-1));
        myList.add(null);
        assertThat(myList.indexOf(null), is(3));
    }

    @Test
    public void testRemomve() {
        for (int i = myList.size()-1; i < 0; i--) {
            assertThat(myList.remove(i), is(i+1));
        }

        try {
            myList.remove(5);
            fail();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("예외처리 성공");
        }
    }

    @Test
    public void testRemoveObj() {
        assertThat(myList.remove(new Integer(1)), is(true));
    }

    @Test
    public void testRemoveAll() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        assertThat(myList.removeAll(list), is(true));
        assertThat(myList.get(0), is(3));
        assertThat(myList.size(), is(1));
    }


}