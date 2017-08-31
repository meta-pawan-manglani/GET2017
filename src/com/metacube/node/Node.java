/*
 * @author Pawan Manglani
 * @version 1.1 23-Aug-2017
 */
package com.metacube.node;

/**
 * The Class Node.
 * @param <T> the element type
 */
public class Node<T extends Comparable<?>> {

	/** The data. */
	private T data;

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/** The left. */
	private Node<T> left;

	/** The right. */
	private Node<T> right;

	/**
	 * Instantiates a new BT node.
	 *
	 * @param data the data
	 */
	public Node(T data){
		this.data = data;
		this.left = null;
		this.right = null;
	}

	/**
	 * Left.
	 *
	 * @return the BT node
	 */
	public Node<T> getLeft(){
		return this.left;
	}

	/**
	 * Right.
	 *
	 * @return the BT node
	 */
	public Node<T> getRight(){
		return this.right;
	}

	/**
	 * Left.
	 * 
	 * set left of the  node
	 *
	 * @param left the new left
	 */
	public void setLeft(Node<T> left){
		this.left = left;
	}

	/**
	 * Right.
	 * 
	 * set right of the  node
	 *
	 * @param right the new right
	 */
	public void setRight(Node<T> right){
		this.right = right;
	}
}
