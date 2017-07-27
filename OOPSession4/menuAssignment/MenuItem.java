
package menuAssignment;


/**
 * The Interface MenuItem.
 *
 * @author Pawan Manglani
 * @version 1.1 27-JUL-2017
 */
public interface MenuItem {

	/**
	 * Gets the text.
	 *
	 * @return the text type of string
	 */
	public String getText();

	/**
	 * Display.
	 */
	public void display();

	/**
	 * Take action.
	 *
	 * @param choice the operator
	 * @param left the left operand
	 * @param right the right operand
	 */
	public void takeAction(String choice,double left,double right);

}
