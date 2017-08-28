package io;

import java.util.Scanner;


/**
 * The Class Input.
 * @author Pawan Manglani
 * @version 1.1 25-Aug-2017
 */
public class Input {

	/** The in. */
	private static Scanner in = new Scanner(System.in);


	/**
	 * Prints the menu for list
	 */
	public static void printMenuForList(){
		System.out.println("1 To Add an Item into List");
		System.out.println("2 print the list");
		System.out.println("3 to exit");
	}
	
	/**
	 * Prints the menu for queue
	 */
	public static void printMenuForQueue() {
		System.out.println("1 To Add an Item into Queue");
		System.out.println("2 Print the Queue");
		System.out.println("3 Delete an item from Queue");
		System.out.println("4 Clear the Queue");
		System.out.println("5 to exit");
	}

	/**
	 * Take integer as input.
	 *
	 * @return the int
	 */
	public static int takeIntegerAsInput() {
		boolean flag = true;
		int input = 0;
		String temp = "";
		print("Enter Input");
		while (flag) {
			try {
				temp = in.nextLine().trim();
				input = Integer.parseInt(temp);
				flag = false;
			} catch (Exception e) {
				print("Please Enter a valid Element");
			}
		}
		return input;
	}

	/**
	 * Take String as input.
	 *
	 * @return the String
	 */
	public static String takeStringAsInput() {
		String input = "";
		print("Enter Input");
		while(true) {
			try {
				input = in.nextLine().trim();
				if(input.length()==0){
					throw new Exception("Blank Input");
				}
				break;
			} catch(Exception e) {
				print("Cannnot Accept a Blank Input");
			}
		}

		return input;
	}
	
	/**
	 * Closing the input stream.
	 */
	public static void close(){
		in.close();
	}

	/**
	 * Prints the String
	 *
	 * @param s the string which has to be printed
	 */
	public static void print(String s) {
		System.out.println(s);
	}
}
