package shopingStoreTerminal;

import java.util.ArrayList;


/**
 * The Class Product.
 * 
 * This class stores the detail about product
 * 
 * @author Pawan Manglani
 * @version 1.1 26-JUL-2017
 */
public class Product{

	/** The product id. */
	private String productId;

	/** The product name. */
	private String productName;

	/** The product price. */
	private double productPrice;

	/**The FixedDiscountPrice**/
	private boolean fixedProductLevelDiscount;

	/**The FixedPercentDiscountPrice**/
	private boolean fixedPercentageDiscount;

	/**List that store all the fixed discount price**/
	private ArrayList<Double> fixedDiscount = new ArrayList<>();

	/**List that store all the percentage discount price**/
	private ArrayList<Double> percentageDiscount = new ArrayList<>();



	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName the new product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Gets the product price.
	 *
	 * @return the product price
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * Sets the product price.
	 *
	 * @param productPrice the new product price
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * Gets the discounted product price.
	 *
	 * @return the discounted product price
	 */
	public double getDiscountedProductPrice(double percentageDiscount) {
		percentageDiscount = (this.productPrice*percentageDiscount)/100;
		return percentageDiscount;
	}
	/**
	 * 
	 * @return boolean value if fixedProductLevelDiscount is applicable 
	 */
	public boolean isFixedProductLevelDiscount() {
		return fixedProductLevelDiscount;
	}

	public void setFixedProductLevelDiscount(boolean FixedProductLevelDiscount) {
		this.fixedProductLevelDiscount = FixedProductLevelDiscount;
	}
	/**
	 * 
	 * @return boolean value if fixedPercentageDiscount is applicable 
	 */

	public boolean isFixedPercentageDiscount() {
		return fixedPercentageDiscount;
	}

	public void setFixedPercentageDiscount(boolean FixedPercentageDiscount) {
		this.fixedPercentageDiscount = FixedPercentageDiscount;
	}
	public ArrayList<Double> getFixedDiscount() {
		return fixedDiscount;
	}

	public void setFixedDiscount(double fixedDiscount) {
		this.fixedDiscount.add(fixedDiscount);
	}

	public ArrayList<Double> getPercentageDiscount() {
		return percentageDiscount;
	}

	public void setPercentageDiscount(double percentageDiscount) {
		
		this.percentageDiscount.add(percentageDiscount);
	}
	@Override
	public String toString() {
		return "           " + productId + "         "+ productName + "                  " + productPrice
				+"";
	}
}
