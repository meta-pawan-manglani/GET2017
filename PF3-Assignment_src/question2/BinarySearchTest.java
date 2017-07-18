package question2;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *  Class description
 * 
 *  This class will find the Test the class BinarySearch
 *  
 * @version1.10 18 Jul 2017
 * @author Pawan Manglani
 *
 */

public class BinarySearchTest {

private static BinarySearch testBinarySearch;
    
	//This method setUpClass will initialize the object 
	@BeforeClass
	public static void setUpClass() {
		testBinarySearch = new BinarySearch();
	}

	//This method will test the case when number is not present in array
	@Test
	public void test1() throws Exception{
		try {
		int numbers[] = {2,5,8,9,10, 77, 55};
		int start = 0,last = numbers.length-1,num = 88;
		int actual = testBinarySearch.binarySearch(numbers, start, last, num); 
		int expected = -1;
		assertEquals(expected, actual);
		}catch(Exception e) {
			fail("Invalid Arguments");
		}
	}
	
	//This method will test the exceptional case when a null array is passed
	@Test (expected = IllegalArgumentException.class) 
	public void test2() throws Exception{
		int numbers[] = {};
		int start = 0,last = numbers.length-1,num = 45;
		 testBinarySearch.binarySearch(numbers, start, last, num);
	}
	
	//This method test when the number is present in array
	@Test(timeout = 0L)
	public void test3() throws Exception{
		try {
		int numbers[] = {2,5,8,9,10, 77, 55};
		int start = 0,last = numbers.length-1,num = 77;
		int actual = testBinarySearch.binarySearch(numbers, start, last, num); 
		int expected = 5;
		assertEquals(expected, actual);
		}catch(Exception e) {
			fail("Invalid Arguments");
		}
	}

	@AfterClass
	public static void tearDown() {
		testBinarySearch = null;
	}

}
