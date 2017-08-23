package com.metacube.stack;

/**
 * The Class DStack.
 *
 * @param <T> the generic type
 * @author Pawan Manglani
 * @version 1.1 22-Aug-2017
 */
public class DStack<T extends Object> implements CustomStack<T>{


	/** The size. */
	private int size = 0;


	/** The head. */
	Node<T> head = null;


	/** The node. */
	Node<T> node = new Node<T>();



	/**
	 * Size.
	 *
	 * @return the size of stack
	 */
	public int size(){
		return size;
	}


	/**
	 * Check range.
	 */
	private void checkRange(){
		if(isEmpty()){
			throw new IllegalArgumentException("Stack Is Empty");
		}
	}
	/**isEmpty
	 * 
	 * @return true if stack is empty else false
	 */
	public boolean isEmpty(){
		return size==0;
	}


	/**
	 * Push.
	 * This method push element at the top of stack
	 * @param element the element
	 */
	@Override
	public void push(T element) {
		Node<T> newNode = node.getNode(element);
		newNode.previous = this.head;
		this.head = newNode;
		size++;
	}


	/**
	 * Pop.
	 * This method removes the element from top of stack
	 * @return the element of type T
	 */
	@Override
	public T pop() {
		T element = null;
		try{
			checkRange();
			element = this.head.getData();
			this.head = this.head.previous;
			size--;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return element;
	}



	/**
	 * Peek.
	 * This method returns the head element It does not remove the element from stack
	 * @return the element of type T
	 */
	@Override
	public T peek() {
		T element = null;
		try{
			checkRange();
			element = this.head.getData();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return element;
	}
}
