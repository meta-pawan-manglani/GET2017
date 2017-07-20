package question2;

import static org.junit.Assert.*;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Class description
 * 
 *  This class will test the class NQueen.
 *
 * @author Pawan Manglani
 * @version1.10 19 Jul 2017
 */


public class NQueenTest {

	/** The testQueen. object of class NQueen*/
	private static NQueen testQueen;


	/**
	 * Sets the up class.
	 */
	@BeforeClass
	public static void setUpClass() {
		testQueen = new NQueen();
	}

	/**
	 * Test 1.
	 * This will test when n is 3
	 */
	@Test
	public void test1() {
		int n = 3;
		boolean[][] actual = testQueen.nQueen(n);
		boolean[][] expected= {{false,false,false},{false,false,false},{false,false,false}};

		assertArrayEquals(expected, actual);
	}

	/**
	 * Test 2.
	 * This will test when n is 4
	 */
	@Test
	public void test2() {
		int n = 4;
		boolean[][] actual = testQueen.nQueen(n);
		boolean[][] expected= {{false ,false ,true ,false },
								{true ,false ,false ,false },
								{false ,false ,false ,true },
								{false ,true ,false ,false}};

		assertArrayEquals(expected, actual);
	}


	/**
	 * Tear down.
	 */
	@AfterClass
	public static void tearDown() {
		testQueen = null;
	}

}
