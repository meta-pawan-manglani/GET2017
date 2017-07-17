/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern2;

import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author welcome
 */
public class Pattern2Test1 {
    
     private static Pattern2 testPattern2;
    
    @BeforeClass
    public static void setUp() {
        testPattern2 = new Pattern2();
    }
    /**
     * Test of main method, of class Pattern2.
     */
    @Test
    public void testMain() {
        String[] args = {"5"};
        try {
            Pattern2.main(args);
        } catch (Exception ex) {
            fail("An Exception Occurs");
        }
       
    }
    
    //this test will check when num is less than 0
    @Test(expected = IllegalArgumentException.class)
    public void isExceptionThrown() throws Exception {
        int num = -1;
        testPattern2.driverFunction(num);  
    }
    
    //this test will check the driver function on correct input
    @Test
    public void testDriverFunction() throws Exception{
        int num = 3;
        String actual[] = testPattern2.driverFunction(num);
        String expected[] = {"1 2 3 ",
                             "  1 2 ",
                             "    1 "};
        assertArrayEquals(expected,actual);
    }
    
    
    //this test will check condition when rownum is smaller than num
    @Test(timeout = 0L)
    public void testSpaces(){
        int rownum = 3;
        String actual = testPattern2.printSpaces(rownum);
        String expected = "    ";
        assertEquals("number of spaces should be 2*(rownum - 1)", expected, actual);
    }
    
    
    @AfterClass
    public static void tearDown() {
        testPattern2 = null;
    }
}
