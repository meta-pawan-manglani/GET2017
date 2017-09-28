/*
 * 
 */
package com.metacube.customDoubleLinkedList;

/**
 * The Class Node.
 *@author Pawan Manglani
 *@version 1.1 21-Aug-2017
 * @param <T> the element type
 */
public class Node<T> {
	
	/** The data. */
	T data;
	
	/** The previous. */
	Node<T> next,previous;

	/**
	 * Next.
	 *
	 * @return the node
	 */
	public Node<T> next() {
		return this.next;
	}

	/**
	 * Previous.
	 *
	 * @return the node
	 */
	public Node<T> previous() {
		return this.previous;
	}
	
	/**
	 * Gets the node.
	 *
	 * @param data the data
	 * @return the node
	 */
	public Node<T> getNode(T data) {
		Node<T> node = new Node<>();
		node.data = data;
		node.next = null;
		node.previous = null;
		return node;
	}

}
