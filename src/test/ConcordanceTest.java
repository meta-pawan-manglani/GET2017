package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import concordance.CharacterOccurrence;

/**
 * The Class ConcordanceTest.
 * This class test the Character occurrence class 
 *  @author Pawan Manglani
 *  @version 1.1 27-Aug-2017
 */
public class ConcordanceTest {


	/**
	 * Test1.
	 * This method test the condition when null argument is given
	 */
	@Test(expected = NullPointerException.class)
	public void test1() {
       String[] sar = null;
	  CharacterOccurrence.getOccurence(sar);
	}
	
	/**
	 * Test 2.
	 * This method test when single length argument applied
	 */
	@Test
	public void test2() {
		String sar[] = {"1"};
		String actual = CharacterOccurrence.getOccurence(sar);
		String expected = "1[1] ";
		assertEquals(expected, actual);
	}
	
	/**
	 * Test 3.
	 * This method test on normal input
	 */
	@Test
	public void test3() {
		String sar[] = {"Hello","World"};
		String actual = CharacterOccurrence.getOccurence(sar);
		System.out.println(actual);
		String expected = "H[1] W[6] d[10] e[2] l[3, 4, 9] o[5, 7] r[8] ";
		assertEquals(expected, actual);
	}
	
}
