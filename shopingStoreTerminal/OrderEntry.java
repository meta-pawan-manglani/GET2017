package shopingStoreTerminal;

/**
 * The Class OrderEntry.
 */
public class OrderEntry {
	

	/** The order id. */
	private String orderId;
	
	/** The quantity. */
	private int quantity;

	/**
	 * Gets the order id.
	 *
	 * @return the order id
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * Sets the order id.
	 *
	 * @param orderId the new order id
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderEntry [orderId=" + orderId + ", quantity=" + quantity
				+ "]";
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

