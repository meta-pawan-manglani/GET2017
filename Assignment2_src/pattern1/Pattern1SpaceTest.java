/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern1;

import static org.junit.Assert.*;
import org.junit.*;


/**
 *
 * @author welcome
 */

public class Pattern1SpaceTest {
    
    private static Pattern1 testPattern1;
    
    @BeforeClass
    public static void setUp() {
        testPattern1 = new Pattern1();
    }
   
    /**
     * Test of main method, of class Pattern1.
     */
    @Test
    public void testMain() {
        String[] args = {"5"};
        try {
            Pattern1.main(args);
        } catch (Exception ex) {
            fail("An Exception Occurs");
        }
       
    }
    
    //this test will check when num is less than 0
    @Test(expected = IllegalArgumentException.class)
    public void isExceptionThrown() throws Exception {
        int num = -1;
        testPattern1.driverFunction(num);
        
    }
    
    //this test will check the driver function on correct input
    public void testDriverFunction() throws Exception{
        int num = 3;
        String actual[] = testPattern1.driverFunction(num);
        String expected[] = {"    1 ",
                            "   1 2 1 ",
                            " 1 2 3 2 1 ",
                            "   1 2 1 ",
                            "     1 "};
        assertArrayEquals( expected, actual);
    }
    
    //this test will check condition when rownum is smaller than num
    @Test(timeout = 0L)
    public void testSpaces1(){
        int rownum = 6,num = 10;
        String actual = testPattern1.printSpaces(rownum, num);
        String expected = "         ";
        assertEquals("number of spaces should be 2*(difference) + 1", expected, actual);
    }
    
    //this test will check condition when rownum is greater than num
    @Test
    public void testSpaces2(){
        int rownum = 6,num = 5;
        String actual = testPattern1.printSpaces(rownum, num);
        String expected = "   ";
        assertEquals("number of spaces should be 2*(difference) + 1", expected, actual);
    }
    
    //this test will check the method when num and rownum are equal
    @Test
    public void testSpaces3(){
        int rownum = 3,num = 3;
        String actual = testPattern1.printSpaces(rownum, num);
        String expected = " ";
        assertEquals("number of spaces should be 2*(difference) + 1", expected, actual);
    }
    
    
     @AfterClass
    public static void tearDown() {
        testPattern1 = null;
    }
    
}
