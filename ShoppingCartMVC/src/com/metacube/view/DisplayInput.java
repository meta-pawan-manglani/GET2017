package com.metacube.view;


import java.util.Scanner;

import com.metacube.controller.CartController;
import com.metacube.controller.ProductController;
import com.metacube.enums.Status;


/**
 * The Class DisplayInput.
 * 
 * Takes the input and also responsible for Display
 * @author Pawan Manglani
 * @version 1.1 14-Aug-2017
 */
public class DisplayInput {	

	/** productController object of product controller class*. */
	ProductController productController = new ProductController();

	/** cartController object of cart controller class*. */
	CartController cartController = new CartController();

	/** Scanner class object*. */
	Scanner scan = new Scanner(System.in);


	/**
	 * Display menu.
	 */
	public static void displayMenu(){
		System.out.println("Press 1 to see products");
		System.out.println("Press 2 to buy products");
		System.out.println("Press 3 to see cart");
		System.out.println("Press 4 to generate Bill");
		System.out.println("Press 5 to delete item in your cart");
		System.out.println("Press 6 to exit");
	}


	/**
	 * Prints the all products.
	 */
	public void printAllProducts(){
		productController.printProduct();
	}

	/**
	 * Gets the input.
	 *
	 * This function take the order id and it's quantity user want to purchase as input from console
	 */
	public void getInput(){
		boolean flag = true;

		System.out.println("Enter number of products you want to add to your cart :");
		int num = Integer.parseInt(scan.nextLine());

		//Taking input from user
		for(int index=0;index<num;index++){
			System.out.println("Enter code of product you want to add to your cart :");
			/*Code store the id of product*/
			String code = scan.nextLine();

			while(flag){
				/*check if product id is valid or not*/
				if(productController.searchProduct(code)==Status.Found){
					/*if found than breaks the loop*/
					flag = false;
				}else{
					/**In case if input product id is not valid**/
					System.out.println("Please Enter The valid Code");
					code = scan.nextLine();
				}
			}

			int quantity = 0;
			flag = true;
			System.out.println("Enter quantity of this product :");
			while(flag){
				try{
					quantity = Integer.parseInt(scan.nextLine());
					/**If quantity is less than zero than throws the exception**/
					if(quantity<0){
						throw new IllegalArgumentException();
					}
					/**If quantity is according to the validation breaks the loop**/
					flag = false;
				}catch(IllegalArgumentException e){
					System.out.println("Please Enter vaild  quantity");
				}
			}
			/**Add the product into the cart**/
			cartController.addCart(code, quantity);
		}

	}

	/**
	 * Prints the cart.
	 * 
	 * This method print the user cart
	 */
	public void printCart(){
		
		String printer = "\n########################";
		printer += "\nYOUR CART";
		printer += "\n########################";
		System.out.println(printer);
		System.out.println("Items in your cart is: ");
		
		/**Calling the print cart method of controller class**/
		cartController.printCart();
	}

	/**
	 * Generate bill.
	 * 
	 * This is used to generate bill
	 */
	public void generateBill(){
		String printer = "\n########################";
		printer += "\nYOUR ORDER";
		printer += "\n########################";
		System.out.println(printer);
		printCart();
		/**Calling the print bill method of controller class**/
		System.out.println("Your Total Bill is : " + cartController.printBill());
	}

	/**
	 * Delete item.
	 * 
	 * It will delete the item from cart
	 */
	public void deleteItem(){
		System.out.println("Enter the code of the product and its quantity");
		/**Taking the id as input from user**/
		String code = scan.nextLine();
		/**Taking the quantity as input**/
		int quantity = Integer.parseInt(scan.nextLine());
		/**calling the method of controller class**/
		cartController.delCart(code, quantity);
	}

}
