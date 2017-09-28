package com.metacube.io;

import java.util.Scanner;

/**
 * The Class Input.
 *  @author Pawan Manglani
 *  @version 1.1 12-Sep-2017
 */
public class Input {

	/** The in. object of scanner to read input from console */
	private static Scanner in = new Scanner(System.in);


	/**
	 * Prints the menu.
	 */
	public static void printMenu(){
		System.out.println("\n1.Fetch all the books published by author, given the name of the author. Return the books data (List of Titles).");
		System.out.println("2 Given the name of the book, to be issued by an existing member.Return flag to indicate whether the  the book has been issued or not.");
		System.out.println("3 Delete all those books which were not issued in last 1 year. Return the number of books deleted.");
		System.out.println("4 Exit");
	}

	/**
	 * Take integer as input.
	 *
	 * @param s the string showing the message what has to insert
	 * @param negative the negative
	 * @return the integer input
	 */
	public static int takeIntegerAsInput(String s,boolean negative) {
		boolean flag = true;
		int input = 0;
		String temp = "";
		while (flag) {
			try {
				print("Enter " + s);
				temp = in.nextLine().trim();
				input = Integer.parseInt(temp);
				if(negative && (input<=0)) {
					throw new Exception("Please Enter a Positive value");
				}
				flag = false;
			} catch (Exception e) {
				print("Error while taking input " + e.getMessage());
			}
		}
		return input;
	}

	/**
	 * Take double as input.
	 *
	 * @param s the string showing the message what has to insert
	 * @return the double input
	 */
	public static double takeDoubleAsInput(String s) {
		boolean flag = true;
		double input = 0;
		String temp = "";
		while (flag) {
			try {
				print("Enter " + s);
				temp = in.nextLine().trim();
				input = Double.parseDouble(temp);
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
	 *@param s the string showing the message what has to insert
	 * @return the String input
	 */
	public static String takeStringAsInput(String s) {
		String input = "";
		while(true) {
			try {
				print("Enter "+ s);
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
	 * Prints the String.
	 *
	 * @param s the string which has to be printed
	 */
	public static void print(String s) {
		System.out.println(s);
	}
}
