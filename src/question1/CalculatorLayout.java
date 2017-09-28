package question1;

/**
 * The Class CalculatorLayout.
 * @version1.10 20 Jul 2017
 * @author Pawan Manglani
 */
public class CalculatorLayout {

	private int gridLength;
	private int gridBreadth;
	private int positionOccupied[][];
	private CalculatorButton[][] buttons;

	/**
	 * This method is designed to check if a grid cell is already occupied
	 * @param gridRow the row number for the cell under consideration
	 * @param gridColumn the column number for the cell under consideration
	 * @return true if cell is free
	 */
	public boolean isOccupiedPosition(int gridRow, int gridColumn) {
		return false;
		//to check if a grid cell is already occupied
	}

	//getters and setters

	public void setButtonAtPosition(CalculatorButton currentButton, int gridRow, int gridColumn) {	
	}

	public void getButtonAtPosition() {	
	}

	public void setDisplayAtPostion(CalculatorDisplay display,int startRow,int startColumn) {	
	}

	public int getGridBreadth() {
		return gridBreadth;
	}

	public void setGridBreadth() {
	}

	public void setGridLength() {
	}

	public int getGridLength() {
		return gridLength;
	}
}

