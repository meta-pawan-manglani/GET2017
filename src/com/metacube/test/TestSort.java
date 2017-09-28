package com.metacube.test;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.metacube.controller.ComparisonSort;
import com.metacube.controller.LinearSort;
import com.metacube.controller.Sort;

public class TestSort {
	/**
	 * test bubble sort for numbers where array should be less than 10
	 */
	@Test
	public void testBubbleSort() {
		int[] input = { 1, 23, -34, 65, 78 };
		Sort system = new ComparisonSort();
		String actual = "";
		String expected = "";
		system.sort(input);
		actual += Arrays.toString(input);
		expected = "[-34, 1, 23, 65, 78]";
		assertEquals(expected, actual);
	}

	/**
	 * test quick sort for numbers where array would be more than 10
	 */
	@Test
	public void testQuickSort() {
		int[] input = { 1, 23, -34, 65, 78, 33, 12, 44, 23, 6, 11, 13 };
		Sort system = new ComparisonSort();
		String actual = "";
		String expected = "";
		system.sort(input);
		actual += Arrays.toString(input);
		expected = "[-34, 1, 6, 11, 12, 13, 23, 23, 33, 44, 65, 78]";
		assertEquals(expected, actual);
	}

	/**
	 * test counting sort for numbers where array should have numbers less than
	 * 100
	 */
	@Test
	public void testCountingSort() {
		int[] input = { 1, 23, 34, 65, 78, 23, 34, 23 };
		Sort system = new LinearSort();
		String actual = "", expected = "";
		system.sort(input);
		actual += Arrays.toString(input);
		expected = "[1, 23, 23, 23, 34, 34, 65, 78]";
		assertEquals(expected, actual);
	}

	/**
	 * test radix sort for numbers where array have numbers more than 99
	 */
	@Test
	public void testRadixSort() {
		int[] input = { 1, 123, 34, 65, 178, 23, 34, 23 };
		Sort system = new LinearSort();
		String actual = "", expected = "";
		system.sort(input);
		actual += Arrays.toString(input);
		expected = "[1, 23, 23, 34, 34, 65, 123, 178]";
		assertEquals(expected, actual);
	}
}

