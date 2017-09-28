package question2;

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
			Input.print(e.getMessage());
			Input.print("exit due to error");
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
			Input.print(e.getMessage());
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
		
		/*making a resultant matrix*/
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
			/*if columns in a is not equal to rows in matrix in b*/
			if(columnsInA != rowsInB) {
				throw new IllegalArgumentException("Matrix can't be Multiplied");
			}
			else{
				/*make a resultant matrix */
				result = new Matrix(rowsInA, columnsInB);

				/*multiplying the matrix*/
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
			Input.print(e.getMessage());
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
		String printer="";
		/*printing the matrix*/
		for (int row_counter = 0; row_counter < row; row_counter++) {
			for (int col_counter = 0; col_counter < col; col_counter++) {
				printer += this.data[row_counter][col_counter] + " ";
			}
			printer+="\n";
		}
		Input.print(printer);
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
		try {
			int row = Input.takeIntegerAsInput("Number of rows of first matrix",false);
			int col = Input.takeIntegerAsInput("Enter number of cols of first matrix",false);
			int val = 0;
			
			/*making an instance of first matrix*/
			Matrix mat1 = new Matrix(row, col);
			
			
			/*taking first matrix as input*/
			for (int row_index = 0; row_index < row; row_index++) {
				for (int col_index = 0; col_index < col; col_index++) {
					val = Input.takeIntegerAsInput("Value",true);
					mat1.addElements(row_index, col_index, val);
				}
			}
			int row2 = Input.takeIntegerAsInput("Number of rows of second matrix",false);
			int col2 = Input.takeIntegerAsInput("Enter number of cols of second matrix",false);
			
			/*making instance of second matrix*/
			Matrix mat2 = new Matrix(row2,col2);
			
			/*taking second matrix as input*/
			for (int row_index = 0; row_index < row2; row_index++) {
				for (int col_index = 0; col_index < col2; col_index++) {
					val = Input.takeIntegerAsInput("Value",true);
					mat2.addElements(row_index, col_index, val);
				}
			}
			
			Input.print("\n");
			/************* Printing Matrix *****/
			Input.print("1st Matrix\n");
			mat1.show();
			Input.print("\n");
			Input.print("2nd Matrix");
			mat2.show();
			
			/*printing transpose of matrix 1*/
			mat1 = mat1.transpose();
			Input.print("Transpose of matrix 1");
			mat1.show();
			
			/*printing transpose of matrix 2*/
			mat2 = mat2.transpose();
			Input.print("Transpose of matrix 2");
			mat2.show();
			
			/*multiplying the matrix*/
			mat1 = mat1.multiplication(mat2);
			/************* printing Multiplication of Matrix ***********/
			Input.print("Matrix after multiplication is ");
			mat1.show();
			
			
			/************* printing Transpose of Matrix ***********/
			

		} catch (Exception e) {
			Input.print(e.getMessage());
		} finally {
			Input.close();
		}
	}

}
