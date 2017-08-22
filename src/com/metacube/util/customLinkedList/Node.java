/*
 * 
 */
package com.metacube.util.customLinkedList;

/**
 * The Class Node.
 *@author Pawan Manglani
 *@version 1.1 22-Aug-2017
 * @param <T> the generic type
 */
public class Node<T extends Object> {

	/** The data. */
	T data;
	
	/** The next. */
	Node<T> next;

	/**
	 * Next.
	 *
	 * @return the node
	 */
	public Node<T> next() {
		return this.next;
	}

	/**
	 * Gets the node.
	 *
	 * @param data the data
	 * @return the node
	 */
	public Node<T> getNode(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = null;
		return node;
	}	
}
