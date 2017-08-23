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
	T data;
	
	/** The left. */
	BTNode<T> left;
	
	/** The right. */
	BTNode<T> right;
	
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
