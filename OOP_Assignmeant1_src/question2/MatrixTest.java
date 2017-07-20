package question2;

import static org.junit.Assert.*;


import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;



public class MatrixTest {

	/** The testMatrix. object of class Matrix*/
	private static Matrix testMatrix;
	private static Scanner in;


	/**
	 * Sets the up class.
	 */
	@BeforeClass
	public static void setUpClass() {
		in = new Scanner(System.in);
	}
	
	/*
	 * Test 1
	 * This test will check the multiplication of matrix
	 */
	@Test
	public void test1() {
		int row = 3,col = 3,val=0;
		testMatrix = new Matrix(row,col);
		int count = 1;
		for(int row_index = 0 ; row_index<row ; row_index++) {
			for(int col_index = 0 ; col_index<col ; col_index++) {
				val = count;
				testMatrix.addElements(row_index, col_index, val);
				count++;
			}
		}
		count = 1;
		Matrix matrix = new Matrix(3,3);
		for(int row_index = 0 ; row_index<row ; row_index++) {
			for(int col_index = 0 ; col_index<col ; col_index++) {
				val = count;
				matrix.addElements(row_index, col_index, val);
				count++;
			}
		}
		int actual[][] = testMatrix.multiplication(matrix).get();
		int expected[][] = {{30,36,42},{66,81,96},{102,126,150}};
		assertArrayEquals(expected, actual);
	}
  
	
	
	/*
	 * Test 2
	 * This test will check the addElements method beyond the matrix boundary
	 */
	@Test
	public void test2() {
		int row = 2,col = 3,val=0;
		testMatrix = new Matrix(row,col);
		testMatrix.addElements(row, col, val);
			int actual[][]	= testMatrix.get();
			int expected[][] = {{0,0,0},{0,0,0}};
			assertArrayEquals(expected, actual);
	}
	

	/*
	 * Test 3
	 * This test will check the Transpose Method
	 */
	
	@Test
	public void test3() {
		int row = 2,col = 3,val=0;
		testMatrix = new Matrix(row,col);
		int count = 1;
		for(int row_index = 0 ; row_index<row ; row_index++) {
			for(int col_index = 0 ; col_index<col ; col_index++) {
				val = count;
				testMatrix.addElements(row_index, col_index, val);
				count++;
			}
		}
		int actual[][] = testMatrix.transpose().get();
		int expected[][] = {{1,4},{2,5},{3,6}};
			assertArrayEquals(expected, actual);
	}
    

	/**
	 * Tear down.
	 */
	@AfterClass
	public static void tearDown() {
		testMatrix = null;
		in.close();
	}

}
