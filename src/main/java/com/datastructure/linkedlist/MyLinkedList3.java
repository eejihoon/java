package com.datastructure.linkedlist;

import java.util.*;

public class MyLinkedList3<E> implements List<E> {
    private int size;
    private Node head;
    private Node tail;

    private class Node {
        public E data;
        public Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        boolean result = indexOf(o) != -1 ? true : false;
        return result;
    }

    /*
    *   리스트의 끝에 지정한 요소(e)를 추가한다.
    * */

    @Override
    public boolean add(E e) {
        /*
        *   1. 만약 리스트에 저장된 노드가 하나도 없다면 첫 번째 자리에 저장한다.
        *   2. 리스트에 이미 저장된 노드가 있다면 첫 번째 리스트부터 순회하며 마지막 노드를 찾는다.
        *   3. 마지막으로 저장된 노드 next값으로 새로운 노드를 지정한다.
        * */
        Node newNode = new Node(e);
        if(head == null) {
            addFirst(newNode);
            return true;
        }
        addLast(newNode);
        return true;
    }
    private void addFirst(Node newNode) {
        //입력받은 노드의 다음 노드를 head로 지정
        //head를 새 노드로 변경
        newNode.next = head;
        head = newNode;
        size++;

        //다음 노드가 없다면 head가 마지막 노드다.
        if(head.next == null) {
            tail = head;
        }
    }

