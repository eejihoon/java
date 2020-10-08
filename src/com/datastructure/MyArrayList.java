package com.datastructure;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
        /**
         * 사이즈가 크다면 기존 배열의 *2길이로 새 배열을 생성하고, 기존 배열의 값을 복사한다. array를 이 결과값으로 초기화한다.
         */
        if (size >= array.length) {
            E[] bigger = (E[]) new Object[array.length * 2];
            System.arraycopy(array, 0, bigger, 0, array.length);
            array = bigger;
        }
        array[size] = element;
        size++;

        return true;
    }

    /**
     * 해당 인덱스에 저장된 요소를 반환하는 메서드.
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        E oldValue = array[index];
        array[index] = element;

        return oldValue;
    }

    @Override
    public int size() {
        System.out.println("size : " + size);
        return this.size;
    }

    /*****************************************************************************/

    @Override
    public void add(int arg0, E arg1) {
        // TODO Auto-generated method stub

    }

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
    public int indexOf(Object arg0) {
        // TODO Auto-generated method stub
        return 0;
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
    public boolean remove(Object arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E remove(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
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
