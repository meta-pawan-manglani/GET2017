/*
 * @author Pawan Manglani
 * @version 1.1 31-Aug-2017
 */
package com.metacube.main;

import com.metacube.io.Input;
import com.metacube.tree.Tree;

/**
 * The Class Student.
 * This class sort the student in the basis of there roll numbers
 */
public class Student {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		/*make an instance of tree*/
		Tree<Integer> tree = null; 
		/*helper variable*/
		int choice = 0,element = 0,size = 0;
		try {
			while(true) {
				/*printing menu*/
				Input.printMenuForStudent();
				/*taking user choice*/
				choice = Input.takeIntegerAsInput("Choice");
				switch(choice) {
				/*Case to insert an element in tree*/
				case 1:
					size = Input.takeNoneNegativeInput("Enter Size of Array");
					tree = new Tree<>(size);
					for(int index = 0 ; index<size ; index++) {
						element = Input.takeNoneNegativeInput("Roll Number of Student");
						tree.insertData(element);
					}
					break;
					/*Case to print tree*/	
				case 2:
					if(tree!=null) {
						Input.print(tree.toString());
					} else {
						Input.print("Student Database is Empty");
					}
					break;
					/*case of exit*/
				case 3:
					Input.close();
					System.exit(0);
				default :
					Input.print("Please Select a valid menu");
				}
			}
		}catch(Exception e) {
			Input.print(e.getMessage());
		}
	}
}
