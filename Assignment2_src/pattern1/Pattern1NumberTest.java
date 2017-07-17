
package pattern1;

import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author Pawan Manglani
 */
public class Pattern1NumberTest {
    
    private static Pattern1 testPattern1;
    
    @BeforeClass
    public static void setUpClass() {
        testPattern1 = new Pattern1();
    }

    /**
     * Test of printNumber method, of class Pattern1.
     */
    
    //this test will check the method when rownum is less than number
    @Test
    public void testNumber1() {
        int rownum = 3,num = 5;
        String expected = "1 2 3 2 1 ";
        String actual = testPattern1.printNumber(rownum, num);
        assertEquals(expected, actual);
    }
    
    //this test will check the method when rownum is greater than number
    @Test
    public void testNumber2() {
        int rownum = 6,num = 5;
        String expected = "1 2 3 4 3 2 1 ";
        String actual = testPattern1.printNumber(rownum, num);
        assertEquals(expected, actual);
    }
    
    //this test will check the method when rownum is equal to number
    @Test
    public void testNumber3() {
        int rownum = 9,num = 9;
        String expected = "1 2 3 4 5 6 7 8 9 8 7 6 5 4 3 2 1 ";
        String actual = testPattern1.printNumber(rownum, num);
        assertEquals(expected, actual);
    }
    
    @AfterClass
    public static void tearDown() {
        testPattern1 = null;
    }
}
