package com.metacube.testPackage;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metacube.util.Utility;
import com.metacube.util.customArrayList.CustomArrayList;
import com.metacube.util.customArrayList.CustomList;
/**
 * Test class for CustomArrayList
 * @author Pawan Manglani
 * @version 1.1 22-Aug-2017
 */
public class ArrayListTest {
	/*
	 * This method test the toArray method
	 */
	@Test
	public void createArray(){
		CustomList<String> arrayList = new CustomArrayList<>(3);

		arrayList.add(1,"pawan");

		CustomList<String> expected = new CustomArrayList<>(3);

		expected.add(0,null);
		expected.add(1,"pawan");
		expected.add(2,null);

		assertArrayEquals(expected.toArray(), arrayList.toArray());

	}
	/*
	 * This method test the add method
	 */
	@Test
	public void addPass() {

		CustomList<String> arrayList = new CustomArrayList<>();
		arrayList.add("pawan");
		assertEquals("pawan", arrayList.get(0));

	}

	/*
	 * This method test the add at index method
	 */
	@Test
	public void addIndexPass() {

		CustomList<String> arrayList = new CustomArrayList<>();

		arrayList.add("pawan");
		arrayList.add("prateek");
		arrayList.add("udit");

		arrayList.add(1, "chouhan");

		assertEquals("chouhan", arrayList.get(1));

	}
	/*
	 * This method test the clear method
	 */
	@Test
	public void clearPass() {

		CustomList<String> arrayList = new CustomArrayList<>();

		arrayList.add("pawan");
		arrayList.add("chouhan");

		arrayList.clear();
		assertEquals(0, arrayList.size());

	}

	/*
	 * This method test the reverse method
	 */
	@Test
	public void reverseTest() {

		CustomList<Integer> arrayList = new CustomArrayList<>();

		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);

		Utility.reverse(arrayList);
		CustomList<Integer> reverseCustomList = new CustomArrayList<>();

		reverseCustomList.add(4);
		reverseCustomList.add(3);
		reverseCustomList.add(2);
		reverseCustomList.add(1);

		assertArrayEquals(reverseCustomList.toArray(), arrayList.toArray());

	}

	/*
	 * This method test the indexOf method
	 */
	@Test
	public void firstOccurrencePass() {

		CustomList<Integer> arrayList = new CustomArrayList<>();

		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(2);
		arrayList.add(4);
		arrayList.add(2);
		System.out.println(arrayList.toString());
		int actual = arrayList.indexOf(2);
		int expected = 1;

		assertEquals(expected, actual);

	}

	/*
	 * This method test the sorting method
	 */
	@Test
	public void sortPass() {

		CustomList<Integer> arrayList = new CustomArrayList<>();

		arrayList.add(10);
		arrayList.add(12);
		arrayList.add(20);
		arrayList.add(14);
		arrayList.add(13);

		Utility.sort(arrayList);

		CustomList<Integer> expected = new CustomArrayList<>();

		expected.add(10);
		expected.add(12);
		expected.add(13);
		expected.add(14);
		expected.add(20);

		assertArrayEquals(arrayList.toArray(), expected.toArray());

	}
	/*
	 * This method test the get method
	 */
	@Test
	public void getPass() {
		CustomList<Integer> arrayList = new CustomArrayList<Integer>();

		arrayList.add(10);
		arrayList.add(12);
		Integer expected = 12;
		assertEquals(expected, arrayList.get(1));

	}

	/*
	 * This method test the add another list method
	 */
	@Test
	public void addListTest(){

		CustomList<String> arrayList = new CustomArrayList<>();

		arrayList.add("pawan");
		arrayList.add("chouhan");
		arrayList.add("udit");
		arrayList.add("saxena");

		CustomList<String> subList = new CustomArrayList<>();

		subList.add("Gaurav");
		subList.add("tak");

		arrayList.addAll(subList);

		CustomList<String> expected = new CustomArrayList<>();

		expected.add("pawan");
		expected.add("chouhan");
		expected.add("udit");
		expected.add("saxena");
		expected.add("Gaurav");
		expected.add("tak");

		assertArrayEquals(expected.toArray(), arrayList.toArray());

	}

}
