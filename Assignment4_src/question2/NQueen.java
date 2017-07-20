package question2;

public class NQueen {
	private int SIZE = 0;

	/*
	 * This function check if a queen can be placed on board[row][col].
	 * note that this function is called when "col" queens are already placeed
	 * in columns from 0 to col -1. So we need to check only left side for
	 * attacking queens
	 */
	private boolean isSafe(boolean board[][], int row, int col) {
		int row_index, col_index;

		/* Check this row on left side */
		for (col_index = 0; col_index < col; col_index++)
			if (board[row][col_index])
				return false;

		/* Check upper diagonal on left side */
		for (row_index = row, col_index = col; row_index >= 0 && col_index >= 0; row_index--, col_index--)
			if (board[row_index][col_index])
				return false;

		/* Check lower diagonal on left side */
		for (row_index = row, col_index = col; col_index >= 0 && row_index < SIZE; row_index++, col_index--)
			if (board[row_index][col_index])
				return false;

		return true;
	}

	/*
	 * A recursive function to solve n Queen problem
	 */
	private boolean solveNQ(boolean board[][], int col) {
		/*
		 * base case: If all queens are placed then return true
		 */
		if (col >= SIZE) {
			return true;
		}
		/*
		 * Consider this column and try placing this queen in all rows one by
		 * one
		 */
		for (int index = 0; index < SIZE; index++) {
			/*
			 * Check if queen can be placed on board[index][col]
			 */
			if (isSafe(board, index, col)) {
				/* Place this queen in board[index][col] */
				board[index][col] = true;

				/* recur to place rest of the queens */
				if (solveNQ(board, col + 1) == true)
					return true;

				/*
				 * If placing queen in board[index][col] doesn't lead to a solution
				 * then remove queen from board[index][col]
				 */
				board[index][col] = false; // BACKTRACK
			}
		}

		/*
		 * If queen can not be place in any row in this colum, then return
		 * false
		 */
		return false;
	}

	/*
	 * This function solves the N Queen problem using Backtracking. It mainly
	 * uses solveNQ() to solve the problem. It returns false if queens
	 * cannot be placed, otherwise return true and prints placement of queens in
	 * the form of true ,false.
	 */
	public boolean[][] nQueen(int n) {
		boolean board[][];
		try {
			if(n<0) {
				throw new NegativeArraySizeException();
			}
			SIZE = n;
			 board = new boolean[SIZE][SIZE];
			
			

			if (solveNQ(board, 0) == false) {
				System.out.println("Solution does not exist");
			}
			else {
				for (int row = 0; row < SIZE; row++) {
					for (int column = 0; column < SIZE; column++) {
						System.out.print(" " + board[row][column] + " ");
					}
					System.out.println();
				}
			}
		}catch(NegativeArraySizeException e) {
			System.out.println("Negative Value");
			board = new boolean[0][0];
		}
		return board;
	}

	// driver program to test above function
	public static void main(String args[]) {
		NQueen Queen = new NQueen();
		int n = 4;
		Queen.SIZE = n;
		boolean result[][] = Queen.nQueen(n);

	}
}
