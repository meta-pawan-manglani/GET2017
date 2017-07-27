package shopingStoreTerminal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * The Class ShoppingStoreTerminal Main class.
 *
 * 
 * @author Pawan Manglani
 * @version 1.1 26-JUL-2017
 */
public class ShoppingStoreTerminal extends Billing{

	/** The reader use to read the file. */
	private Reader reader;

	/** The product list containing objects of product. */
	private HashSet<Product> productList;

	/** The promoList containing object of ProductPromo. */
	private ArrayList<ProductPromo> promoList;

	/** The orderPromoList containing object of orderPromoList. */
	protected ArrayList<OrderPromo> orderPromoList;

	/** The orderList contains the Object of Order Entry class. */
	protected ArrayList<OrderEntry> orderList;

	/** idProductMap   It binds the product to its id. */
	protected HashMap<String, Product> idProductMap;

	/** Temporary List  Can be used to handle String. */
	private ArrayList<String> temp;

	/**  tempMap  Binds the id to OrderEntry class. */
	private HashMap<String,OrderEntry> tempMap;
	/**
	 * The p. type of Product class
	 */
	private Product p;

	/**
	 * The productPromo object.
	 */
	private ProductPromo productPromo;

	/** The order object type of order entry. */
	private OrderEntry order;

	/** The console. */
	private Reader console;

	/**
	 * Helper.
	 *
	 * @return the hash map
	 */
	public HashMap<String, Product> helper() {
		return idProductMap;
	}

	/**
	 * Take order.
	 */
	private void takeOrder() throws IllegalArgumentException{
		System.out.println("Enter number of different Id's to purchase");

		orderList = new ArrayList<>();
		boolean flag = true;
		int numberOfOrders = 0;
		/**Ask number of items user want to purchase**/
		do {
			try {
				numberOfOrders = Integer.parseInt(console.nextLine());
				if(numberOfOrders<=0) {
					throw new NumberFormatException("Number of different id should be greater than 0");
				}
				flag = false;
			}catch(NumberFormatException e) {
				System.out.println("Please enter a valid input");
			}
		}while(flag);

		String purchaseId;
		int quantity = 0;
		tempMap = new HashMap<>();

		/**This loop is responsible to take user input**/
		for (int index = 0; index < numberOfOrders; index++) {
			flag = true;
			System.out.println("Enter Id");
			order = new OrderEntry();

			/**purchaseId is the Id of product**/
			purchaseId = console.nextLine();
			while (!isValid(purchaseId)) {
				System.out.println("Please Enter a valid Id");
				purchaseId = console.nextLine().trim();
			}
			/**Set the Id of object in order**/
			order.setOrderId(purchaseId);

			/**Ask to Enter number of quantity one want to purchase of a product**/
			do {
				try {
					System.out.println("Enter quantity to buy");
					quantity = Integer.parseInt(console.nextLine());
					if (quantity <= 0) {
						throw new NumberFormatException();
					}
					flag = false;
				} catch (NumberFormatException e) {
					/**In case of invalid input this will execute **/
					System.out.println("Not Valid Quantity");
				}
			} while (flag);
			if(tempMap.containsKey(purchaseId)) {
				/**this will check if user have already purchase that product**/
				quantity += tempMap.get(purchaseId).getQuantity();
			}

			/*Set the number of quantity in order*/
			order.setQuantity(quantity);

			/**Put the order in a map**/
			tempMap.put(purchaseId,order);
		}
		/**Make a set of Id's**/
		Set<String> keySet = tempMap.keySet();
		/**Iterate them**/
		Iterator<String> key = keySet.iterator();
		while(key.hasNext()){
			/**add that into the order list**/
			orderList.add(tempMap.get(key.next()));
		}
	}

	/**
	 * Checks if is valid.
	 *
	 * @param id the id
	 * @return true, if is valid
	 */
	private boolean isValid(String id) {
		boolean validFlag = false;
		if (idProductMap.containsKey(id)) {
			validFlag = true;
		}
		return validFlag;
	}

