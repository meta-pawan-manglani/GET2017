/**
 * 
 */
package question1;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *  Class description
 * 
 *  This class will find the Test the class FindRem 
 *  
 * @version1.10 18 Jul 2017
 * @author Pawan Manglani
 *
 */
public class FindRemTest {

	private static FindRem testRem;
    
	//This method setUpClass will initialize the object 
	@BeforeClass
	public static void setUpClass() {
		testRem = new FindRem();
	}

	//This method will test the cases when one number is factor of another number 
	@Test
	public void test1() {
		int num = 2,divisor = 1;
		int expected = 0;
		int actual = testRem.getRemainder(num, divisor);
		assertEquals(expected, actual);
	}
	
	//This method will test the exceptional case Divide by zero
	@Test (expected = ArithmeticException.class)
	public void test2() {
		
		int num = 2,divisor = 0;
		 testRem.getRemainder(num, divisor);
	}
	
	//This method test the time limit on large input
	@Test(timeout = 0L)
	public void test3() {
		int num = 100,divisor = 3;
		int expected = 1;
		int actual = testRem.getRemainder(num, divisor);
		assertEquals(expected, actual);
	}

	@AfterClass
	public static void tearDown() {
		testRem = null;
	}
}
