package com.metacube.binaryTree;

import java.util.Scanner;
/**
 * The Class Main.
 * 
 * @author Pawan Manglani
 * @version 1.1 23-Aug-2017
 * @param <T> the element type
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param <T> the element type
	 * @param args the arguments
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		BinaryTree mirrorTree = new BinaryTree();
		Scanner scan = new Scanner(System.in);

		do{
			/*Print menu*/
			printMenu();
			/*Take user choice*/
			int choice = takeIntegerAsInput();

			switch(choice){
			/*In case of adding the data*/
			case 1:
				System.out.println("Tnter number of elements you want to add to the binary tree");
				int num = takeIntegerAsInput();
				for(int index = 0 ; index < num ; index++){
					System.out.println("Enter the element");
					tree.insertNode(takeElementAsInput());
				}
				break;
				/*Inorder printing*/
			case 2:
				tree.getInOrder();
				System.out.println(tree.getInOrder());
				break;
				/*pre order printing*/
			case 3:
				tree.getPreOrder();
				System.out.println(tree.getPreOrder());
				break;
				/*post order printing*/
			case 4:
				tree.getPostOrder();
				System.out.println(tree.getPostOrder());
				break;
				/*In case of creatig mirror*/
			case 5:
				System.out.println("Enter number of elements you want to add to the binary tree");
				num = takeIntegerAsInput();
				for(int index = 0 ; index < num ; index++){
					System.out.println("Enter the element");
					T data = (T)scan.next();
					mirrorTree.insert(data);
				}
				break;
				/*Check if images are mirror images*/
			case 6:
				if(tree.mirror(mirrorTree)){
					System.out.println("Trees are mirror images");
				}
				else{
					System.out.println("Trees are not mirror images");
				}
				break;
				/*In case of exit*/
			case 7: 
				scan.close();
				System.exit(0);
				break;
			}
		}while(true);
	}

	public static void printMenu(){
		System.out.println("\n1. Add Multiple Elements");
		System.out.println("2. Inorder ");
		System.out.println("3. Preorder ");
		System.out.println("4. Postorder ");
		System.out.println("5. Create Mirror ");
		System.out.println("6. Check Mirror");
		System.out.println("7. Exit ");
		System.out.println("\nEnter your choice");
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

}
