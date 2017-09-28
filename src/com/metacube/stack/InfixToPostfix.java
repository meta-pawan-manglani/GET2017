package com.metacube.stack;

import java.io.IOException;
import java.util.Scanner;

/**
 * The Class InfixToPostfix.
 * @author Pawan Manglani
 * @version 1.1 22-Aug-2017
 */
public class InfixToPostfix {

	/** The stack. */
	private static DStack<Character> stack = new DStack<>();

	/** The output. */
	private static String output = "";

	/**
	 * Convert to postfix
	 * 
	 * This method convert the infix expression to postfix expression
	 *
	 * @param input the input
	 * @return the string
	 */
	public static String convertToPostfix(String input) {

		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			switch (ch) {
			case '+': 
			case '-':
				gotOperator(ch, 1); 
				break; 
			case '*': 
			case '/':
				gotOperator(ch, 2); 
				break; 
			case '^':
				gotOperator(ch,3);
				break;
			case '(': 
				stack.push(ch);
				break;
			case ')': 
				gotParent(ch); 
				break;
			default: 
				output = output.trim() + ch; 
				break;
			}
		}
		while (!stack.isEmpty()) {
			output = output.trim() + stack.pop();
		}
		return output; 
	}

	/**
	 * Got operator.
	 *
	 * @param opThis the op this
	 * @param prec1 the prec 1
	 */
	public static void gotOperator(char opThis, int prec1) {
		while (!stack.isEmpty()) {
			char opTop = stack.pop();
			if (opTop == '(') {
				stack.push(opTop);
				break;
			}
			else {
				int prec2;
				if (opTop == '+' || opTop == '-')
					prec2 = 1;
				else
					prec2 = 2;
				if (prec2 < prec1) { 
					stack.push(opTop);
					break;
				}
				else
					output = output.trim() + opTop;
			}
		}
		stack.push(opThis);
	}

	/**
	 * Got parent.
	 * This function pop the string when it faces the closing bracket ')'
	 * @param ch the ch
	 */
	public static void gotParent(char ch){ 
		while (!stack.isEmpty()) {
			char chx = stack.pop();
			if (chx == '(') 
				break; 
			else
				output = output.trim() + chx; 
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Enter the String");
		Scanner in = new Scanner(System.in);
		try {
			String input = in.nextLine();
			String output;
			output = convertToPostfix(input); 
			System.out.println("Infix Expression---------> " + input);
			System.out.println("Postfix Expression-------->  " + output + '\n');
		}catch(Exception e){
			System.out.println("Exception Catch " + e.getMessage());
		}
		in.close();
	}

}
