/*
 * 
 */
package com.metacube.customDoubleLinkedList;

/**
 * The Class Node.
 *@author Pawan Manglani
 *@version 1.1 21-Aug-2017
 * @param <E> the element type
 */
public class Node<E> {
	
	/** The data. */
	E data;
	
	/** The previous. */
	Node<E> next,previous;

	/**
	 * Next.
	 *
	 * @return the node
	 */
	public Node<E> next() {
		return this.next;
	}

	/**
	 * Previous.
	 *
	 * @return the node
	 */
	public Node<E> previous() {
		return this.previous;
	}
	
	/**
	 * Gets the node.
	 *
	 * @param data the data
	 * @return the node
	 */
	public Node<E> getNode(E data) {
		Node<E> node = new Node<E>();
		node.data = data;
		node.next = null;
		node.previous = null;
		return node;
	}

}
