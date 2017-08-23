package com.metacube.stack;


/**
 * The Interface CustomStack.
 *
 * @param <T> the generic type
 * @author Pawan Manglani
 * @version 1.1 22-Aug-2017
 */
public interface CustomStack<T> {


	/**
	 * Push.
	 * This method push element at the top of stack
	 * @param element the element
	 */
	public void push(T element);

	/**
	 * Pop.
	 * This method removes the element from top of stack
	 * @return the element of type T
	 */
	public T pop();

	/**
	 * Peek.
	 * This method returns the head element It does not remove the element from stack
	 * @return the element of type T
	 */
	public T peek();
}
