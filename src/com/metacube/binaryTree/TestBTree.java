package com.metacube.binaryTree;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The Class TestBTree.
 * 
 * @author Pawan Manglani
 * @version 1.1 23-Aug-2017
 *
 */
public class TestBTree {

	/** The tree. */
	static BinaryTree<Integer> tree;
	
	/** The mirror tree. */
	static BinaryTree<Integer> mirrorTree;
	
	/**
	 * Test.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@BeforeClass
	public static void test(){
		tree = new BinaryTree();
		tree.insertNode(10);
		tree.insertNode(20);
		tree.insertNode(30);
		tree.insertNode(40);
		tree.insertNode(50);
		tree.inOrder();
		tree.preOrder();
		tree.postOrder();
		mirrorTree = new BinaryTree();
		mirrorTree.insertMirrortNode(10);
		mirrorTree.insertMirrortNode(20);
		mirrorTree.insertMirrortNode(30);
		mirrorTree.insertMirrortNode(40);
		mirrorTree.insertMirrortNode(50);
	}
	
	/**
	 * test mirror check.
	 */
	@Test
	public void testMirror() {
		boolean expected = tree.mirror(tree.getRoot(), mirrorTree.getRoot());
		boolean actual = true;
		assertEquals(expected,actual);
	}
	
	/**
	 * test the root.
	 */
	@Test
	public void testRoot(){
		Object expected = tree.getRoot().data;
		Object actual = 10;
		assertEquals(expected,actual);
	}
	
	/**
	 * test InOrder.
	 */
	@Test
	public void testInOrder(){
		String expected = tree.getInOrder();
		String actual = "20 10 40 30 50 ";
		assertEquals(expected,actual);
	}
	
	/**
	 * test PreOrder.
	 */
	@Test
	public void testPreOrder(){
		String expected = tree.getPreOrder();
		String actual = "10 20 30 40 50 ";
		assertEquals(expected,actual);
	}
	
	/**
	 * test PostOrder.
	 */
	@Test
	public void testPostOrder(){
		String expected = tree.getPostOrder();
		String actual = "20 40 50 30 10 ";
		assertEquals(expected,actual);
	}
	
}
