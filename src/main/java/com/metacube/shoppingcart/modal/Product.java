package com.metacube.shoppingcart.modal;

/**
 *  @author Pawan Manglani
 *  @version 1.1 27-Sep-2017
 * The Class Product.
 */
public class Product {
	 /** The Id. */
    private int Id;
    
    /** The name. */
    private String name;
    
    /** The price. */
    private double price;

    /**
     * Instantiates a new product.
     */
    public Product() {

    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return Id;
    }

    /**
     * Sets the id.
     *
     * @param Id the new id
     */
    public void setId(final int Id) {
        this.Id = Id;
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
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
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
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

  /**
   * Use to print Product in string format.
   *
   * @return String format of product
   */
    @Override
    public String toString() {
        return  ""+ name+ "\t\t"  + Id + "\t\t"  + price;
    }
}
