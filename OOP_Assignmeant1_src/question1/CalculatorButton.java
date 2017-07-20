package question1;

public class CalculatorButton  {

	private String label;
	private String ActionCommand;

	CalculatorButton() {
		//Default Constructor
	}
	CalculatorButton(String label) {
		//Constructor with label
	}
	
	void setLabel(String label) {
		this.label = label;
	}

	
	String getLabel() {
		//getter method to get label of button
		return this.label;
	}
	
	String getActionCommand() {
		//returns the action command
		return ActionCommand;
	}
	
	void setActionCommand(String command) {
		
		//it sets the acction command of Button
	}
	
}
