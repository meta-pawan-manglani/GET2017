package menuAssignment;


/**
 * The Class Addition.
 * 
 * This class Add operanB to operandA
 *
 * @author Pawan Manglani
 * @version 1.1 27-JUL-2017
 */
public class Addition implements Operation{

	/* Override Method
	 * 
	 * Perform Addition Operation on Two Numbers
	 */
	@Override
	public double resultFor(double operandA,double operandB) {
		return operandA+operandB;
	}

}
