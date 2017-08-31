/*
 * @author Pawan Manglani
 * @version 1.1 31-Aug-2017
 */
package com.metacube.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metacube.tree.Tree;

/**
 * The Class TestStudent.
 */
public class TestStudent {
	
	/** The tree. */
	private static Tree<Integer> tree;

	/**
	 * set up object to add values .
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tree = new Tree<>(6);
		tree.insertData(5);
		tree.insertData(5);
		tree.insertData(4);
		tree.insertData(3);
		tree.insertData(2);
		tree.insertData(1);
	}

	/**
	 * free the resources.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tree = null;
	}

	/**
	 * test for sorting of roll no. in ascending order
	 */
	@Test
	public void testSorting() {
		String actual = tree.toString();
		String expected ="[1, 2, 3, 4, 5, 5]";
		assertEquals(expected,actual);
	}
}

