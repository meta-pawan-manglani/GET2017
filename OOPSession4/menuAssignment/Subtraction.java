
package menuAssignment;


/**
 * The Class Subtraction.
 * 
 * This class Subtract operanB from operandA.
 *
 * @author Pawan Manglani
 * @version 1.1 27-JUL-2017
 */
public class Subtraction implements Operation{


	/* Override Method
	 * 
	 * Perform Subtraction Operation on Two Numbers
	 */
	@Override
	public double resultFor(double operandA,double operandB) {
		return operandA-operandB;
	}

}
