/*
 * @author Pawan Manglani
 * @version 1.1 29-Aug-2017
 */
package com.metacube.controller;

import com.metacube.io.Input;
import com.metacube.tree.Tree;



/**
 * The Class Controller.
 * This class performs binary search over binary search tree
 */
public class Controller {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		/*make an instance of tree*/
		Tree<Integer> tree = new Tree<>();
		/*helper variable*/
		int choice = 0,element = 0;
		while(true) {
			/*printing menu*/
			Input.printMenu();
			/*taking user choice*/
			choice = Input.takeIntegerAsInput("Choice");
			switch(choice) {
			/*Case to insert an element in tree*/
			case 1:
				element = Input.takeIntegerAsInput("Element to insert");
				tree.insertData(element);
				break;
				/*Case to print tree*/	
			case 2:
				Input.print(tree.toString());
				break;
				/*case to search an element in tree*/
			case 3:
				element = Input.takeIntegerAsInput("Element to search");
				Input.print(Integer.toString(tree.search(element)));
				break;
				/*case to exit*/
			case 4:
				Input.close();
				System.exit(0);
			default :
				Input.print("Please Select a valid menu");
			}
		}

	}
}
