package com.metacube.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metacube.stack.DStack;
import com.metacube.stack.InfixToPostfix;


/**
 * The Class StackTest.
 * 
 *  @author Pawan Manglani
 * @version 1.1 22-Aug-2017
 */
public class StackTest {


	static DStack<Integer> ds;


	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ds = new DStack<>();
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ds = null;
	}

	/**
	 * Test. Infix to Postfix conversion
	 */
	@Test
	public void testConvertInfixToPostfix() {
		String expected = InfixToPostfix.convertToPostfix("(A + B) * C + D / (E + F * G) - H");
		String actual = "AB+C*DEFG*+/+H-";
		assertEquals(expected , actual);
	}

	/**
	 * Test. size function of stack
	 */
	@Test
	public void checkSize(){
		ds.push(1);
		ds.push(2);
		ds.push(3);
		ds.push(4);
		int expected = ds.size();
		int actual = 4;
		assertEquals(expected , actual);
	}

	/**
	 * Test. pop function of stack
	 */
	@Test
	public void checkPop(){
		Object expected = ds.pop();
		Object actual = 4;
		assertEquals(expected , actual);
	}

}
