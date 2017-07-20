package question1;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Class description
 * 
 *  This class will test the class FindGcd class
 * 
 * @version1.10 18 Jul 2017
 * @author Pawan Manglani
 */

public class FindGcdTest {

	//This method setUpClass will initialize the object 
	private static FindGcd testGcd;
		@BeforeClass
		public static void setUpClass() {
			testGcd = new FindGcd();
		}

		//This method will test the cases when one number is factor of another number 
		@Test
		public void test1() {
			int number1 = 2,number2 = 1;
			int expected = 1;
			int actual = testGcd.getGCD(number1, number2);
			assertEquals(expected, actual);
		}
		
		//This method will test basic case
		@Test
		public void test2() {
			int number1 = 12,number2 = 18;
			int actual =  testGcd.getGCD(number1, number2);
			int expected = 6;
			assertEquals(expected,actual);
		}
		
		//This method test the time limit on large input
		@Test(timeout = 0L)
		public void test3() {
			int number1 = 100,number2 = 3;
			int expected = 1;
			int actual = testGcd.getGCD(number1, number2);
			assertEquals(expected, actual);
		}
	
	@AfterClass
	public static void tearDown() {
		testGcd = null;
	}

}
