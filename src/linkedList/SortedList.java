package linkedList;

import io.Input;

import java.util.LinkedList;
import java.util.List;

/**
 * The Class SortedList.
 * This class put the value in sorted order in linked list
 * @author Pawan Manglani
 * @version 1.1 27-Aug-2017
 */
public class SortedList {


	/** The sorted list. */
	private static List<Integer> sortedList = new LinkedList<>();

	/** The position. */
	private static int position = 0;

	/**
	 * Gets the position.
	 * This method return the position where the data can be inserted
	 * @param data the data
	 * @return the position
	 */
	private static void getPosition(int data){

		/*If position is less than the size of List*/
		if(position<sortedList.size()) {

			/**Determining the order by 
			 * comparing the value stored at position 
			 * to the data which has to be inserted
			 */
			int compare = sortedList.get(position).compareTo(data);

			/**
			 * If the value stored at position is lesser than the value to be inserted
			 * 
			 */
			if(compare<=-1){
				/**
				 * Increment the position
				 */
				position++;
				/**
				 * Again call the data to be inserted
				 */
				getPosition(data);
			}
		}

	}

	/**
	 * Adds the.
	 * This method add the specified data in list
	 * @param data the data
	 */
	private static void add(int data){

		/**
		 * Calling the getPosition Method
		 */
		getPosition(data);
		/**
		 * If position is less than the size of the list than add the data to the position
		 */
		if(position<sortedList.size()) {
			sortedList.add(position,data);
		} else {
			/**Else append the data to the end of list*/
			sortedList.add(data);
		}
		position = 0;

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int choice  = 0,data = 0;
		while(true) {
			/**
			 * Printing menu
			 */
			Input.printMenuForList();
			/**
			 * Taking user Choice
			 */
			choice = Input.takeIntegerAsInput();
			switch(choice) {
			/**For adding an element*/
			case 1:
				data = Input.takeIntegerAsInput();
				add(data);
				break;
				/**
				 * For printing the list
				 */
			case 2:
				if(sortedList.isEmpty()) {
					Input.print("List is Empty");
				} else {
					Input.print(sortedList.toString());
				}
				break;
				/**
				 * Inc case of exit
				 */
			case 3:
				Input.close();
				System.exit(0);
			default :
				Input.print("Please Enter a Valid Option");
			}
		}

	}
}
