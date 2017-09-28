/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.util.customArrayList;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.metacube.util.Utility;

/**
 *
 * @author Pawan Manglani
 * @version 1.1 20-Aug-2017
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class CustomArrayList<T extends Object> implements CustomList<T> {

    /*
    *The array buffer into which the elements of the ArrayList are stored.
     */
    private Object[] elementData;
    /*
    *The size of the ArrayList (the number of elements it contains). 
     */
    private int size;

    private int modCount = 0;

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity is
     * negative
     */
    public CustomArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
    }

    /*
    *Constructs an empty list with an initial capacity of ten. 
     */
    public CustomArrayList() {
        this(10);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Increases the capacity of this ArrayList instance, if necessary, to
     * ensure that it can hold at least the number of elements specified by the
     * minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    public void ensureCapacity(int minCapacity) {
        modCount++;
        if (minCapacity > 0) {
            ensureCapacityInternal(minCapacity);
        }

    }

    /**
     * Increases the capacity of this ArrayList instance,specified by the
     * minimum capacity argument.
     *
     * @param minCapacity
     */
    private void ensureCapacityInternal(int minCapacity) {
        // overflow-conscious code
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }

    }

    /**
     * Increases the capacity to ensure that it can hold at least the number of
     * elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        // minCapacity is usually close to size:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element. More
     * formally, returns the lowest index i such that (o==null ? get(i)==null :
     * o.equals(get(i))), or -1 if there is no such index.
     *
     * @param o element whose index in this list is to be needed
     * @return the index of element
     */
    @Override
    public int indexOf(Object o) {
        int index = -1;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    index = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws java.lang.IndexOutOfBoundsException
     */
   
	@Override
    public T get(int index) {
		try{
        rangeCheck(index);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
        return (T) elementData[index];
    }

    /**
     * Checks if the given index is in range. If not, throws an appropriate
     * runtime exception.
     *
     * @param index
     * @throws IndexOutOfBoundsException
     */
    private void rangeCheck(int index) {
        if (index>size || index<0) {
            throw new IndexOutOfBoundsException("Invalid Position");
        }
    }

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws java.lang.IndexOutOfBoundsException
     */
    @Override
    public T remove(int index) {
    	T oldValue = null;
    	try{
        rangeCheck(index);
        modCount++;
         oldValue = (T) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null; // Let gc do its work
    	}catch(IndexOutOfBoundsException e){
    		System.out.println(e.getMessage());
    	}
        return oldValue;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if
     * it is present. If the list does not contain the element, it is unchanged.
     * More formally, removes the element with the lowest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
     *
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        boolean isRemove = false;
        if (o == null) {
            for (int index = 0; index < size; index++) {
                if (elementData[index] == null) {
                    fastRemove(index);
                    isRemove = true;
                    break;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    isRemove = true;
                    break;
                }
            }
        }
        return isRemove;
    }

    /**
     * Private remove method that skips bounds checking and does not return the
     * value removed.
     *
     * @param index
     */
    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        }
        elementData[--size] = null;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after
     * this call returns.
     */
    @Override
    public void clear() {
        modCount++;
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    /**Replaces the element at the specified position in this list with the specified element. 
     * 
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * 
     * @throws java.lang.IndexOutOfBoundsException
     */
    @Override
    public T set(int index, T element) {
        T oldValue = null;
        try{
        rangeCheck(index);
        oldValue = (T) elementData[index];
        elementData[index] = element;
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return oldValue;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param t element to be appended to this list
     */
    @Override
    public void add(T t) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = t;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     *
     * @throws java.lang.IndexOutOfBoundsException
     */
    @Override
    public void add(int index, T element) {
        try{
        rangeCheck(index);
        ensureCapacityInternal(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    /**Appends all of the elements in the specified list to the end of this list, 
     * in the order that they are returned by the specified list's Iterator.
     * 
     * @param l list containing elements to be added to this list
     * @return if this list changed as a result of the call
     * 
     * @throws java.lang.NullPointerException if the specified list is null
     */
    public boolean addAll(CustomList<? extends T> l){
        
        Object[] a = l.toArray();
        int numNew = 0;
        try{
        numNew = a.length;
        ensureCapacity(size + numNew);  // Increments modCount
        System.arraycopy(a, 0, elementData, size, numNew);
        size += numNew;
        }catch(NullPointerException e){
            System.out.println("The List Which has to be added is empty");
        }
        return numNew != 0;    
    }
    
    
    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element). This method acts as bridge between
     * array-based and collection-based APIs.
     *
     * @return an array containing all of the elements in this list in proper
     * sequence
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    /**
     * 
     * @return String representation of ArrayList
     */
    @Override
    public String toString() {
        String list = "[" + elementData[0];
        int len = elementData.length;
        for (int index = 1; index < len; index++) {
            if (elementData[index] == null) {
                break;
            }
            list += "," + elementData[index];
        }
        list += "]";

        return list;
    }

    /**
     * This method Sort The List
     *
     * @param <T> The type
     * @param list A list of elements
     */
    @SuppressWarnings("hiding")
	@Override
    public <T extends Comparable<? super T>> void sort(CustomList<T> list) {
        Utility.sort(list);
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @SuppressWarnings("rawtypes")
	@Override
    public Iterator iterator() {
        return new Itr(); //To change body of generated methods, choose Tools | Templates.
    }

    private class Itr implements Iterator<T> {

        private int cursor = 0; // index of next element to return
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            int index = cursor;
            checkForComodification();
            if (index >= size) {
                throw new NoSuchElementException();
            }
            Object[] elementData = CustomArrayList.this.elementData;
            cursor = index + 1;
            return (T) elementData[index];
        }

        final void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

    }

}
