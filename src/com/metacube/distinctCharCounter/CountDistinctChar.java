/*
 * @author Pawan Manglani
 * @version 1.1 28-Aug-2017
 */
package com.metacube.distinctCharCounter;

import java.util.HashMap;

import com.metacube.io.Input;

/**
 * The Class CountDistinctChar.
 */
public class CountDistinctChar {

	/** The cache. */
	private static HashMap<String,Integer> cache = new HashMap<>();

	/**
	 * Char counter.
	 * This method counts the unique character in the string
	 *
	 * @param input the input
	 * @return the int
	 */
	private static int charCounter(String input) {
		/*count store the total number of unique character*/
		int count,len;
		/*removing white spaces from string*/
		input = input.replaceAll("\\s+","").toLowerCase();
		len = input.length();
		count = len;
		/*charArray helper to count occurrence of each character*/
		char charArray[] = input.toCharArray();
		/*character c is helper*/
		char c;
		for(int index = 0 ; index < len ; index++) {
			c = charArray[index];
			if (index != input.indexOf(c)) {
				/*if index is not same than decrement the count*/
				count--;
			}
		}
		return count;
	}

	/**
	 * Gets the unique char.
	 * This method return the number of unique character in a string
	 * @param input the input
	 * @return the unique char
	 */
	public static int getUniqueChar(String input) {
		int count = 0;
		try {
			input = input.trim().toLowerCase();
			/*If length of input string is greater than zero*/
			if(input.length()>0) {
				/*If cache already contains the key*/
				if(cache.containsKey(input)) {
					count = cache.get(input);
				} else {
					/*Else count the unique character*/
					count = charCounter(input);
					cache.put(input,count);
				}
			}
		}catch(Exception e) {
			/*In case of exception*/
			System.out.println("Error Caught " + e.getMessage());
		}
		return count;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int choice = 0;
		String input = "";
		while(true) {
			/*Print menu*/
			Input.printMenu();
			/*Take user choice as input*/
			choice = Input.takeIntegerAsInput("choice");
			switch(choice) {
			/*case for adding a new string*/
			case 1:
				input = Input.takeStringAsInput("String");
				Input.print("Number of Distinct Character in String " + input + " = " + getUniqueChar(input));
				break;
				/*In case of exit*/
			case 2:
				Input.close();
				System.exit(0);
				break;
				/*In case for invalid option*/
			default :
				Input.print("Please select a valid option");
			}
		}
	}
}
