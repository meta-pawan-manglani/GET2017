package menuAssignment;

/**
 *
 *This class Subtract operanB from operandA
 *
 * @author Pawan Manglani
 * @version 1.1 27-JUL-2017
 */
public class Division implements Operation{

	/* Override Method
	 * 
	 * Perform Division Operation on Two Numbers
	 */
	@Override
	public double resultFor(double operandA,double operandB) {
		return operandA/operandB;
	}

}
