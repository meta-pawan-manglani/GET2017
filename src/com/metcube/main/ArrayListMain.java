/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metcube.main;

import java.util.Scanner;

import com.metacube.util.Utility;
import com.metacube.util.customArrayList.*;

/**
 * The Class ArrayListMain.
 * 
 * @author Pawan Manglani
 * @version 1.1 21-Aug-2017
 */
public class ArrayListMain {


	/**
	 * The main method.
	 *
	 * @param <T> the generic type
	 * @param args the arguments
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> void main(String[] args) {
		// TODO code application logic here
		CustomList<T> cl = new CustomArrayList<>(10);
		Scanner scan = new Scanner(System.in);
		int position,index,choice = 0;
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
			switch(choice){
			case 1:
				System.out.println("Enter element you want to add");
				T element = (T)scan.next();
				cl.add(element);
				break;
			case 2:
				System.out.println("Enter position where you want to add the element");
				index = scan.nextInt();
				System.out.println("Enter element you want to add");
				element = (T)scan.next();
				if(index>0){
					index = index - 1;
				}
				cl.add(index, element);
				break;
			case 3:
				System.out.println("Enter element you want to get");
				element = (T)scan.next(); 
				position = cl.indexOf(element);
				if(position == -1){
					System.out.println("Element is not present in the ArrayList");
				}
				else{
					System.out.println("Element is at position : "+position);
				}
				break;
			case 4:
				System.out.println("Enter element you want to remove");
				element = (T)scan.next();
				if(cl.remove(element)){
					System.out.println("Element is removed from the ArrayList");
				}
				else{
					System.out.println("Element is not present in the ArrayList");
				}
				break;
			case 5:	
				System.out.println("Enter position of the element you want to remove");
				position = scan.nextInt();
				element = (T)cl.remove(position-1);
				if(element!=null){
					System.out.println("Element is removed from the ArrayList");
				}
				else{
					System.out.println("Element is not present in the ArrayList");
				}
				break;
			case 6:
				cl.clear();
				break;
			case 7:
				Utility.reverse(cl);
				break;
			case 8:
				Utility.sort(cl);
				break;
			case 9:
				String result = cl.toString();
				if(result.contains("null")){
					result = "List is Empty";
				}
				System.out.println(result);
				break;
			case 10:
				CustomList<T> joinList = new CustomArrayList<>();
				System.out.println("Enter number of elements you want to add to this new list");
				int num = scan.nextInt();
				for(index = 0 ; index < num;index++)
				{
					System.out.println("Enter element you want to add");
					element = (T)scan.next();
					joinList.add(element);
				}
				cl.addAll(joinList);
				break;
			case 11:
				scan.close();
				System.exit(0);
				break;
			default:
				System.out.println("Please Select A Valid Option");
				break;
			}
		}while(true);

	}
	/**
	 * print Menu
	 * 
	 * This method print menu on console
	 */
	public static void printMenu(){
		System.out.println("\n1. Add item to ArrayList");
		System.out.println("2. Add item to ArrayList at a position");
		System.out.println("3. Get item from ArrayList");
		System.out.println("4. Remove item from ArrayList");
		System.out.println("5. Remove item from ArrayList by position");
		System.out.println("6. Clear ArrayList");
		System.out.println("7. Reverse ArrayList");
		System.out.println("8. Sort ArrayList");
		System.out.println("9. Print ArrayList");
		System.out.println("10. Join two ArrayList");
		System.out.println("11. Exit\n");
		System.out.println("Enter your choice");
	}

}
