/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.queue;

import java.util.Arrays;

/**
 *The class CustomQueue
 * @author Pawan Manglani
 * @version 1.1 22-Aug-2017
 */
public class CustomQueue<T extends Object> {

	/*
	 *The array buffer into which the elements of the Queue are stored.
	 */
	private Object[] elementData;
	/*
	 *The size of the Queue (the number of elements it contains). 
	 */
	private int size = 0, front = 0, rear = -1;

	;

	/**
	 * Constructs an empty queue with the specified initial capacity.
	 *
	 * @param initialCapacity the initial capacity of the queue
	 * @throws IllegalArgumentException if the specified initial capacity is
	 * negative
	 */
	public CustomQueue(int initialCapacity) {
		try{
			if (initialCapacity < 0) {
				throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
			}

		}catch(Exception e){
			System.out.println(e.getMessage() + " Halting the code");
			System.exit(1);
		}

		this.elementData = new Object[initialCapacity];
	}

	/*
	 *Constructs an empty queue with an initial capacity of ten. 
	 */
	public CustomQueue() {
		this(10);
	}

	/**
	 * Returns the number of elements in this queue.
	 *
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Increases the capacity of this Queue instance,specified by the minimum
	 * capacity argument.
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
	 * enqueue
	 *
	 * The method add item in queue
	 *
	 * @param item
	 */
	public void enqueue(Object item) {
		ensureCapacityInternal(size + 1);
		rear++;
		elementData[rear] = item;
		size++;
	}

	/**
	 * dequeue
	 *
	 * The method deletes an element from queue
	 *
	 * @return item T
	 */
	@SuppressWarnings("unchecked")
	public T dequeue() {
		T oldValue = null;
		try {
			if (size == 0) {
				throw new IndexOutOfBoundsException("Queue is Empty");
			}
			oldValue = (T) elementData[front];
			elementData[front++] = null; // Let gc do its work
			size--;
			if(size==0){
				front = 0;
				rear = -1;
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		return oldValue;
	}
	/**
	 * This method clear the queue
	 */
	public void makeEmpty(){
		while(size!=0){
			dequeue();
		}
		front = 0;
		rear = -1;
	}

	/**
	 * get front
	 *
	 * This method return the front element
	 *
	 * @return item T
	 */
	@SuppressWarnings("unchecked")
	public T getFront() {
		T element = null;
		if (front != -1) {
			element = (T) elementData[front];
		}
		return element;
	}

	/**
	 * To string
	 *
	 * @return String representation of queue
	 */
	@Override
	public String toString() {
		String queue = "[";
		if (front > rear) {
			queue = "Queue is Empty";
		} else {
			for (int index = 0; index < size; index++) {
				queue += elementData[index];
			}
			queue += "]";
		}
		return queue;
	}

	/**
	 * To Array method this method returns the array of queue
	 * @return the array of queue
	 */
	public Object[] toArray(){
		return Arrays.copyOf(elementData, size);
	}



}