    private void addLast(Node newNode) {
        //현재 마지막 요소인 노드의 다음 요소로 새 노드를 지정하고
        //마지막 요소를 새 노드로 변경한다.
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    /*
    *   리스트를 순회하면서 지정한 데이터와 같은 데이터가 있다면 삭제한다.
    *   같은 게 하나 이상이더라도, 맨 처음(index가 낮은) 발견한 데이터만 삭제한다.
    * */

    @Override
    public boolean remove(Object o) {
        /*
        *   indexOf()로 o와 일치하는 노드가 있는지 탐색
        *       ㄴ 있다면 해당 index를 삭제
        * */
        int index = indexOf(o);
        //일치하는 데이터가 있다면
        if (index != -1) {
            //해당 인덱스 삭제
            remove(index);
            return true;
        }
        return false;
    }
    @Override
    public E get(int index) {
        checkIndex(index);
        Node getNode = node(index);
        return getNode.data;
    }


    /*
    *   입력 받은 index에 있는 노드를 찾는 메서드
    * */
    Node node(int index) {
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /*
    *   지정한 위치에 있는 노드를 지정한 요소(element)로 바꾼다.
    * */
    @Override
    public E set(int index, E element) {
        /*
        *   1. index 유효성 체크
        *   2. 바꾸려는 노드 이전 노드와 다음 노드를 찾는다.
        *   3. 이전 노드와 바꾸려는 위치에 있는 기존 노드의 연결을 끊고, 새 노드와 연결한다.
        *   4. 새 노드의 다음 노드로 기존 다음 노드를 연결한다.
        *   5. 원래 노드(연결을 끊은 노드)를 반환한다.
        * */
        checkIndex(index);
        //이전 노드를 찾는다.
        Node prevNode = node(index-1);
        //바꾸려는 위치에 있는 노드
        Node deletedNode = prevNode.next;
        //바꾸려는 위치의 다음 노드
        Node nextNode = deletedNode.next;
        //새 노드
        Node newNode = new Node(element);
        //이전 노드를 새 노드와 연결
        prevNode.next = newNode;
        //새 노드와 다음 노드를 연결
        newNode.next = nextNode;
        //만약 바꾼 노드가 마지막 노드였다면 tail로 변경
        if(newNode.next == null) {
            tail = newNode;
        }

        return deletedNode.data;
    }

    /*
    *   지정한 위치(index)에 지정한 요소(element)를 추가한다.
    * */
    @Override
    public void add(int index, E element) {
        /*
        *    0. indexCheck
        *    1. index가 0이라면, 첫 번째 자리에 저장
        *    2. 입력 받은 index가 size와 같다면 마지막 노드가 된다.
        *    3. 중간에 노드를 추가한다면, 추가하려는 위치의 이전 노드와 다음 노드를 알아야 한다.
        *           ㄴ 이전 노드의 다음 노드를 변수에 저장한 다음 연결을 끊는다. 그리고 새 노드와 연결한다.
        *           ㄴ 새 노드의 다음 노드로 변수에 저장해둔(연결을 끊은) 노드를 연결한다.
        * */

        //이 메서드는 예외적으로 index와 size가 같을 수 있다.
        //따라서 index == size가 true일 경우에는 index-1을 해서 예외가 나지 않게 처리한다.
        checkIndex(index == size ? index-1 : index);

        Node newNode = new Node(element);
        //1.index가 0이라면, 첫 번째 자리에 저장
        if (index == 0) {
            addFirst(newNode);
            return;
        } else if (index == size) { //2. 입력 받은 index가 size와 같다면 마지막 노드가 된다.
            addLast(newNode);
            return;
        }
        // 추가하려는 index 이전 노드의 다음 노드를 변수에 저장한다.
        Node prevNode = node(index-1);
        Node nextNode = prevNode.next;
        // 이전 노드의 다음 노드를 새 노드와 연결한다.
        prevNode.next = newNode;
        //새 노드의 다음 노드를 nextNode로 연결한다.
        newNode.next = nextNode;
        size++;
    }

    private void checkIndex(int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    /*
    *   지정한 인덱스에 있는 노드를 삭제한다.
    * */
    @Override
    public E remove(int index) {
        /*
        *   1. 인덱스 유효성 검사
        *   2. 지정한 인덱스가 0이라면 removeFirst()
        *   3. 지정한 인덱스가 마지막 인덱스(size-1)라면 마지막 이전 노드와 마지막 노드의 연결을 끊는다.
        *   4. 삭제하려는 노드 이전 노드와 다음 노드를 찾는다.
        *       ㄴ 이전 노드와 삭제하려는 노드의 연결을 끊는다.
        *       ㄴ 이전 노드와 삭제한 노드 다음 노드를 연결한다.
        * */
        checkIndex(index);
        if (index==0) {
            return removeFirst();
        }
        //삭제하려는 노드의 이전 노드
        Node prevNode = node(index-1);
        //삭제하려는 노드
        Node removeNode = prevNode.next;
        //삭제하려는 노드의 다음 노드
        Node nextNode = removeNode.next;
        //삭제하려는 노드의 이전 노드의 다음 노드를 변경
        prevNode.next = nextNode;

        if (nextNode == null) {
            tail = prevNode;
        }
        size--;
        return removeNode.data;
    }

    /*
    *   맨 첫 번째 노드를 삭제한다.
    * */
    private E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node removeNode = head;
        head = head.next;
        size--;
        return removeNode.data;
    }

    /*
    *   리스트를 차례대로 순회하면서
    *   입력받은 o와 노드의 데이터를 비교한다.
    *   o와 같은 데이터를 가진 가장 첫 번째 인덱스를 반환한다.
    *   (인덱스1과 인덱스7이 o와 같다고 했을 때, indexOf()는 인덱스1만을 반환한다.)
    * */
    @Override
    public int indexOf(Object o) {
        /*
        *   1. 첫번째 노드의 데이터부터 입력 받은 o와 비교한다.
        *       ㄴ 같은 값이 있다면 해당 인덱스 반환
        *       ㄴ 없다면 -1
        * */
        Node temp = head;
        int index = 0;
        while (temp.data != o) {
            //더 이상 탐색할 노드가 없다면
            if (temp.next == null) {
                return -1;
            }

            temp = temp.next;
            index++;
        }
        return index;
    }

    @Override
    public String toString() {
        Node temp = head;
        String allNode="[";
        //다음 노드가 없을 때까지 반복
        while (temp.next != null) {
            allNode += temp.data + ", ";
            temp = temp.next;
        }
        //마지막 요소는 while문에 진입할 수 없으므로 밖에서 추가한다.
        allNode += temp.data + "]";
        return allNode;
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
}
