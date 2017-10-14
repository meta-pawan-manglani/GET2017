package com.metacube.shoppingcart.dto;


/**
 * 
 *  @author Pawan Manglani
 * @version 1.1 27-Sep-2017
 * The Class ProductDto.
 */
public class ProductDto {

	/** The id. */
	private int id;

	/** The name. */
	private String name;

	/** The price. */
	private double price;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", price=" + price
				+ "]";
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the price to set
	 */
	public void setPrice(final double price) {
		this.price = price;
	}

}
