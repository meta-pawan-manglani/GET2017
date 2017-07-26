package shopingStoreTerminal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


/**
 * The Class Billing.
 */
public class Billing implements Promotion{


	/** The product. */
	private Product product;

	/** The id. */
	private String id;

	/** The order object. */
	private OrderEntry orderObject;

	private OrderPromo orderPromoObject;

	/** The temp. */
	private ArrayList<?> temp;

	/** The traversal. */
	private Iterator<?> traversal;

	public String OrderFixedAmountPromotion = "OrderFixedAmountPromotion";
	
	private String outputFile = "C:/Users/user22/Desktop/Invoice";
	
	private BufferedWriter writer;



	/* (non-Javadoc)
	 * @see shopingStoreTerminal.Promotion#isApplicable(shopingStoreTerminal.Product)
	 */
	@Override
	public boolean isApplicable(Product product) {
		boolean applicable = false;
		if(product.isFixedProductLevelDiscount()) {
			applicable = true;
		}else if(product.isFixedPercentageDiscount()) {
			applicable = true;
		}
		return applicable;
	}

	/* (non-Javadoc)
	 * @see shopingStoreTerminal.Promotion#getDiscount(shopingStoreTerminal.Product)
	 */
	@Override
	public double getProductDiscount(Product product) {
		temp = product.getFixedDiscount();
		traversal = temp.iterator();
		double discount = 0,productLevelDiscount = 0;
		while(traversal.hasNext()) {
			System.out.println();
			discount = (double) traversal.next();
			productLevelDiscount += discount;
			System.out.print("Rs " + discount);
			System.out.println(" off on " + product.getProductName());
		}
		temp = product.getPercentageDiscount();
		traversal = temp.iterator();
		while(traversal.hasNext()) {
			discount = (double) traversal.next();
			productLevelDiscount += product.getDiscountedProductPrice(discount);
			System.out.println();
			System.out.print(discount);
			System.out.println(" % off on " + product.getProductName());
		}
		return productLevelDiscount;
	}


	@Override
	public double getOrderDiscount(ArrayList<OrderPromo> orderPromo,double totalCost) {
		traversal = orderPromo.iterator();
		double discount = 0,threshold = 0,maxDiscount = 0;
		while(traversal.hasNext()) {
			orderPromoObject = (OrderPromo) traversal.next();
			threshold = orderPromoObject.getThresholdAmount();
			if(totalCost > threshold) {
				if(OrderFixedAmountPromotion.equalsIgnoreCase(orderPromoObject.getPromotionType())) {
					discount = orderPromoObject.getDiscountAmount();
				} else {
					discount = (totalCost*orderPromoObject.getDiscountAmount())/100;
				}
				if(discount > maxDiscount) {
					maxDiscount = discount;
				}
			}
		}

		return maxDiscount;
	}




	/**
	 * Do heading.
	 * @throws IOException 
	 */
	public void doHeading() throws IOException {
		
		String printer = "#####################################################";
		System.out.println(printer);	
		writer.append(printer);
		writer.newLine();
		
		printer = "YOUR ORDER :";
		System.out.println(printer);
		writer.append(printer);
		writer.newLine();
		
		
		
		printer = "#####################################################";
		System.out.println(printer);	
		writer.append(printer);
		writer.newLine();
	}


	/**
	 * Prints the bill.
	 *
	 * @param idProductMap the id product map
	 * @param order the order
	 * @throws IOException 
	 */
	public void printBill(HashMap<String,Product> idProductMap,
			ArrayList<OrderEntry> order,ArrayList<OrderPromo> orderPromo,int userCount) throws IOException {
	
		writer = new BufferedWriter(new FileWriter(outputFile + Integer.toString(userCount) + ".txt"));
		
		doHeading();
		Iterator<OrderEntry> orderList = order.iterator();
		double cost = 0,productLevelDiscount = 0,totalCost = 0,orderLevelDiscount = 0;
		double totalDiscount = 0,tempCost = 0;

		/****Check for Product Level Discount****/
		String answer ="";
		while(orderList.hasNext()) {
			answer="";
			System.out.println();
			/******Getting the Product*****/

			orderObject = orderList.next();
			id = orderObject.getOrderId();
			product = idProductMap.get(id);
       
			/****Information about product***/
			answer += "Product : " + product.getProductName() + " - code[";
			answer += product.getProductId() + "] " + "\n";
			writer.append(answer);
			writer.newLine();
			System.out.print(answer);
			
			cost = product.getProductPrice();
			tempCost = cost;
			answer = "cost : ";
			cost = orderObject.getQuantity() * cost;
			totalCost += cost;

			/***Information about product cost**/
			answer += cost + "(";
			answer += orderObject.getQuantity() + "*" +  tempCost + " ) " + "\n";
			writer.append(answer);
			writer.newLine();
			System.out.print(answer);
			
			answer = "Applied Promotions/Discount" +"\n";
			writer.append(answer);
			writer.newLine();
			System.out.print(answer);

			/****Check if discount is available***/
			if(isApplicable(product)) {
				productLevelDiscount += getProductDiscount(product);
			}else {
				answer = "No Product Discount on this Product " + "\n";
				writer.append(answer);
				writer.newLine();
				System.out.print(answer);
			}
		}


		/****Check for Order Level Discount***/
		orderLevelDiscount = getOrderDiscount(orderPromo,totalCost);
		
		totalDiscount = (productLevelDiscount + orderLevelDiscount);

		/****Information about Discount and cost***/
		
		answer = "Subtotal : " + totalCost + "\n";
		writer.append(answer);
		writer.newLine();
		System.out.print(answer);
		
		
		answer = "Product Level Discount :" + productLevelDiscount + "\n";
		writer.append(answer);
		writer.newLine();
		System.out.print(answer);
		
		answer = "OrderLevelDiscount :" + orderLevelDiscount + "\n";
		writer.append(answer);
		writer.newLine();
		System.out.print(answer);
		
		
		answer = "Total Discount :" + totalDiscount + "\n";
		writer.append(answer);
		writer.newLine();
		System.out.print(answer);
		
		
		answer = "Total :" + (totalCost - totalDiscount);
		writer.append(answer);
		writer.newLine();
		System.out.println(answer);
		
		
		System.out.println();
		System.out.println();
		writer.close();
	}
}
