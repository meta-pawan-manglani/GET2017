/*
 * @author Pawan Manglani
 * @version 1.1 29-Aug-2017
 */
package com.metacube.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metacube.tree.Tree;


/**
 * The Class TestTree.
 * This class test the tree class 
 */
public class TestTree {

	/** The tree. */
	private static Tree<Integer> tree;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tree = new Tree<>();
		tree.insertData(50);
		tree.insertData(60);
		tree.insertData(40);
		tree.insertData(45);
		tree.insertData(55);
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tree = null;
	}

	/**
	 * Test when element is present.
	 */
	@Test
	public void testWhenElementIsPresent() {
		int actual = tree.search(55);
		int expected = 3;
		assertEquals(expected, actual);
	}

	/**
	 * Test when element is not present.
	 */
	@Test
	public void testWhenElementIsNotPresent() {
		int actual = tree.search(0);
		int expected = -1;
		assertEquals(expected, actual);
	}

}
