/*
 * 
 */
package com.metcube.main;

import java.util.Scanner;

import com.metacube.util.Utility;
import com.metacube.util.customArrayList.CustomList;
import com.metacube.util.customLinkedList.CustomLinkedList;

/**
 * @author Pawan Manglani
 * @version 1.1 21-Aug-2017
 */
public class LinkedListMain {

	@SuppressWarnings({ "resource", "unchecked" })
	public static <T> void main(String[] args) {
		/**
		 * Scanner to take input from user
		 */
		Scanner scan = new Scanner(System.in);
		int choice = 0,position = takePositionAsInput();;
		CustomList<T> linkedList = new CustomLinkedList<>();
		boolean flagOnInput = true;
		do{
			printMenu();
			flagOnInput = true;
			while(flagOnInput){
				try{
					choice = scan.nextInt();
					flagOnInput = false;
				}catch(Exception e){
					System.out.println("Please Enter A Valid Value");
				}
			}
			switch (choice) {
			case 1:
				System.out.println("Enter element you want to add");
				T element = (T) scan.next();
				linkedList.add(element);
				break;
			case 2:
				System.out.println("Enter position = takePositionAsInput(); at which you want to add element");
				position = takePositionAsInput(); 
				System.out.println("Enter element you want to add");
				element = (T) scan.next();
				linkedList.add(position, element);
				break;
			case 3:
				System.out.println("Enter element you want to remove");
				element = (T) scan.next();
				if (linkedList.remove(element)) {
					System.out.println("Element is removed from the LinkedList");
				} else {
					System.out.println("Element is not present in the LinkedList");
				}
				break;
			case 4:
				System.out.println("Enter position = takePositionAsInput(); of the element you want to remove");
				position = takePositionAsInput();
				flagOnInput = false;

				element = linkedList.remove(position);
				if (element != null) {
					System.out.println("Element is removed from the LinkedList");
				} 
				break;
			case 5:
				System.out.println("Enter position = takePositionAsInput(); of the element you want to retreive");
				position = takePositionAsInput();
				element = linkedList.get(position);
				if (element!=null) {
					System.out.println("Element present at this position = takePositionAsInput(); is "+ element.toString());
				} 
				break;
			case 6:
				Utility.reverse(linkedList);
				break;
			case 7:
				System.out.println(linkedList.toString());
				break;
			case 8:
				Utility.sort(linkedList);
				break;
			case 9:
				System.exit(0);
				break;
			default:
				System.out.println("Please Enter a valid Option");
				break;
			}
		} while (true);
	}

	/**
	 * print Menu
	 * 
	 * This method print menu on console
	 */
	public static void printMenu(){
		System.out.println("\n1. Add item to LinkedList");
		System.out.println("2. Add item to LinkedList at a position");
		System.out.println("3. Remove item from LinkedList");
		System.out.println("4. Remove item from LinkedList by position ");
		System.out.println("5. Retreive item from LinkedList by position ");
		System.out.println("6. Reverse the LinkedList");
		System.out.println("7. Print LinkedList");
		System.out.println("8. Sort LinkedList");
		System.out.println("9. Exit\n");
		System.out.println("Enter your choice");
	}

	@SuppressWarnings("unchecked")
	public static <T> T takeElementAsInput(){
		Scanner in = new Scanner(System.in);
		T element = (T)in.next();
		in.close();
		return element;
	}

	public static int  takePositionAsInput(){
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		int position  = 0;
		while(flag){
			try{
				position = takePositionAsInput();
				flag = false;
			}catch(Exception e){
				System.out.println("Please Enter a valid Element");
			}
		}
		in.close();
		return position;
	}
}
