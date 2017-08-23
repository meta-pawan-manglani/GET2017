package com.metacube.binaryTree;


/**
 * The Class BinaryTree.
 * 
 * @author Pawan Manglani
 * @version 1.1 23-Aug-2017
 * @param <T> the element type
 */
public class BinaryTree<T> {

	/** The root. */
	BTNode<T> root;

	/** The post order. */
	String inOrder,preOrder,postOrder;

	/**
	 * Instantiates a new binary tree.
	 */
	public BinaryTree(){
		inOrder = "";
		preOrder="";
		postOrder="";
		root = null;
	}

	/**
	 * create a skew tree towards right .
	 *
	 * @param root the root
	 * @param data the data
	 * @return node
	 */
	public BTNode<T> insert(BTNode<T> root , T data){
		if(root == null){
			root = new BTNode<T>(data);
		}
		else{
			if( root.left == null ){
				root.left = insert(root.left() , data);
			}
			else{
				root.right = insert(root.right() , data);
			}
		}
		return root;
	}

	/**
	 * create mirror tree towards left.
	 *
	 * @param root the root
	 * @param data the data
	 * @return node
	 */
	public BTNode<T> insertMirrorNode(BTNode<T> root , T data){
		if(root == null){
			root = new BTNode<T>(data);
		}
		else{
			if( root.right == null ){
				root.right = insertMirrorNode(root.right() , data);
			}
			else{
				root.left = insertMirrorNode(root.left() , data);
			}
		}
		return root;
	}

	/**
	 * preOrder traversal.
	 *
	 * @param root the root
	 */
	public void printPreOrder(BTNode<T> root){
		if(root==null){
			return ;
		}
		preOrder += root.data + " ";
		printPreOrder(root.left());
		printPreOrder(root.right());
	}

	/**
	 * post order traversal.
	 *
	 * @param root the root
	 */
	public void printPostOrder(BTNode<T> root){

		if(root==null){
			return ;
		}
		printPostOrder(root.left());
		printPostOrder(root.right());
		postOrder += root.data+" ";

	}

	/**
	 * inorder traversal.
	 *
	 * @param root the root
	 */
	public void printInOrder(BTNode<T> root){

		if(root==null){
			return ;
		}
		printInOrder(root.left());
		inOrder+=root.data + " ";
		printInOrder(root.right());
	}

	/**
	 * call preOrder.
	 */
	public void preOrder(){
		printPreOrder(root);
	}

	/**
	 * call postOrder.
	 */
	public void postOrder(){
		printPostOrder(root);
	}

	/**
	 * call Inorder.
	 */
	public void inOrder(){
		printInOrder(root);
	}

	/**
	 * call insert Node.
	 *
	 * @param data the data
	 */
	public void insertNode(T data){
		root = insert(root,data);
	}

	/**
	 * call insert node of mirror.
	 *
	 * @param data the data
	 */
	public void insertMirrortNode(T data){
		root = insertMirrorNode(root,data);
	}

	/**
	 * Gets the in order.
	 *
	 * @return inorder result
	 */
	public String getInOrder(){
		return inOrder;
	}

	/**
	 * Gets the pre order.
	 *
	 * @return preOrder Result
	 */
	public String getPreOrder(){
		return preOrder;
	}

	/**
	 * Gets the post order.
	 *
	 * @return postorder result
	 */
	public String getPostOrder(){
		return postOrder;
	}

	/**
	 * Mirror.
	 *
	 * @param newRoot the new root
	 * @param oldRoot the old root
	 * @return true, if successful
	 */
	public boolean mirror(BTNode<T> newRoot,BTNode<T> oldRoot){
		if(newRoot == null && oldRoot==null)
			return true;

		if(newRoot == null || oldRoot==null)
			return false;

		return oldRoot.data.toString().equals(newRoot.data.toString()) && mirror(newRoot.left(),oldRoot.right()) && mirror(newRoot.right(),oldRoot.left());
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
