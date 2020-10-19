package com.datastructure.linkedlist;

import java.util.*;

public class MyLinkedList<E> implements List<E> {
    private class Node {
        public E data;
        public Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    } // Node

    private int size;
    /*
    *   첫 번째 노드의 정보를 담을 head
    * */
    private Node head;
    /*
    *   마지막 노드의 정보를 담을 tail
    * */
    private Node tail;


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
//        /*
//        *   객체를 처음 저장하면
//        *   head를 Node객체로 초기화한다.
//        * */
//        if (head == null) {
//            head = new Node(element);
//        } else {
//            /*
//            *   1. 처음 저장하는 데이터가 아닐 때,
//            *        처음 저장했던 객체 정보를 node 담는다
//            *
//            *   2. node.next가 null이 아닐 동안 반복문을 돈다.
//            *       ㄴ처음엔 null이 아니므로 통과
//            *
//            *   3. node.next에 지금 들어온 요소를 저장한다.
//            *
//            *
//            * */
//            Node node = head;
//            //마지막 노드까지 반복
//
////            for (; node.next != null; node = node.next) {}
//            while (node.next != null) {
//                node = node.next;
//            }
//
//            node.next = new Node(element);
//
//        }
//        size++;
//        return true;

        Node newNode = new Node(element);
        if(size == 0 ) {
            //데이터가 없는 경우
            addFirst(element);
        } else {
            //마지막 노드의 다음 노드를 새 노드로 지정
            tail.next = newNode;
            //마지막 노드를 새 노드로 지정
            tail = newNode;
            size++;
        }

        return true;
    }

    /*
    *   첫 번째 노드를 지정하는 메서드
    * */
    public void addFirst(E element) {
        //새 엘리먼트로 노드 생성
        Node newNode = new Node(element);
        // 다음 노드로 head를 지정
        newNode.next = head;
        //head에 새 노드를 지정
        head = newNode;
        size++;

        //다음 노드가 없다면 현재 요소가 마지막 노드가 된다.
        if(head.next == null) {
            tail = head;
        }
    }

    /*
    *   끝자리에 노드를 저장하는 메서드
    * */
    public void addLast(E element) {
        Node newNode = new Node(element);
        if(size == 0 ) {
            //데이터가 없는 경우
            addFirst(element);
        } else {
            //마지막 노드의 다음 노드를 새 노드로 지정
            tail.next = newNode;
            //마지막 노드를 새 노드로 지정
            tail = newNode;
            size++;
        }
    }

    @Override
    public void add(int k, E element) {
        if(k==0) {  // 0번 인덱스를 지정했다면
            addFirst(element);
        } else {
            //k 이전 인덱스의 데이터를 찾는다.
            Node temp1 = node(k - 1);

            //k번째 노드를 temp2로 지정한다.
            Node temp2 = temp1.next;

            //새로운 노드 생성
            Node newNode = new Node(element);

            //temp1의 다음 노드로 새로운 노드를 지정한다.
            temp1.next = newNode;

            //새로운 노드의 다음 요소로 temp2를 지정한다.
            newNode.next = temp2;

            size++;

            //추가된 노드가 마지막 노드라면
            //tail을 추가된 노드로 변경
            if(newNode.next == null) {
                tail = newNode;
            }
        }
    }

    /*
    *   중간에 노드를 추가하는 메서드
    * */
    private Node node(int index) {
        Node x = head;
        x = x.next;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    @Override
    public String toString() {
        if(head == null) {  // 데이터가 없다면
            return "[]";
        }
        //head를 찾는다.
        Node temp = head;
        String str = "[";

        // 다음 노드가 없을 때까지 반복
        // 마지막 노드는 이 while문에 접근할 수 없다.
        while (temp.next == null) {
            str += temp.data + ", ";
            //현재 temp의 next값으로 temp를 바꾼다.
            temp = temp.next;
        }
        //마지막 노도를 출력결과에 포함
        str += temp.data;

        return str + "]";
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
        Node temp = node(index);

        return temp.data;
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
        boolean flag = true;
        for (E element : c) {
            flag &= add(element);
            System.out.println("flag");
        }
        return flag;
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