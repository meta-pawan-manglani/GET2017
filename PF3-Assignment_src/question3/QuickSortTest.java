package question3;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *  Class description
 * 
 *  This class will find the Test the class QuickSort
 *  
 * @version1.10 18 Jul 2017
 * @author Pawan Manglani
 *
 */

public class QuickSortTest {

private static QuickSort testQuickSort;
    
	//This method setUpClass will initialize the object 
	@BeforeClass
	public static void setUpClass() {
		testQuickSort = new QuickSort();
	}

	//This method will test the case when array is not sorted
	@Test
	public void test1() throws Exception{
		try {
		int numbers[] = {2,5,8,9,10, 77, 55, 11};
		int actual[] = testQuickSort.driverFunction(numbers); 
		int expected[] = {2,5,8,9,10, 11, 55, 77};
		assertArrayEquals(expected, actual);
		}catch(Exception e) {
			fail("Invalid Arguments");
		}
	}
	
	//This method will test the exceptional case when a null array is passed
	@Test  
	public void test2() throws Exception{
		int numbers[] = {};
		int actual[] =  testQuickSort.driverFunction(numbers);
		int expected[] = {};
		assertArrayEquals(expected,actual);
	}
	
	//This method test when the array is sorted in descending order
	@Test(timeout = 0L)
	public void test3() throws Exception{
		try {
		int numbers[] = {5,4,3,2,1};
		int actual[] = testQuickSort.driverFunction(numbers); 
		int expected[] = {1,2,3,4,5};
		assertArrayEquals(expected, actual);
		}catch(Exception e) {
			fail("Invalid Arguments");
		}
	}

	@AfterClass
	public static void tearDown() {
		testQuickSort = null;
	}

}
