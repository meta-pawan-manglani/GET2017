/*
 * 
 */
package com.metcube.main;

import com.metacube.io.Input;
import com.metacube.util.Utility;
import com.metacube.util.customArrayList.CustomList;
import com.metacube.util.customLinkedList.CustomLinkedList;

/**
 * @author Pawan Manglani
 * @version 1.1 21-Aug-2017
 */
public class LinkedListMain {

   
    public static <T> void main(String[] args) {

        int choice = 0, position = 0;
        CustomList<T> linkedList = new CustomLinkedList<>();
        do {
            printMenu();
            choice = Input.takeIntegerAsInput();

            switch (choice) {
            /*Add element in list*/
                case 1:
                    System.out.println("Enter element you want to add");
                    T element = Input.takeElementAsInput();
                    linkedList.add(element);
                    break;
            
              /*Add element at specified position*/ 
                case 2:
                    System.out.println("Enter position at which you want to add element");
                    position = Input.takeIntegerAsInput();
                    System.out.println("Enter element you want to add");
                    element = Input.takeElementAsInput();
                    linkedList.add(position-1, element);
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
                    System.out.println("Enter position  of the element you want to remove");
                    position = Input.takeIntegerAsInput();
                    element = linkedList.remove(position - 1);
                    if (element != null) {
                        System.out.println("Element is removed from the LinkedList");
                    }
                    break;
                    
                /*Get the element from position*/     
                case 5:
                    System.out.println("Enter position of the element you want to retreive");
                    position = Input.takeIntegerAsInput();
                    element = linkedList.get(position - 1);
                    if (element != null) {
                        System.out.println("Element present at this position  is " + element.toString());
                    }
                    break;
                    
                    /*Reverse the list*/    
                case 6:
                    Utility.reverse(linkedList);
                    break;
                    
                 /*Print the  list*/    
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
    public static void printMenu() {
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
}
