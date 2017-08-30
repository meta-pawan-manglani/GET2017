/*
 * @author Pawan Manglani
 * @version 1.1 29-Aug-2017
 */
package com.metacube.tree;


import com.metacube.node.Node;
/**
 * The Class Tree.
 *
 * @param <T> the generic type
 */
public class Tree<T extends Comparable<T>>{

	/** The root. */
	private Node<T> root;

	/**  The Tree. */
	private String tree;

	/**
	 * Instantiates a new tree.
	 */
	public Tree() {
		root = null;
		tree = "";
	}

	/**
	 * Insert.
	 *
	 * @param root the root
	 * @param data the data
	 * @return the node
	 */
	private Node<T> insert(Node<T> root,T data) {
		if(root==null) {
			root = new Node<T>(data);
		} else {
			if(data.compareTo(root.getData()) < 0 ) {
				root.setLeft(insert(root.getLeft(),data));
			} else {
				root.setRight(insert(root.getRight(),data));
			}
		}
		return root;
	}

	/**
	 * Insert data.
	 *
	 * @param data the data
	 */
	public void insertData(T data) {
		try {
			this.root = insert(this.root,data); 
		}catch(Exception e) {
			System.out.println("Error Caught " + e.getMessage() + " while inserting the data");
		}
	}

	/**
	 * Inorder.
	 *
	 * @param root the root
	 */
	private void inorder(Node<T> root)
	{
		if(root!=null)
		{
			inorder(root.getLeft());    
			tree += root.getData() + " ";   
			inorder(root.getRight());     
		}
	}

	/**
	 * Search data.
	 *
	 * @param node the node
	 * @param data the data
	 * @return true, if successful
	 */
	private boolean searchData(Node<T> node,T data) {
		if(node!=null) {
			if(node.getData().compareTo(data)==0) {
				return true;
			} else if(data.compareTo(node.getData())<0) {
				return  searchData(node.getLeft(),data);
			} else  {
				return searchData(node.getRight(),data);
			}
		}
		return false;
	}

	/**
	 * Search.
	 *
	 * @param data the data
	 * @return the int
	 */
	public int search(T data) {
		int result  = -1;
		try {
			if(searchData(this.root,data)) {
				result = positionHelper(this.root,data,0);
			}
		}catch(Exception e) {
			System.out.println("Error Caught " + e.getMessage() + " while Searching the data");
		}
		return result;
	}


	/**
	 * Position helper.
	 *
	 * @param currentNode the current node
	 * @param data the data
	 * @param steps the steps
	 * @return the int position of node
	 */
	private int positionHelper(Node<T> currentNode,T data,int steps) {
		// In-order search checks left node, then current node, then right node
		if(currentNode.getLeft() != null) {
			steps = positionHelper(currentNode.getLeft(),data, steps++);
		}

		// We found the node or have already moved over the node, return current steps
		if(currentNode.getData().compareTo(data) >=0 ) {
			return steps;
		}

		// Next Node Index  
		steps++;
		//Checking the right node
		if(currentNode.getRight() != null) {
			steps = positionHelper(currentNode.getRight(),data, steps++);
		}

		return steps;
	}

	/*
	 * String representation of tree
	 */
	@Override
	public String toString() {
		this.tree = "";
		inorder(root); 
		if(tree.length()==0) {
			tree = "Empty";
		}
		return tree;
	}

}
