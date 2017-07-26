package shopingStoreTerminal;


/**
 * The Class OrderPromo.
 * 
 * This class store the promotion on order level
 * 
 * @author Pawan Manglani
 * @version 1.1 26-JUL-2017
 */
public class OrderPromo {
	
	/** The promotion type tells us which type of promotion is it exactly*/
	private String promotionType;
	
	/** The discount amount. */
	private double discountAmount;

	/** The threshold amount above which one is able to claim discount */
	private double thresholdAmount;
	
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
	
	/**
	 * Gets the threshold amount.
	 *
	 * @return the threshold amount
	 */
	public double getThresholdAmount() {
		return thresholdAmount;
	}
	
	/**
	 * Sets the threshold amount.
	 *
	 * @param thresholdAmount the new threshold amount
	 */
	public void setThresholdAmount(double thresholdAmount) {
		this.thresholdAmount = thresholdAmount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderPromo [promotionType=" + promotionType
				+ ", discountAmount=" + discountAmount + ", thresholdAmount="
				+ thresholdAmount + "]";
	}
}
