package com.metacube.shoppingcart.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  @author Pawan Manglani
 *  @version 1.1 27-Sep-2017
 * The Class Product.
 */
@Entity
@Table(name="Product")
public class Product {
	 /** The Id. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;
    
    /** The name. */
	@Column(name = "name")
    private String name;
    
    /** The price. */
	@Column(name = "price")
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
