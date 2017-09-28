/*
 * 
 */
package com.metcube.main;

import com.metacube.customDoubleLinkedList.DoublyLinkedList;
import com.metacube.io.Input;
import com.metacube.util.Utility;

/**
 * The Class DoubleLinkedListMain.
 * 
 * @author Pawan Manglani
 * @version 1.1 21-Aug-2017
 */
public class DoubleLinkedListMain {

	/**
	 * The main method.
	 *
	 * @param <T> the generic type
	 * @param args the arguments
	 */
	public static <T> void main(String[] args) {
		DoublyLinkedList<T> linkedList = new DoublyLinkedList<>();
		do {
			printMenu();
			int val = Input.takeIntegerAsInput();

			switch (val) {
			/*Add element in list*/
			case 1:
				System.out.println("Enter element you want to add");
				T element = Input.takeElementAsInput();
				linkedList.add(element);
				break;
				
			/*Add element at specified position*/       
			case 2:
				System.out.println("Enter location at which you want to add element");
				int location = Input.takeIntegerAsInput();
				System.out.println("Enter element you want to add");
				element = Input.takeElementAsInput();
				linkedList.add(location - 1, element);
				break;
			
			/*Remove Element*/	
			case 3:
				System.out.println("Enter element you want to remove");
				element = Input.takeElementAsInput();
				if (linkedList.remove(element)) {
					System.out.println("Element is removed from the LinkedList");
				} else {
					System.out.println("Element is not present in the LinkedList");
				}
				break;
				
			/*Remove element from position*/	
			case 4:
				System.out.println("Enter location of the element you want to remove");
				location = Input.takeIntegerAsInput();
				location = location - 1;
				element = linkedList.remove(location);
				if (element != null) {
					System.out.println("Element is removed from the LinkedList");
				}
				break;
			
			/*Get the element from position*/	
			case 5:
				System.out.println("Enter location of the element you want to retreive");
				location = Input.takeIntegerAsInput();
				element = linkedList.get(location - 1);
				if (element!=null) {
					System.out.println("Element present at this location is "+ element.toString());
				}
				break;
			/*Reverse the linked list*/	
			case 6:
				Utility.reverse(linkedList);
				break;
			/*Print the linked list*/	
			case 7:
				String result = linkedList.toString();
                if (result.contains("null")) {
                    result = "List is Empty";
                }
                System.out.println(result);
				break;
			/*Sort the linked list*/	
			case 8:
				Utility.sort(linkedList);
				break;
			/*Exit */	
			case 9:
				System.exit(0);
				break;
			}
		} while (true);
	}

	/**
	 * print Menu
	 * 
	 * This method print menu on console.
	 */
	public static void printMenu() {
		System.out.println("\n1. Add item to DoublyLinkedList");
		System.out.println("2. Add item to DoublyLinkedList at a location");
		System.out.println("3. Remove item from DoublyLinkedList");
		System.out.println("4. Remove item from DoublyLinkedList by location");
		System.out.println("5. Retreive item from DoublyLinkedList by location");
		System.out.println("6. Reverse the DoublyLinkedList");
		System.out.println("7. Print DoublyLinkedList");
		System.out.println("8. Sort DoublyLinkedList");
		System.out.println("9. Exit\n");
		System.out.println("Enter your choice");
	}

}
