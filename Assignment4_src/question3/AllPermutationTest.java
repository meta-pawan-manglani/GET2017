package question3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Class description
 * 
 *  This class will test the class AllPermutation.
 *
 * @author Pawan Manglani
 * @version1.10 19 Jul 2017
 */


public class AllPermutationTest {

	/** The testPermutation. object of class AllPermutation*/
	private static AllPermutation testPermutation;

	/** The al. object of type list*/
	private static List<String> al;


	/**
	 * Sets the up class.
	 */
	@BeforeClass
	public static void setUpClass() {
		testPermutation = new AllPermutation();
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
	 * This will test on string abc
	 */
	@Test
	public void test1() {
		String input = "abc";
		al = testPermutation.generatePermute(input);
		String actual[] = al.toArray(new String[al.size()]);
		String expected[] = {"[a, b, c]",
				"[a, c, b]",
				"[b, a, c]",
				"[b, c, a]",
				"[c, a, b]",
		"[c, b, a]"};
		assertArrayEquals(expected, actual);
	}

	/**
	 * Test 2.
	 * This will test when an empty string is provided
	 */
	@Test
	public void test2() {
		String input = "";
		al = testPermutation.generatePermute(input);
		String actual[] = al.toArray(new String[al.size()]);
		String expected[] = {"Invalid Argument Empty String"};
		assertArrayEquals(expected, actual);
	}


	/**
	 * Test 3.
	 * This will test when null is provided as input
	 */
	@Test
	public void test3() {
		String input = null;
		al = testPermutation.generatePermute(input);
		String actual[] = al.toArray(new String[al.size()]);
		String expected[] = {"Null Pointer Exception Occur"};
		assertArrayEquals(expected, actual);
	}


	/**
	 * Tear down.
	 */
	@AfterClass
	public static void tearDown() {
		testPermutation = null;
	}

}
