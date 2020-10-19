package com.javaex.ch11;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyVector implements List {

    Object[] data = null;   //객체를 담기 위한 객체 배열
    int capacity = 0;   //용량
    int size = 0;   //크기

    public MyVector(int capacity) {
        if (capacity < 0 ) throw new IllegalArgumentException("유효하지 않은 capacity : " + capacity);

        this.capacity = capacity;
        data = new Object[capacity];
    }

    public MyVector() {
        this(10);   //default capacity
    }
    
    //최소한의 capacity를 확보하는 메서드
    public void ensureCapacity(int minCapacity) {
        if (minCapacity - data.length > 0) {
            setCapcity(minCapacity);
        }
    }

    public void trimToSize() {
        setCapcity(size);
    }

    private void setCapcity(int minCapacity) {
        if (this.capacity == capacity) return;
        Object[] tmp = new Object[capacity];    //새 배열
        System.arraycopy(data, 0, tmp, 0, size);
        data = tmp;
        this.capacity = capacity;
    }

    @Override
    public boolean add(Object o) {
        //새로운 객체를 저장하기 전에 저장할 공간 확보
        ensureCapacity(size+1);
        data[size++] = o;
        return true;
    }

    /* Object[] data에 저장된 객체 중에서 매개변수로 받은 객체 o와 같은 것이 있다면 찾아서 삭제한다. */

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if(o.equals(data[i])) {
                remove(i);
            }
            return true;
        }//end - for
        return false;
    }
    @Override
    public void clear() {
        for ( int i =0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("범위를 벗어났습니다.");

        return data[index];
    }

    @Override
    public Object remove(int index) {
        Object oldObj = null;

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        }

        oldObj = data[index];

        //삭제하려는 데이터가 마지막 객체가 아니라면 배열 복사를 통해 빈자리를 채운다.
        if(index != size-1) {
            System.arraycopy(data, index+1,data,index,size-index-1);
        }
        //마지막 데이터를 null로 한다.
        data[size-1] = null;
        size--; //size를 하나 줄인다.
        return oldObj;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] result = new Object[size];
        System.arraycopy(data,0,result,0,size);

        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }


}
