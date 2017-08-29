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
	private static BinaryTree<Integer> tree;
	
	/** The mirror tree. */
	private static BinaryTree<Integer> mirrorTree;
	
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
		mirrorTree = new BinaryTree();
		mirrorTree.insertNode(50);
		mirrorTree.insertNode(20);
		mirrorTree.insertNode(30);
		mirrorTree.insertNode(10);
		mirrorTree.insertNode(40);
	}
	
	/**
	 * test mirror check.
	 */
	@Test
	public void testMirror() {
		boolean expected = tree.mirror(mirrorTree);
		boolean actual = false;
		assertEquals(expected,actual);
	}
	
	/**
	 * test the root.
	 */
	@Test
	public void testRoot(){
		Object expected = tree.getRoot().getData();
		Object actual = 10;
		assertEquals(expected,actual);
	}
	
	/**
	 * test InOrder.
	 */
	@Test
	public void testInOrder(){
		String expected = tree.getInOrder();
		String actual = "40 20 50 10 30 ";
		assertEquals(expected,actual);
	}
	
	/**
	 * test PreOrder.
	 */
	@Test
	public void testPreOrder(){
		String expected = tree.getPreOrder();
		String actual = "10 20 40 50 30 ";
		assertEquals(expected,actual);
	}
	
	/**
	 * test PostOrder.
	 */
	@Test
	public void testPostOrder(){
		String expected = tree.getPostOrder();
		String actual = "40 50 20 30 10 ";
		assertEquals(expected,actual);
	}
	
	/**
	 * test when tree are mirror of each other.
	 */
	@Test
	public void testWhenTreeAreMirror(){
		BinaryTree<Integer> tree1 = new BinaryTree<Integer>();
		BinaryTree<Integer> mirrorTree1 = new BinaryTree<Integer>();
		tree1.insertNode(1);
		tree1.insertNode(3);
		tree1.insertNode(2);
		tree1.insertNode(5);
		tree1.insertNode(4);
		tree1.insertNode(6);
		tree1.insertNode(7);
		mirrorTree1.insertNode(1);
		mirrorTree1.insertNode(3);
		mirrorTree1.insertNode(2);
		mirrorTree1.insertNode(7);
		mirrorTree1.insertNode(6);
		mirrorTree1.insertNode(5);
		mirrorTree1.insertNode(4);
		boolean actual = tree1.mirror(mirrorTree);
		boolean expected = false;
		assertEquals(expected, actual);
	}
}
