package question1;


/**Class description
 * 
 * The Class CalculatorButton. use to provide button to Calculator GUI
 * 
 * @version1.10 20 Jul 2017
 * @author Pawan Manglani
 * 
 */
public class CalculatorButton  {

	/** The label. */
	private String label;
	
	private String buttonType;

	/** The Action command type String*/
	private String ActionCommand;

	/**
	 * Instantiates a new calculator button.
	 */
	CalculatorButton() {
		//Default Constructor
	}
	
	/**
	 * Instantiates a new calculator button.
	 *
	 * @param label the label
	 */
	CalculatorButton(String label) {
		//Constructor with label
	}
	
	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	void setLabel(String label) {
		this.label = label;
	}

	
	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	String getLabel() {
		//getter method to get label of button
		return this.label;
	}
	
	/**
	 * Gets the action command.
	 *
	 * @return the action command
	 */
	String getActionCommand() {
		//returns the action command
		return ActionCommand;
	}
	
	/**
	 * Sets the action command.
	 *
	 * @param command the new action command
	 */
	void setActionCommand(String command) {
		
		//it sets the acction command of Button
	}
	
	/**
	 * @return the buttonType
	 */
	public String getButtonType() {
		return buttonType;
	}

	/**
	 * @param buttonType the buttonType to set
	 */
	public void setButtonType(String buttonType) {
		this.buttonType = buttonType;
	}
	
}
