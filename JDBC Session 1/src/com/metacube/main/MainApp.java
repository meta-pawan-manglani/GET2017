package com.metacube.main;

import com.metacube.controller.Controller;
import com.metacube.io.Input;

/**
 * The Class MainApp.
 * 
 *  @author Pawan Manglani
 *  @version 1.1 12-Sep-2017
 */
public class MainApp {

	/**
	 * The main method.
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int choice = 0,years = 0;
		String authorName = "",bookName="";
		/*making an object of controller class*/
		Controller controller = new Controller();
		while(true) {
			/*printing the menu*/
			Input.printMenu();	
			/*take integer input*/
			choice = Input.takeIntegerAsInput("Choice ",false);	
			switch(choice) {
			/*case 1 to fetch the books written by an author*/
			case 1:
				authorName = Input.takeStringAsInput("Author Name");
				Input.print(controller.getAuthorDetails(authorName));
				break;
				/*case 2 to check status of a book weather it is available or not*/	
			case 2:
				bookName = Input.takeStringAsInput("Book Name");
				Input.print(controller.isAvailable(bookName));
				break;
				/*case 3 to delete all books which are not issued from a specific time*/
			case 3:
				years = Input.takeIntegerAsInput("Number of Year", true);
				Input.print(controller.deleteBooks(years));
				break;
				/*In case of exit*/
			case 4:
				controller.close();
				Input.close();
				System.exit(0);
			default:
				Input.print("Please Enter a valid option");
			}
		}
	}
}


