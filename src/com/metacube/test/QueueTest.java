package com.metacube.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metacube.queue.CustomQueue;

/**
 * The Class QueueTest.
 *  @author Pawan Manglani
 * @version1.10 22 Aug 2017
 */
public class QueueTest {

	/** The queue. */
	static CustomQueue<String> queue;
	
	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		queue = new CustomQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(4);
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

	/**
	 * test dequeue operation of queue.
	 */
	@Test
	public void test() {
		Object expected = queue.dequeue();
		Object actual = 1;
		assertEquals(expected,actual);
	}
	
	/**
	 * test size of queue.
	 */
	@Test
	public void testSize() {
	int expected = queue.size();
	int actual = 5;
	assertEquals(expected,actual);
	}
	
	/**
	 * test front of queue.
	 */
	@Test
	public void testFront(){
	Object expected = queue.getFront();
	Object actual = 1;
	assertEquals(expected,actual);
	}

}
