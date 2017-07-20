package question2;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *  Class description
 * 
 *  This class will find the Test the class LinearSearch
 *  
 * @version1.10 18 Jul 2017
 * @author Pawan Manglani
 *
 */


public class LinearSearchTest {

private static LinearSearch testLinearSearch;
    
	//This method setUpClass will initialize the object 
	@BeforeClass
	public static void setUpClass() {
		testLinearSearch = new LinearSearch();
	}

	//This method will test the case when number is not present in array
	@Test
	public void test1() throws Exception{
		try {
		int numbers[] = {2,5,8,9,10, 77, 55};
		int num = 88;
		int actual = testLinearSearch.driverFunction(num,numbers); 
		int expected = -1;
		assertEquals(expected, actual);
		}catch(Exception e) {
			fail("Invalid Arguments");
		}
	}
	
	//This method will test the exceptional case when a null array is passed
	@Test  
	public void test2() throws Exception{
		int numbers[] = {};
		int num = 45;
		 testLinearSearch.driverFunction(num,numbers);
	}
	
	//This method test when the number is present in array
	@Test(timeout = 0L)
	public void test3() throws Exception{
		try {
		int numbers[] = {87,5334,88,9,10, 77, 55};
		int num = 77;
		int actual = testLinearSearch.driverFunction(num,numbers); 
		int expected = 5;
		assertEquals(expected, actual);
		}catch(Exception e) {
			fail("Invalid Arguments");
		}
	}

	@AfterClass
	public static void tearDown() {
		testLinearSearch = null;
	}

}
