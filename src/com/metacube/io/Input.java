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
		System.out.println("1 To Enter a String");
		System.out.println("2 to exit");
	}

	/**
	 * Prints the menu for employee.
	 */
	public static void printMenuForEmployee() {
		System.out.println("1 to add an employee");
		System.out.println("2 to print list of employees");
		System.out.println("3 to sort employee on the basis of there names");
		System.out.println("4 to sort employees list on the basis of there Id");
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
	 * Prints the String.
	 *
	 * @param s the string which has to be printed
	 */
	public static void print(String s) {
		System.out.println(s);
	}
}
