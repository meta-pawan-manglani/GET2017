package question1;

import java.util.HashMap;

/**
 * The Class Calculator.
 *
 * @author Pawan Manglani
 * @version 1.1 27-JUL-2017
 */
public class Calculator{

	/** The operand A. */
	private double operandA;

	/** The operand B. */
	private double operandB;

	/** The result. */
	private String result;

	
	/** The layout. */
	private CalculatorLayout layout;

	/**  The operations Map The Operator To The Desired Class Object. */
	private HashMap<String,Operation> operations = new HashMap<>();

	/** The op. Type Of Operation*/
	private Operation op;

	/**
	 * Instantiates a new calculator.
	 *
	 * @param choice the operator
	 * @param left the left operand
	 * @param right the right operand
	 */
	Calculator(String choice,double left,double right) {
	}

	/**
	 * Initialize map.
	 * 
	 * Map operator to the Desired Class Object 
	 */
	public void initiaLizeMap() {
	}

	/**
	 * Perform action.
	 * This method set the result of operation
	 */
	public void performAction() {
		/*result = call resultfor method and convert the operation result to its string class*/
	}
	
	/**
	 * Method to call the display utility to print.
	 *
	 * @param expression the string expression to be sent to display
	 * @param display gives the display object to which the string is to be sent
	 */
	public void sendToDisplay(String expression,CalculatorDisplay display) {
		//logic to send an output string to display
   }

	
	/**
	 * Sets the layout.
	 */
	private void setLayout() {
		
	}

}

