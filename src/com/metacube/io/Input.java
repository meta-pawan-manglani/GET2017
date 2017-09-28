/*
 * @author Pawan Manglani
 *@version 1.1 25-Aug-2017
 */
package com.metacube.io;

import java.util.Scanner;
public class Input {

	/** The in. */
	private static Scanner in = new Scanner(System.in);


	/**
	 * Prints the menu.
	 */
	public static void printMenu(){
		System.out.println("1 To Enter a Element");
		System.out.println("2 To print structure");
		System.out.println("3 To search an element");
		System.out.println("4 to exit");
	}

	/**
	 * Take integer as input.
	 *
	 * @param s the string showing the message what has to insert
	 * @return the int
	 */
	public static int takeIntegerAsInput(String s) {
		boolean flag = true;
		int input = 0;
		String temp = "";
		while (flag) {
			try {
				print("Enter " + s);
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
	 * Take double as input.
	 *
	 * @param s the string showing the message what has to insert
	 * @return the int
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
	 * @return the String
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
