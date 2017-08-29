package com.metacube.binaryTree;
/**
 * The Class BTNode.
 *
 * @author Pawan Manglani
 * @version 1.1 23-Aug-2017
 * @param <T> the element type
 */
public class BTNode<T> {
	
	/** The data. */
	private T data;
	
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/** The left. */
	public BTNode<T> left;
	
	/** The right. */
	public BTNode<T> right;
	
	/**
	 * Instantiates a new BT node.
	 *
	 * @param data the data
	 */
	public BTNode(T data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Left.
	 *
	 * @return the BT node
	 */
	public BTNode<T> left(){
		return this.left;
	}
	
	/**
	 * Right.
	 *
	 * @return the BT node
	 */
	public BTNode<T> right(){
		return this.right;
	}
	
}
