package menuAssignment;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

/**
 * The Class Menu.
 * 
 * This Class Shows Menu of the Application 
 * Through The Help of This class User will Interact With The Application
 *
 * @author Pawan Manglani
 * @version 1.1 27-JUL-2017
 */
public class Menu {

	/** The items List of Menu Items */
	List<MenuItem> items = new ArrayList<>();

	/** The scan Responsible To Take Input From Console */
	private Scanner scan  = new Scanner(System.in);

	/** The item map.  use to map the command to the object*/
	HashMap<String,MenuItem> itemMap = new HashMap<>();

	/** The exit. used as a EXIT command from application*/
	public String EXIT= "E";


	/*
	 *Adds elements to list
	 * 
	 * @param item
	 */
	public void addMenuItem(MenuItem item)
	{
		String commandArray[] = item.getText().split(" ");
		itemMap.put(commandArray[1],item);
		items.add(item);
	}

	/*
	 * Display the menu item and take input from user
	 * 
	 */
	public void display()
	{
		MenuItem i;
		boolean flag = true;

		/***Operand To perform any Binary Operation**/
		double operandA = 0,operandB = 0;
		while (true) 
		{

			flag = true;
			System.out.println("Enter number");
			do {
				try {
					/**Take First Number as input**/
					operandA = Double.parseDouble(scan.next());
					flag = false;
				}catch(InputMismatchException | NumberFormatException  e) {
					/**If the Number is not valid then a Warning is Shown to user**/
					System.out.println("Enter a valid Number");
				}
			}while(flag);

			// For Printing the Menu
			for ( MenuItem i1 : items) 
			{
				i1.display();
			}

			flag = true;
			/**choice It store the operation Which Have To Be Performed On Numbers**/
			String choice= "";

			System.out.println("Enter operator");

			/**This loop Take The Choice As Input From User**/
			do {
				try {
					choice = scan.next().trim();

					/**This Condition Check If User Wish To Exit **/
					if(EXIT.equalsIgnoreCase(choice)) {
						System.exit(0);
					}else if(!itemMap.containsKey(choice)) {
						/*If The Choice Is Not in Menu**/
						throw new InputMismatchException("Enter valid operator");
					}
					flag = false;
				}catch(InputMismatchException e) {
					/**In Case Of Wrong Choice This Message Will Shown To User**/
					System.out.println(e.getMessage());
				}
			}while(flag);		


			flag = true;
			System.out.println("Enter number");


			do {
				try {
					/**Take Second Number as input**/
					operandB = Double.parseDouble(scan.next());
					flag = false;
				}catch(InputMismatchException | NumberFormatException  e) {
					/**If the Number is not valid then a Warning is Shown to user**/
					System.out.println("Enter a valid Number");
				}
			}while(flag);

			/**Object is Invoked According To The Choice Select By User**/
			i = itemMap.get(choice);

			/**Desired Action Is Performed**/
			i.takeAction(choice,operandA,operandB);
		}
	}


}
