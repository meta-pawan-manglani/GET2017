
package shopingStoreTerminal;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The Interface Promotion.
 * 
 * 
 * @author Pawan Manglani
 * @version 1.1 26-JUL-2017
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
	 * @throws IOException 
	 */
	public double getProductDiscount(Product product,int quantity) throws IOException;
	
	/**
	 * Gets the order discount.
	 *
	 * @param order the order
	 * @return the order discount
	 */
	public double getOrderDiscount(ArrayList<OrderPromo> orderPromo,double totalCost);
}
	