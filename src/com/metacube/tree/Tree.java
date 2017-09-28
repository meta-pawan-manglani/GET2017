/*
 * @author Pawan Manglani
 * @version 1.1 29-Aug-2017
 */
package com.metacube.tree;


import java.util.Arrays;

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

	/** The student. */
	private int student[];
	
	/** The index. */
	private int index;
	
	/**
	 * Instantiates a new tree.
	 *
	 * @param size the size
	 * @throws Exception 
	 */
	public Tree(int size) throws Exception {
		root = null;
		if(size<0) {
			throw new Exception("Enter Positive Size");
		}
		student = new int[size];
		index = 0;
		tree="";
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
			student[index] = (int)root.getData();
			index++;
			inorder(root.getRight());     
		}
	}
	/*
	 * String representation of tree
	 */
	@Override
	public String toString() {
		this.tree="";
		inorder(root); 
		if(tree.length()==0) {
			tree = "Empty";
		}
		return Arrays.toString(student);
	}

}
