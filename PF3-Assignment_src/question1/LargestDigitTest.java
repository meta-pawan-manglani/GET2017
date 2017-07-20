package question1;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *  Class description
 * 
 *  This class will find the Test the class LargestDigit
 *  
 * @version1.10 18 Jul 2017
 * @author Pawan Manglani
 *
 */

public class LargestDigitTest {

private static LargestDigit testLargeDigit;
    
	//This method setUpClass will initialize the object 
	@BeforeClass
	public static void setUpClass() {
		testLargeDigit = new LargestDigit();
	}

	//This method will test the cases when input number is greater than zero
	@Test
	public void test1() {
		int num = 2;
		int expected = 2;
		int actual = testLargeDigit.maxDigit(num);
		assertEquals(expected, actual);
	}
	
	//This method will test the exceptional case when input number is less than zero
	@Test (expected = NumberFormatException.class)
	public void test2() {
		int num = -2;
		 testLargeDigit.maxDigit(num);
	}
	
	//This method test the time limit on large input
	@Test(timeout = 0L)
	public void test3() {
		int num = 123456789;
		int expected = 9;
		int actual = testLargeDigit.maxDigit(num);
		assertEquals(expected, actual);
	}

	@AfterClass
	public static void tearDown() {
		testLargeDigit = null;
	}

}
