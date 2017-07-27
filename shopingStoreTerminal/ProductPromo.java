package shopingStoreTerminal;

import java.util.ArrayList;
/**
 * The Class ProductPromo.
 * 
 * This class stores the product level promotion
 * 
 * @author Pawan Manglani
 * @version 1.10 26-JUL-2017
 */
public class ProductPromo {

	/** The promotion type. */
	private String promotionType;
	
	/** The discount amount. */
	private double discountAmount;

	/** The product ids. */
	private ArrayList<String> productIds;
	
	/**
	 * Gets the product ids.
	 *
	 * @return the product ids
	 */
	public ArrayList<String> getProductIds() {
		return productIds;
	}

	/**
	 * Sets the product ids.
	 *
	 * @param productIds the new product ids
	 */
	public void setProductIds(ArrayList<String> productIds) {
		this.productIds = productIds;
	}

	/**
	 * Gets the promotion type.
	 *
	 * @return the promotion type
	 */
	public String getPromotionType() {
		return promotionType;
	}

	/**
	 * Sets the promotion type.
	 *
	 * @param promotionType the new promotion type
	 */
	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

	/**
	 * Gets the discount amount.
	 *
	 * @return the discount amount
	 */
	public double getDiscountAmount() {
		return discountAmount;
	}

	/**
	 * Sets the discount amount.
	 *
	 * @param discountAmount the new discount amount
	 */
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	/*
	 * toString method 
	 * 
	 * prints the object
	 */
	@Override
	public String toString() {
		return "   "+ promotionType
				+ "                " + discountAmount + "              ";
	}



}
