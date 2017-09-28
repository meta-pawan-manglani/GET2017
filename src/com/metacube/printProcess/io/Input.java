package com.metacube.printProcess.io;

import java.util.Scanner;


/**
 * The Class Input.
 * @author Pawan Manglani
 * @version 1.1 25-Aug-2017
 */
public class Input {
	
	private static Scanner in = new Scanner(System.in);
	
	
	/**
	 * Prints the menu.
	 */
	public static void printMenu(){
		System.out.println("1 to add a task");
		System.out.println("2 to complete all the task");
		System.out.println("3 to exit");
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
		while (flag) {
			try {
				temp = in.nextLine().trim();
				input = Integer.parseInt(temp);
				flag = false;
			} catch (Exception e) {
				System.out.println("Please Enter a valid Element");
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
		input = in.nextLine().trim();
		return input;
	}
	/**
	 * Closing the input stream
	 */
	public static void close(){
		in.close();
	}
}
