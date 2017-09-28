
package com.metacube.stack;

/**
 * The Class Node.
 *
 * @author Pawan Manglani
 * @version 1.1 22-Aug-2017
 * @param <T> the generic type
 */
public class Node<T> {
	/** The data. */
	private T data;

	/** The previous. */
	public Node<T> previous;

	/**
	 * Gets the node.
	 *
	 * @param data the data
	 * @return the node
	 */
	public  Node<T> getNode(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.previous = null;
		return node;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public T getData() {
		return this.data;
	}	

}

