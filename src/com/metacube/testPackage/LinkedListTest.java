package com.metacube.testPackage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metacube.customDoubleLinkedList.DoublyLinkedList;
import com.metacube.util.Utility;
import com.metacube.util.customArrayList.CustomList;



/**
 * Test class for DoublyLinkedList
 * @author Pawan Manglani
 * @version 1.1 22-Aug-2017
 */
public class LinkedListTest {
	
	/*
	 * This method test the creation
	 */
	@Test
	public void createLinkedListPass(){
		
		CustomList<String> linkedList = new DoublyLinkedList<>();
		
		linkedList.add("pawan");
		linkedList.add("manglani");
        
		assertEquals("manglani", linkedList.get(1));
		
	}
	/*
	 * This method test the add at index method
	 */
	@Test
	public void addToListIndex(){
		
		CustomList<String> linkedList = new DoublyLinkedList<String>();
		linkedList.add(0,"manglani");
		System.out.println(linkedList.toString());
		assertEquals("manglani", linkedList.get(0));
		
	}
	
	/*
	 * This method test the reversal method
	 */
	@Test
	public void reversalTest(){
		
		DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<Integer>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
	
		Utility.reverse(linkedList);
		DoublyLinkedList<Integer> expected = new DoublyLinkedList<Integer>();
		expected.add(3);
		expected.add(2);
		expected.add(1);
		
		assertEquals(linkedList.get(0), expected.get(0));
		assertEquals(linkedList.get(1), expected.get(1));
		assertEquals(linkedList.get(2), expected.get(2));
		
		
	}
	
	/*
	 * This method test the sort method
	 */
	@Test
	public void sort(){
		
		DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<Integer>();
		linkedList.add(12);
		linkedList.add(22);
		linkedList.add(13);
		
		
		Utility.sort(linkedList);
		DoublyLinkedList<Integer> expected = new DoublyLinkedList<Integer>();
		expected.add(12);
		expected.add(13);
		expected.add(22);
		
		assertEquals(linkedList.get(0), expected.get(0));
		assertEquals(linkedList.get(1), expected.get(1));
		assertEquals(linkedList.get(2), expected.get(2));
	}
	
	/*
	 * This method test the remove element method
	 */
	@Test
	public void removeElementPass(){
		
		DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<Integer>();
		linkedList.add(12);
		linkedList.add(22);
		linkedList.add(13);
		
		linkedList.remove(0);
		Integer expected = 13;
		assertEquals(expected, linkedList.get(1));
		
	}

}
