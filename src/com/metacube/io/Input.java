package com.metacube.io;

import java.util.Scanner;

/**
 * The Class Input.
 * 
 * @author Pawan Manglani
 * @version 1.1 21-Aug-2017
 */
public class Input {
	
	/**
	 * Take element as input.
	 *
	 * @param <T> the generic type
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	public static <T> T takeElementAsInput() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String input = "";
		while (true) {
			try {
				input = (in.next().trim());
				if (input.length() == 0) {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				System.out.println("Blank input not accepted");
			}
		}
		T element = (T) input;
		return element;
	}

	/**
	 * Take integer as input.
	 *
	 * @return the int
	 */
	public static int takeIntegerAsInput() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		int input = 0;
		String temp = "";
		while (flag) {
			try {
				temp = in.next().trim();
				input = Integer.parseInt(temp);
				flag = false;
			} catch (Exception e) {
				System.out.println("Please Enter a valid Element");
			}
		}
		return input;
	}
}
