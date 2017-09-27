package question1;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

/**Class description
 * 
 * The Class CalculatorDisplay makes the display of class.
 * 
 * @version1.10 20 Jul 2017
 * @author Pawan Manglani
 */
public class CalculatorDisplay{

	private int displayLength;
	private int displayWidth;
	private String displayBuffer;
	
	//setters
	public void setDisplayLength(int noOfGridBlocks) {	
	}
	
	public void setDisplayWidth(int noOfGridBlocks) {	
	}
	
	//getters
	public int getDisplayWidth() {
		return displayWidth;
	}
	
	public int getDisplayLength() {
		return displayLength;
	}
	
	/**
	 * pass the string to display buffer and print to display
	 * @param expression the string to be sent to display
	 */
	public void printToDisplay(String expression) {
		// pass the string to display buffer and print to display
	}
	
	/**
	 * to clear display buffer
	 */
	public void clearDisplay() {
		// to clear the display buffer
	}
}
