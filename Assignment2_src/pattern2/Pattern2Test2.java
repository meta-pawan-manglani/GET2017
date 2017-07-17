package pattern2;

import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author welcome
 */
public class Pattern2Test2 {
    
    private static Pattern2 testPattern2;
    
    @BeforeClass
    public static void setUp() {
        testPattern2 = new Pattern2();
    }

    /**
     * Test of printSpaces method, of class Pattern2.
     */
    @Test
    public void testPrintSpaces() {
        int rownum = 5;
        String expected = "        ";
        String actual = testPattern2.printSpaces(rownum);
        assertEquals(expected, actual);
    }

    /**
     * Test of printNumber method, of class Pattern2.
     */
    @Test
    public void testPrintNumber() {
        int rownum = 2;
        int num = 3;
        String expected = "1 2 ";
        String actual = testPattern2.printNumber(rownum, num);
        assertEquals(expected, actual);
    }

    /**
     * Test of driverFunction method, of class Pattern2.
     */
    @Test
    public void testDriverFunction() throws Exception {
        int num = 0;
        String[] expected = {};
        String[] actual = testPattern2.driverFunction(num);
        assertArrayEquals(expected, actual);
    }
    
    @AfterClass
    public static void tearDown() {
        testPattern2 = null;
    }
}
