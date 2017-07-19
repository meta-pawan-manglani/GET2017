package question1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Class description
 * 
 *  This class will test the class TowerOfHanoi.
 *
 * @author Pawan Manglani
 * @version1.10 19 Jul 2017
 */


public class TowerOfHanoiTest {

	/** The testHanoi. object of class TowerOfHanoi*/
	private static TowerOfHanoi testHanoi;

	/** The al. object of type list*/
	private static List<String> al;


	/**
	 * Sets the up class.
	 */
	@BeforeClass
	public static void setUpClass() {
		testHanoi = new TowerOfHanoi();
		al = new ArrayList<>();
	}

	/**
	 * Run before test method.
	 */
	@Before
	public void runBeforeTestMethod() {
		al.clear();
	}

	/**
	 * Test 1.
	 * This will test when disk_count is 0
	 */
	@Test
	public void test1() {
		int disk_count = 3;
		String source="A",destination = "B",auxiliary = "C";
		al = testHanoi.solveHanoi(disk_count, source, destination, auxiliary);
		String[] actual = al.toArray(new String[al.size()]);
		String[] expected = {"Move Disk 3 from A to B",
				"Move Disk 2 from A to C",
				"Move Disk 3 from B to C",
				"Move Disk 1 from A to B",
				"Move Disk 3 from C to A",
				"Move Disk 2 from C to B",
		"Move Disk 3 from A to B"};

		assertArrayEquals(expected, actual);
	}

	/**
	 * Test 2.
	 * This will test when disk_count is 0
	 */
	@Test
	public void test2() {
		int disk_count = 0;
		String source="A",destination = "B",auxiliary = "C";
		List<String> al = testHanoi.solveHanoi(disk_count, source, destination, auxiliary);
		String[] actual = al.toArray(new String[al.size()]);
		String[] expected = {"Number of disk should not be less than 1"};
		assertArrayEquals(expected, actual);
	}


	/**
	 * Test 3.
	 * This will test when disk_count is 1
	 */
	@Test
	public void test3() {
		int disk_count = 1;
		String source="A",destination = "B",auxiliary = "C";
		List<String> al = testHanoi.solveHanoi(disk_count, source, destination, auxiliary);
		String[] actual = al.toArray(new String[al.size()]);
		System.out.println(Arrays.toString(actual));
		String[] expected = {"Move Disk 1 from A to B"};
		assertArrayEquals(expected, actual);
	}


	/**
	 * Tear down.
	 */
	@AfterClass
	public static void tearDown() {
		testHanoi = null;
	}


}
