package com.datastructure;

import java.util.*;

public class MyLinkedList<E> implements List<E> {
    private class Node {
        public E data;
        public Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String toString() {
            return "Node("+data.toString()+")";
        }
    } // Node

    private int size;
    /*
    *   Node는 데이터와 다음 노드의 위치를 저장한다.
    * */
    private Node head;

    public MyLinkedList() {
        size = 0;
        head = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E element) {
        /*
        *   객체를 처음 저장하면
        *   head를 Node객체로 초기화한다.
        * */
        if (head == null) {
            head = new Node(element);
            System.out.println("head : " +head);
            System.out.println("head.next : " + head.next);
            System.out.println("head.data : " + head.data);
        } else {
            /*
            *   1. 처음 저장하는 데이터가 아닐 때,
            *        처음 저장했던 객체 정보를 node 담는다
            *
            *   2. node.next가 null이 아닐 동안 반복문을 돈다.
            *       ㄴ처음엔 null이 아니므로 통과
            *
            *   3. node.next에 지금 들어온 요소를 저장한다.
            *
            *
            * */
            Node node = head;
            //마지막 노드까지 반복
            System.out.println("------------------새 엘리먼트------------------");
//            System.out.println("node : " + node);
//            System.out.println("node.next : " + node.next);
//            System.out.println("node.data : " + node.data);

            for (; node.next != null; node = node.next) {}

        /*    if(node.next!=null) {
                node = node.next;
            }*/

            node.next = new Node(element);

            System.out.println("=============AFTER LOOP=====");
            System.out.println("node : " + node);
            System.out.println("node.next : " + node.next);
            System.out.println("node.data : " + node.data);

        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    /*******************************************/

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}