	/**
	 * Do read product list.
	 *
	 * @param filePath the file path
	 * @param fileName the file name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void doReadProductList(String filePath, String fileName) throws IOException {
		System.out.println("Product table");
		reader = new Reader(filePath + fileName);
		productList = reader.readProducts();
		idProductMap = new HashMap<>();

		/**Printing the file on console **/
		System.out.print(" ProductId                   ");
		System.out.print(" ProductName                  ");
		System.out.println(" ProductPrice                 ");


		/**This loop also store all the objects of product in a list productList and print them on console***/
		Iterator<Product> itr = productList.iterator();
		while (itr.hasNext()) {
			p = itr.next();
			System.out.println(p.toString());
			idProductMap.put(p.getProductId(), p);
		}
		reader.close();
		System.out.println();
	}

	/**
	 * Do read product promo file.
	 *
	 * @param filePath the file path
	 * @param fileName the file name
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws NumberFormatException the number format exception
	 */
	private void doReadProductPromo(String filePath, String fileName) throws IOException, NumberFormatException {

		System.out.println("Product promo table");
		reader = new Reader(filePath + fileName);
		promoList = reader.readPromo();


		/**Printing the file on console **/
		System.out.print(" PromotionType                   ");
		System.out.print(" DiscountAmount                  ");
		System.out.println(" ProductName                  ");
		Iterator<ProductPromo> itr = promoList.iterator();
		while (itr.hasNext()) {
			productPromo = itr.next();
			temp = productPromo.getProductIds();

			/**This loop will store all the objects of productPromo in  promoList***/

			Iterator<String> idIterator = temp.iterator();
			while (idIterator.hasNext()) {
				String id = idIterator.next();
				if (isValid(id)) {
					p = idProductMap.get(id);

					/**check if type of promotion is fixedAmountPromotion**/
					if (("ProductFixedAmountPromotion").equalsIgnoreCase(productPromo.getPromotionType())) {
						p.setFixedProductLevelDiscount(true);
						p.setFixedDiscount(productPromo.getDiscountAmount());
					} else {
						/***Else set it to percentageDiscountAmount****/
						p.setFixedPercentageDiscount(true);
						p.setPercentageDiscount(productPromo.getDiscountAmount());
					}
				}
				System.out.print(productPromo.toString());
				System.out.println(p.getProductName());
			}

		}
		reader.close();
		System.out.println();
	}

	/**
	 * Do read order promo.
	 *
	 * @param filePath the file path
	 * @param fileName the file name
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws NumberFormatException the number format exception error in
	 * parsing the quantity
	 */
	private void doReadOrderPromo(String filePath, String fileName) throws IOException, NumberFormatException {

		System.out.println("Order promo table");
		reader = new Reader(filePath + fileName);
		orderPromoList = reader.readOrderPromo();

		/***Just for Printing the File on console**/
		System.out.print("PromotionType                  ");
		System.out.print("DiscountAmount               ");
		System.out.println("ThresholdAmount              ");
		Iterator<OrderPromo> itr = orderPromoList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
		reader.close();
		System.out.println();
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String args[]) throws IOException {
		try {

			/***Path to folder contains all files***/
			String filePath = "C:/Users/User22/Desktop/Assignment3/";
			String fileName = "ProductList.csv";

			ShoppingStoreTerminal obj = new ShoppingStoreTerminal();
			obj.doReadProductList(filePath, fileName);
			fileName = "ProductPromo.csv";
			obj.doReadProductPromo(filePath, fileName);
			fileName = "OrderPromo.csv";
			obj.doReadOrderPromo(filePath, fileName);
			int userCount = 1;
			String choice;
			boolean flag = true;
			obj.console = new Reader(System.in);

			/**Multiple Use Application**/
			do{
				obj.takeOrder();
				Billing invoice = new Billing();
				invoice.printBill(obj.idProductMap, obj.orderList,obj.orderPromoList,userCount);
				System.out.println("Do you want to continue if yes press 1 else press any other key");
				choice = obj.console.nextLine();
				if(!("1".equals(choice))) {
					flag = false;
				}
				userCount++;
			}while(flag);
			obj.console.close();
			System.out.println("Thank You for Shopping");
		} catch (FileNotFoundException | NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
