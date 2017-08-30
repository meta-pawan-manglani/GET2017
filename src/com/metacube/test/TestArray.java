/*
 * @author Pawan Manglani
 * @version 1.1 29-Aug-2017
 */
package com.metacube.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metacube.controller.ArrayController;

/**
 * The Class TestArray.
 */
public class TestArray {

	/** The array. */
	static int array[];

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		array = new int[]{20,30,40,50,60,70};
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		array = null;
	}

	/**
	 * Test when element is in array.
	 */
	@Test
	public void testWhenElementIsInArray() {
		int key = 50;
		int actual = ArrayController.binarySearch(array, 0, array.length, key);
		int expected = 3;
		assertEquals(expected, actual);
	}

	/**
	 * Test when element is not in array.
	 */
	@Test
	public void testWhenElementIsNotInArray() {
		int key = 0;
		int actual = ArrayController.binarySearch(array, 0, array.length, key);
		int expected = -1;
		assertEquals(expected, actual);
	}

	/**
	 * Test null exception.
	 */
	@Test (expected = NullPointerException.class)
	public void testNullException() {
		int key = 0;
		array = null;
		ArrayController.binarySearch(array, 0, array.length, key);
	}

}
