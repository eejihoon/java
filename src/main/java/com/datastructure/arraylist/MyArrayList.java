package com.datastructure.arraylist;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    /**
     * 변수 size는 MyArrayList클래스의 몇 개의 요소가 저장되어 있는 지 조회하는 용도다. 배열 array는 실제로 그 요소를
     * 저장하는 배열이다. 생성자는 길이가 10개의 요소를 저장할 수 있는 배열을 생성하고, size는 0으로 초기화한다.
     */
    int size; // 요소의 개수를 추적
    private E[] array; // 요소를 저장

    public MyArrayList() {
        array = (E[]) new Object[10]; // new E[10] 문법 오류
        size = 0;
    }

    /**
     * MyArrayList에 요소를 추가하는 메서드
     */
    @Override
    public boolean add(E element) {
        ensureCapacityInternal(size);
        array[size] = element;
        size++;

        return true;
    }

    /*
     *   index번째 요소부터 뒤로 한 칸씩 미루고
     *   그 자리에 element를 저장한다.
     * */
    @Override
    public void add(int index, E element) {
        /*
         *   1. 공간확보
         *   2. index번째 요소부터 뒤로 한 칸씩 미룬다.
         *   3. index번째 위치에 elememnt를 저장
         *   4. size 1 증가
         * */

        ensureCapacityInternal(size+1);
        System.arraycopy(array, index, array, index+1, size-index);
        array[index] = element;
        size++;
    }

    /**
     * 해당 인덱스에 저장된 요소를 반환하는 메서드.
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        return array[index];
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element. 이 목록의 지정된 위치에있는 요소를 지정된 요소로 바꿉니다.
     * 원래 가지고 있던 요소를 return 한다.
     */
    @Override
    public E set(int index, E element) {
        /**
         * 구현 순서
         *
         * 1. 인덱스 유효 범위 체크 (0보다 작거나, array의 length보다 크거나) ㄴ 유효 범위 밖이라면 예외처리
         * 2. 기존 index위치에 저장되어 있던 요소를 다른 변수에 저장해둔다.
         * 3. 배열 array의 index번째 위치에 element를 저장
         */
        checkIndex(index);
        E oldValue = array[index];
        array[index] = element;

        return oldValue;
    }

    @Override
    public int size() {
        return this.size;
    }

    /*
     *   매개변수의 인자로 받은 객체 arg0이 포함되어 있는지
     *   배열 array의 첫 번째 요소부터 찾아나간다.
     *   포함하지 않는다면 -1을 반환하고,
     *   포함한다면 해당 객체가 저장된 인덱스를 반한다.
     * */
    @Override
    public int indexOf(Object o) {
        /*
         *   1. null체크
         *       ㄴ null이라면 array의 요소 중 null이 있는지 확인하고 있다면 해당 인덱스 반환
         *
         *   2. null이 아닐 때
         *       매개변수로 인자로 받은 o와 같은 요소가 array 안에 있는지 검사
         *       있다면 해당 인덱스 반환
         *
         *   3. 없다면 -1 반환
         * */
        if(o == null) {
            for (int i=0; i<size; i++) {
                if (o == array[i]) {
                    return i;
                }
            }
        } else {
            for(int i = 0; i < size; i++) {
                if(o.equals(array[i])) {
                    return i;
                }
            }
        }

        return -1;
    }
    /*
     *  매개변수의 인자로 받은 index에 저장된 요소를 삭제한다.
     * */
    @Override
    public E remove(int index) {
        /*
         *   1. 인덱스 유효성 체크
         *   2. 해당 인덱스에 저장된 값을 remomveElement에 저장
         *   3. index가 마지막 인덱스인지 체크
         *       ㄴ마지막이 아니라면 삭제한 요소 다음에 오는 요소들의 자리를 한 칸씩 앞으로 이동시킨다.
         *   4. 마지막 요소를 null로 바꾼다.
         *   5. size를 하나 줄인다.
         *   6. removeElement 반환
         * */
        checkIndex(index);
        E removeElement = array[index];
        int numMoved = size - index - 1;

        /*
         *   numMoved가 0보다 크지 않다는 것은 삭제한 요소가 배열의 마지막 요소라는 것을 의미한다.
         * */
        if(numMoved > 0) {
            System.arraycopy(array, index+1, array, index, numMoved);
        }

        /*
         *   size를 하나 줄임과 동시에 마지막 요소를 null로 바꾼다.
         * */
        array[--size] = null;
        return removeElement;
    }

    /*
     *   index 유효성을 체크하는 메서드
     * */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /*
     *   내부 용량 확보
     * */
    private void ensureCapacityInternal(int size) {
        if (size >= array.length) {
            E[] bigger = (E[]) new Object[array.length * 2];
            System.arraycopy(array, 0, bigger, 0, array.length);
            array = bigger;
        }
    }

    /*
     *   지정한 Collection에 포함된 모든 요소를 지운다.
     * */
    @Override
    public boolean removeAll(Collection<?> collection) {
        /*
         *   1. null체크
         *   2. collection과 array를 비교하여 같은 요소가 있다면 삭제
         *   3. 요소를 삭제했다면 true를 반환
         *       삭제된 요소가 없다면 false를 반환
         * */
//        Objects.requireNonNull(collection);
//        boolean result = false;
//        for (int i=size; i<0; i--) {
//            if(collection.contains(get(i-1))) {
//                remove(i);
//                result = true;
//            }
//            System.out.println(i+"");
//        }
//        return result;
        boolean flag = false;
        for (Object obj : collection) {
            flag = remove(obj);
        }
        return flag;
    }

    /*
     *
     * */
    @Override
    public boolean remove(Object o) {
        Objects.requireNonNull(o);
        boolean result = false;
        for (int i=0; i<size(); i++) {
            if(o.equals(get(i))) {
                remove(i);
                result = true;
            }
        }
        return result;
    }

    /*****************************************************************************/

    @Override
    public boolean addAll(Collection<? extends E> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(int arg0, Collection<? extends E> arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean contains(Object arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int lastIndexOf(Object arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }




    @Override
    public boolean retainAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }



    @Override
    public List<E> subList(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] arg0) {
        // TODO Auto-generated method stub
        return null;
    }

}