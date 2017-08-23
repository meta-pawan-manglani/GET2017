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
			printMenu();
			int choice = takeIntegerAsInput();

			switch(choice){
			case 1:
				System.out.println("Tnter number of elements you want to add to the binary tree");
				int num = takeIntegerAsInput();
				for(int index = 0 ; index < num ; index++){
					System.out.println("Enter the element");
					tree.insertNode(takeElementAsInput());
				}
				break;
			case 2:
				tree.inOrder();
				System.out.println(tree.getInOrder());
				break;
			case 3:
				tree.preOrder();
				System.out.println(tree.getPreOrder());
				break;
			case 4:
				tree.postOrder();
				System.out.println(tree.getPostOrder());
				break;
			case 5:
				System.out.println("Tnter number of elements you want to add to the binary tree");
				num = takeIntegerAsInput();
				for(int index = 0 ; index < num ; index++){
					System.out.println("Tnter the element");
					T data = (T)scan.next();
					mirrorTree.insertMirrortNode(data);
				}
				break;
			case 6:
				if(tree.mirror(mirrorTree.getRoot(),tree.getRoot())){
					System.out.println("Trees are mirror images");
				}
				else{
					System.out.println("Trees are not mirror images");
				}
				break;
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
