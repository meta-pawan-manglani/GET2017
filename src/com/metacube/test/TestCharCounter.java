/*
 * @author Pawan Manglani
 * @version 1.1 28-Aug-2017
 */
package com.metacube.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metacube.distinctCharCounter.CountDistinctChar;

/**
 * The Class TestCharCounter.
 * This class test distinct char counter in class
 */
public class TestCharCounter {


	/**
	 * Test 1.
	 * This method test on normal input
	 */
	@Test
	public void test1() {
		String input = "aabcdef";
		int expected = CountDistinctChar.getUniqueChar(input);
		int actual = 5;
		assertEquals(expected, actual);
	}

	/**
	 * Test 2.
	 * This method test empty string
	 */
	@Test
	public void test2() {
		String input = "";
		int expected = CountDistinctChar.getUniqueChar(input);
		int actual = 0;
		assertEquals(expected, actual);
	}

	/**
	 * Test 3.
	 * This method test null cases
	 */
	@Test
	public void test3() {
		String input = null;
		int expected = CountDistinctChar.getUniqueChar(input);
		int actual = 0;
		assertEquals(expected, actual);
	}

	/**
	 * Test 4.
	 * This method test on input when a character is occur in both form uppercase and lowercase
	 */
	@Test
	public void test4() {
		String input = "aAbBcCdD";
		int expected = CountDistinctChar.getUniqueChar(input);
		int actual = 0;
		assertEquals(expected, actual);
	}

	/**
	 * Test 5.
	 * This method test on input when a character is occur in uppercase 
	 */
	@Test
	public void test5() {
		String input = "AABCADB";
		int expected = CountDistinctChar.getUniqueChar(input);
		int actual = 2;
		assertEquals(expected, actual);
	}

	/**
	 * Test 6.
	 * This method test on input when a single length string is provide as input
	 */
	@Test
	public void test6() {
		String input = "a";
		int expected = CountDistinctChar.getUniqueChar(input);
		int actual = 1;
		assertEquals(expected, actual);
	}

}
