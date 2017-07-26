
package shopingStoreTerminal;

import java.util.ArrayList;

/**
 * The Interface Promotion.
 */
public interface Promotion {
	
	/**
	 * Checks if promotion is applicable on product.
	 *
	 * @param product the product
	 * @return true, if is applicable
	 * false,If not applicable
	 */
	public boolean isApplicable(Product product) ;
	
	/**
	 * Gets the discount on product.
	 *
	 * @param product the product
	 * @return the discount price
	 */
	public double getProductDiscount(Product product);
	
	/**
	 * Gets the order discount.
	 *
	 * @param order the order
	 * @return the order discount
	 */
	public double getOrderDiscount(ArrayList<OrderPromo> orderPromo,double totalCost);
}
	