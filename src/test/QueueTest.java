package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import queue.CustomQueue;

/**
 * The Class QueueTest.
 * This class test the queue class
 * @author Pawan Manglani
 * @version 1.1 27-Aug-2017
 */
public class QueueTest {

	/** The queue. */
	private static CustomQueue<Integer> queue;
	
	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		queue = new CustomQueue<>();
	}

	/**
	 * Test 1.
	 * this method test the enqueue method
	 */
	@Test
	public void test1() {
		queue.enqueue(1);
		String actual = queue.print();
		String expected = "[1]";
		assertEquals(expected,actual);
	}
	
	/**
	 * Test 2.
	 *This method test the dequeue method
	 * @throws Exception the exception
	 */
	@Test
	public void test2() throws Exception {
		int actual = queue.dequeue();
		int expected = 1;
		assertEquals(expected,actual);
	}
	
	
	
	/**
	 * Test 3.
	 * This method test the print method
	 */
	@Test
	public void test3() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		String actual = queue.print();
		String expected = "[1, 2, 3]";
		assertEquals(expected,actual);
	}
	
	
	/**
	 * Test 4.
	 * This method test the clear method
	 */
	@Test
	public void test4() {
		queue.clearQueue();
		String actual = queue.print();
		String expected = "Queue is Empty";
		assertEquals(expected,actual);
	}

	/**
	 * Test 5.
	 * This method test the clear method even when the queue is empty
	 * @throws Exception 
	 */
	@Test(expected = Exception.class)
	public void test5() throws Exception {
		queue.dequeue();
	}
	
	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		queue = null;
	}
}
