package com.datastructure.linkedlist;

public class MyLinkedList2<E> {
    /*
    *   head는 첫 번째 노드를 지정한다.
    *   tail은 마지막 노드를 지정한다.
    * */
    private Node head;
    private Node tail;
    private int size = 0;

    /*
    *   LinkedList에서 가장 중요한 것이 Node의 구현이다. 데이터는 모두 Node에 저장된다.
    *   Node는 내부 클래스로 정의하는데, 사용자는 Node에 대해는 알 필요가 없으므로 private클래스로 한다.
    * */
    private class Node {
        //데이터를 저장할 변수
        private E data;
        //다음 노드를 담을 변수
        private Node next;

        public Node(E input) {
            this.data = input;
            this.next = null;
        }

        //노드의 내용을 출력해서 확인할 수 있도록 toString() 구현
        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }// Node

    /*
    *   첫 번째 자리에 데이터를 저장하는 메서드
    * */
    public void addFirst(E input) {
        //노드 생성
        Node newNode = new Node(input);

        //새로운 노드의 다음 노드로 head를 지정한다.
        //만일 head가 없다면 null
        newNode.next = head;

        //헤드로 새로운 노드를 지정한다.
        head = newNode;
        size++;

        //LinkedList에 저장된 요소가 하나 뿐이라면 head가 head이자 tail이다.
        if(head.next == null) {
            tail = head;
        }
    }

    /*
    *   마지막에 데이터 추가
    * */
    public void addLast(E input) {
        //노드 생성
        Node newNode = new Node(input);
        //만약 첫 번째로 저장되는 노드라면 addFirst()를 사용
        if(size == 0) {
            addFirst(input);
            return;
        }
        // 마지막 노드의 다음 노드로 생성한 노드를 지정
        tail.next = newNode;
        //마지막 노드 갱신
        tail = newNode;
        size++;
    }

    /*
    *   특정 위치의 노드를 찾는 메서드
    * */
    private Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }
    /*
    *   node()를 이용해서 특정 위치에 노드를 추가하는 메서드
    * */
    public void add(int k, E input) {
        // k가 0이라면 첫 번째 요소에 추가하는 것이므로 addFirst()를 사용
        if(k==0) {
            addFirst(input);
            return;
        }
        Node temp1 = node(k-1);
        Node temp2 = temp1.next;
        Node newNode = new Node(input);

        temp1.next = newNode;
        newNode.next = temp2;

        size++;

        if(newNode.next == null) {
            tail = newNode;
        }
    }

    @Override
    public String toString() {
        //노드가 없다면 []를 리턴
        if(head == null) {
            return "[]";
        }
        //탐색
        Node temp = head;
        String str = "[";

        //다음 노드가 없을 때까지 반복
        //마지막 노드는 반복문에 포함되지 않는다.
        while (temp.next != null) {
            str += temp.data + ", ";
            temp = temp.next;
        }
        //마지막 노드 추가
        str += temp.data;

        return str + "]";
    }

    /*
    *   첫 번째 노드를 삭제하고 삭제하는 노드를 return 하는 메서드
    * */
    public E removeFirst() {
        //삭제할 노드 head를 temp에 저장
        Node temp = head;
        //head의 값을 그 다음 노드로 변경
        head = head.next;

        /*
        *   temp는 어차피 이 메서드가 끝나는 동시에 사라질 텐데
        *   굳이 temp.data를 다시 변수에 담고, null로 초기화 시키는 이유가 뭐지?
        * */
        E returnData = temp.data;
        temp = null;

        size--;
        return returnData;
    }

    public int size() {
        return this.size;
    }

    /*
    *   중간 데이터를 삭제하는 메서드
    * */
    public E remove(int index) {
        if(index == 0) {
            return removeFirst();
        }

        /*
        *   노드를 삭제한다는 것은, 결국 연결(link)을 끊는다는 것이다.
        *   삭제하려는 노드 이전 노드의 next값을 삭제하려는 노드 다음 노드를 바꾸면 된다.
        * */
        //삭제하려는 노드의 이전 노드
        Node prevNode = node(index-1);
        //삭제하려는 노드
        Node todoDeleted = prevNode.next;
        //next값을 삭제하려는 노드의 다음 노드로 변경
        prevNode.next = prevNode.next.next;
        E returnData = todoDeleted.data;

        //삭제하려는 노드가 마지막 노드라면 이전 노드가 tail이 된다.
        if(todoDeleted == tail) {
            tail = prevNode;
        }

        todoDeleted = null;
        size--;
        return returnData;
    }

    /*
    *   마지막 노드를 삭제하는 메서드
    * */
    public E removeLast() {
        return remove(size-1);
    }

    public E get(int index) {
        Node node = node(index);
        return node.data;
    }

    public int indexOf(E data) {
        Node temp = head;
        int index = 0;
        //입력 받은 데이터와 temp의 data와 입력 받은 data가 같지 않다면 반복
        while (temp.data != data) {
            //temp의 값을 다음 노드로 변경
            temp = temp.next;
            index++;
            //더 이상 탐색 대상이 없다면
            if (temp == null) {
                return -1;
            }
        }
        return index;
    }

    public ListIterator listIterator() {
        return new ListIterator();
    }

    class ListIterator {
        private Node next;
        private Node lastReturned;
        private int nextIndex;

        ListIterator() {
            next = head;
        }

        public E next() {
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

        public boolean hasNext() {
            return nextIndex < size();
        }

        public void add(E input) {
            Node newNode = new Node(input);

            //첫 번째 노드라면
            if(lastReturned == null) {
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.next = next;
            }
            lastReturned = newNode;
            nextIndex++;
            size++;
        }

        /*
        *   데이터를 삭제한다는 것은
        *   lastReturned를 삭제한다는 것
        * */
        public void remove() {
            //next를 한 번도 호출하지 않은 상태라면
            //아직 아무런 노드도 선택하지 않았다는 뜻이므로 삭제할 수 없다.
            if(nextIndex == 0) {
                throw new IllegalStateException();
            }
            MyLinkedList2.this.remove(nextIndex-1);
            nextIndex--;
        }
    }

}
