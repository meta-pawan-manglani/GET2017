package menuAssignment;


/**
 * The Class Multiplication
 * 
 * This class Multiply operanA to operandB.
 *
 * @author Pawan Manglani
 * @version 1.1 27-JUL-2017
 */
public class Multiplication implements Operation{

	/* Override Method
	 * 
	 * Perform Multiplication Operation on Two Numbers
	 */
	@Override
	public double resultFor(double operandA,double operandB) {	
		return operandA*operandB;
	}

}
