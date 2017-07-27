package menuAssignment;

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



	/** The operations Map The Operator To The Desired Class Object */
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
		initiaLizeMap();
		this.operandA = left;
		this.operandB = right;
		this.op = operations.get(choice);
	}

	/**
	 * Initialize map.
	 * 
	 * Map operator to the Desired Class Object 
	 */
	public void initiaLizeMap() {
		operations.put("*",new Multiplication());
		operations.put("+",new Addition());
		operations.put("-",new Subtraction());
		operations.put("/",new Division());
	}

	/**
	 * Perform action.
	 */
	public void performAction() {
		System.out.println(op.resultFor(operandA, operandB));
	}


}

