package shopingStoreTerminal;

import java.util.ArrayList;

public class ProductPromo {

	private String promotionType;
	private double discountAmount;

	private ArrayList<String> productIds;
	public ArrayList<String> getProductIds() {
		return productIds;
	}

	public void setProductIds(ArrayList<String> productIds) {
		this.productIds = productIds;
	}

	public String getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Override
	public String toString() {
		return "ProductPromo [promotionType=" + promotionType
				+ ", discountAmount=" + discountAmount + ", productIds="
				+ productIds + "]";
	}



}
