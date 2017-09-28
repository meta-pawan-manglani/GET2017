/*
 * @author Pawan Manglani
 * @version 1.1 31-Aug-2017
 */
package com.metacube.main;

import java.util.Arrays;

import com.metacube.controller.ComparisonSort;
import com.metacube.controller.LinearSort;
import com.metacube.controller.Sort;
import com.metacube.io.Input;

/**
 * The Class SortingTechniques.
 */
public class SortingTechniques {

	/**
	 * The main method.
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		/*Helper variable*/
		int choice,size;
		int numbers[] = null;
		/*Make an instance of sort*/
		Sort sort;
		while(true) {
			/*print menu for application*/
			Input.printMenu();
			/*take user choice as input*/
			choice = Input.takeIntegerAsInput("Choice ");
			switch(choice) {
			/*In case of adding an array*/
			case 1:
				size = Input.takeNoneNegativeInput("Size of Array ");
				numbers = new int[size];
				for(int index = 0 ; index<size ; index++) {
					numbers[index] = Input.takeIntegerAsInput("" + (index+1) + " Element ");
				}
				break;
				/*If comparison based sorting is selected*/
			case 2:
				sort = new ComparisonSort();
				sort.sort(numbers);
				Input.print(Arrays.toString(numbers));
				break;
				/*If Linear sorting is selected*/
			case 3:
				sort = new LinearSort();
				sort.sort(numbers);
				Input.print(Arrays.toString(numbers));
				break;
				/*In case of exit*/
			case 4:
				Input.close();
				System.exit(0);
			default :

			}
		}
	}

}
