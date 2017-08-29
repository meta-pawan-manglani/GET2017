package com.metacube.binaryTree;

import com.metacube.queue.CustomQueue;


/**
 * The Class BinaryTree.
 * 
 * @author Pawan Manglani
 * @version 1.1 23-Aug-2017
 * @param <T> the element type
 */
public class BinaryTree<T> {

	/** The root. */
	private BTNode<T> root;

	/** The post order. */
	private String inOrder,preOrder,postOrder;

	/** Queue which store the parent Nodes */ 
	private CustomQueue<BTNode<T>> parentNodes;


	/**
	 * Instantiates a new binary tree.
	 */
	public BinaryTree(){
		inOrder = "";
		preOrder="";
		postOrder="";
		root = null;
		this.parentNodes = new CustomQueue<>();
	}

	/**
	 * create a skew tree towards right .
	 *
	 * @param root the root
	 * @param data the data
	 * @return node
	 */
	public boolean insert(T data) {
		BTNode<T> newNode = new BTNode<>(data);
		if (this.root == null) {
			this.root = newNode;
			parentNodes.enqueue(this.root);
		} else {
			BTNode<T> currentNode = parentNodes.getFront();
			if (currentNode.getLeft() == null) {
				currentNode.setLeft(newNode);
				parentNodes.enqueue(currentNode.getLeft());
			} else {
				currentNode.setRight(newNode);
				parentNodes.enqueue(currentNode.getRight());
				parentNodes.dequeue();
			}
		}

		return true;
	}

	/**
	 * preOrder traversal.
	 *
	 * @param root the root
	 */
	private void printPreOrder(BTNode<T> root){
		if(root==null){
			return ;
		}
		preOrder += root.getData() + " ";
		printPreOrder(root.getLeft());
		printPreOrder(root.getRight());
	}

	/**
	 * post order traversal.
	 *
	 * @param root the root
	 */
	private void printPostOrder(BTNode<T> root){

		if(root==null){
			return ;
		}
		printPostOrder(root.getLeft());
		printPostOrder(root.getRight());
		postOrder += root.getData()+" ";

	}

	/**
	 * inorder traversal.
	 *
	 * @param root the root
	 */
	private void printInOrder(BTNode<T> root){
		if(root==null){
			return ;
		}
		printInOrder(root.getLeft());
		inOrder+=root.getData() + " ";
		printInOrder(root.getRight());
	}
	/**
	 * call insert Node.
	 *
	 * @param data the data
	 */
	public void insertNode(T data){
		 insert(data);
	}

	/**
	 * Gets the in order.
	 *
	 * @return in order result
	 */
	public String getInOrder(){
		printInOrder(root);
		return inOrder;
	}

	/**
	 * Gets the pre order.
	 *
	 * @return preOrder Result
	 */
	public String getPreOrder(){
		printPreOrder(root);
		return preOrder;
	}

	/**
	 * Gets the post order.
	 *
	 * @return post order result
	 */
	public String getPostOrder(){
		printPostOrder(root);
		return postOrder;
	}

	/**
	 * Mirror.
	 *
	 * @param root another tree
	 * @return true, if successful
	 */
	public boolean mirror(BinaryTree<T> root){
		/* In order of argument tree */ 
		String inOrder1 = root.getInOrder();
		/*In order of caller tree*/
		String inOrder2 = this.getInOrder();
		boolean result = true;
		/*If length is not equal then return false*/
		if(inOrder1.length() != inOrder2.length()) {
			result = false;
		}
		/*inOrder of tree 1 should be reverse of inOrder of tree 2*/ 
		if(result) {
			int len = inOrder1.length();
			for(int index1 = 0,index2 = len-1 ; index1<len ; index1++,index2--) {
				if(inOrder1.charAt(index1) != inOrder.charAt(index2)) {
					result = false;
					break;
				}
			}
		}
		/*return result*/
		return result;
	}

	/**
	 * Gets the root.
	 *
	 * @return root
	 */
	public BTNode<T> getRoot(){
		return this.root;
	}
}
