package menuAssignment;


/**
 * The Class ActionableMenuItem.
 * 
 * This Class Binds Action To Menu
 *
 * @author Pawan Manglani
 * @version 1.1 27-JUL-2017
 */
public class ActionableMenuItem implements MenuItem{

	/** The action. object of Action class */
	Calculator action;

	/** The display text.String  to display text */
	String displayText;

	/**
	 * Instantiates a new actionable menu item.
	 *
	 * @param displayText the display text
	 */
	ActionableMenuItem(String displayText) {
		this.displayText = displayText;
	}

	/*
	 * display text of option of Menu
	 * 
	 */

	public void display() {
		System.out.println(displayText);
	}

	/** 
	 * Takes the choice and performs the action
	 * @param choice The operator use to perform operation
	 * @param operandA First Number
	 * @param operandB Second Number
	 */
	public void takeAction(String choice,double operandA,double operandB) {
		Calculator action = new Calculator(choice,operandA,operandB);
		action.performAction();
	}

	/* 
	 * This Will Give The Menu Option
	 */
	@Override
	public String getText() {
		return this.displayText;
	}

}
