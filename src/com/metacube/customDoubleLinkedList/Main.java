/*
 * 
 */
package com.metacube.customDoubleLinkedList;

import java.util.Scanner;

public class Main {
	public static <E> void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DoublyLinkedList<E> linkedList = new DoublyLinkedList<E>();
		do {
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
			int val = scan.nextInt();
			switch (val) {
			case 1:
				System.out.println("Enter element you want to add");
				E element = (E) scan.next();
				linkedList.addNode(element);
				break;
			case 2:
				System.out
						.println("Enter location at which you want to add element");
				int location = scan.nextInt();
				System.out.println("Enter element you want to add");
				element = (E) scan.next();
				if(linkedList.addNodeAtLocation(location, element)){
					System.out.println("Element is added to list");
				}
				else{
					System.out.println("Invalid location");
				}
				break;
				
			case 3:
				System.out.println("Enter element you want to remove");
				element = (E) scan.next();
				if (linkedList.removeItem(element)) {
					System.out
							.println("Element is removed from the LinkedList");
				} else {
					System.out
							.println("Element is not present in the LinkedList");
				}
				break;
			case 4:
				System.out
						.println("Enter location of the element you want to remove");
				location = scan.nextInt();
				if (linkedList.removeItemFromPosition(location - 1)) {
					System.out.println("Element is removed from the LinkedList");
				} else {
					System.out
							.println("Invalid Location");
				}
				break;
			case 5:
				System.out
						.println("Enter location of the element you want to retreive");
				location = scan.nextInt();
				element = linkedList.getElementFromPosition(location - 1);
				if (element.equals("-1")) {
					System.out.println("Location Invalid");
				} else {
					System.out.println("Element present at this location is "
							+ element.toString());
				}
				break;
			case 6:
				linkedList.reverseLinkedList();
				break;
			case 7:
				int size = linkedList.getSize();
				if(size == 0){
					System.out.println("LinkedList is empty");
				}
				else{
				for (int index = 0; index < size; index++) {
					System.out.print(linkedList.getElementFromPosition(index)
							+ " ");
				}
				}
				break;
			case 8:
				break;
			case 9:
				System.exit(0);
				break;
			}
		} while (true);
	}
}
