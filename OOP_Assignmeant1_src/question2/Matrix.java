package question2;

import java.util.Scanner;


/**
 * The Class Matrix.
 */
public class Matrix {

	/** The data. */
	private int data[][];

	/** The no rows is the no of rows in matrix. */
	private int noRows;

	/** The no cols the no of columns in matrix. */
	private int noCols;


	/**
	 * Instantiates a new matrix.
	 *
	 * @param row the no of row
	 * @param col the columns of
	 */
	public Matrix(int row, int col) {
		try {
			if (row < 0 || col < 0) {
				throw new NegativeArraySizeException(
						"Size of Matrix should be greater than zero");
			}
			noRows = row;
			noCols = col;
			data = new int[noRows][noCols];
		} catch (NegativeArraySizeException e) {
			System.out.println(e.getMessage());
			System.out.println("exit due to error");
			System.exit(0);
		}
	}

	/**
	 * Adds the elements.
	 *
	 * @param row the no of rows
	 * @param col the no of columns
	 * @param val the value to be enter
	 */
	public void addElements(int row, int col, int val) {
		try {
			if (col >= noCols || row >= noRows || col < 0 || row < 0) {
				throw new ArrayIndexOutOfBoundsException("matrix is of size ("
						+ noRows + ", " + noCols
						+ "), but tries to set element(" + (row + 1) + ", "
						+ (col + 1) + ")");
			}
			data[row][col] = val;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Transpose.
	 *
	 * @return the object of class Matrix
	 * 
	 * This method is used to transpose a matrix
	 */
	public Matrix transpose() {
		int row = this.noRows;
		int col = this.noCols;
		Matrix trans = new Matrix(col, row);
		for (int row_counter = 0; row_counter < col; row_counter++) {
			for (int col_counter = 0; col_counter < row; col_counter++) {
				trans.data[row_counter][col_counter] = data[col_counter][row_counter];
			}
		}
		return trans;
	}

	/**
	 * Multiplication.
	 *
	 * @param matrix2 is object of class Matrix
	 * @return the object of class Matrix
	 * 
	 * This method will perform multiply both object of class Matrix;
	 */
	public Matrix multiplication(Matrix matrix2) {
		int rowsInA = this.noRows;
		int columnsInA = this.noCols;
		int columnsInB = matrix2.noCols;
		int rowsInB = matrix2.noRows;
		Matrix result;
		try {
			if(columnsInA != rowsInB) {
				throw new IllegalArgumentException("Matrix can't be Multiplied");
			}
			else{
				result = new Matrix(rowsInA, columnsInB);

				for (int row_counter = 0; row_counter < rowsInA; row_counter++) {
					for (int col_counter = 0; col_counter < columnsInB; col_counter++) {
						for (int temp = 0; temp < columnsInA; temp++) {
							result.data[row_counter][col_counter] = result.data[row_counter][col_counter]
									+ this.data[row_counter][temp]
											* matrix2.data[temp][col_counter];
						}
					}
				}
			}
		}catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			result = this;
		}
		return result;
	}

	/**
	 * Show.
	 * This method is use to show the matrix
	 */
	public void show() {

		int row = this.noRows;
		int col = this.noCols;
		for (int row_counter = 0; row_counter < row; row_counter++) {
			for (int col_counter = 0; col_counter < col; col_counter++) {
				System.out.print(this.data[row_counter][col_counter] + " ");
			}
			System.out.println();
		}

	}

	/**
	 * Gets the.
	 *
	 * @return the 2-dimensional array of integer type
	 */
	public int[][] get() {
		return this.data;
	}

	/**
	 * The main method.
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		try {

			int row = in.nextInt();
			int col = in.nextInt();
			int val = 0;
			Matrix mat1 = new Matrix(row, col);
			
			for (int row_index = 0; row_index < row; row_index++) {
				for (int col_index = 0; col_index < col; col_index++) {
					val = in.nextInt();
					mat1.addElements(row_index, col_index, val);
				}
			}
			int row2 = in.nextInt();
			int col2 = in.nextInt();
			Matrix mat2 = new Matrix(row2,col2);
			for (int row_index = 0; row_index < row2; row_index++) {
				for (int col_index = 0; col_index < col2; col_index++) {
					val = in.nextInt();
					mat2.addElements(row_index, col_index, val);
				}
			}
			System.out.println();
			/************* Printing Matrix *****/
			System.out.println("1st Matrix");
			mat1.show();
			System.out.println();
			System.out.println("2nd Matrix");
			mat2.show();
			
			/************* printing Transpose of Matrix ***********/
			//mat1 = mat1.transpose();
			//mat1.show();

			mat1 = mat1.multiplication(mat2);
			/************* printing Multiplication of Matrix ***********/
			mat1.show();

		} catch (Exception e) {

		} finally {
			in.close();
		}
	}

}
