/**
 * @Date 02-October-2017
 * @author Pawan Manglani
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.dao;

import java.io.Serializable;

import com.metacube.shoppingcart.dto.CartDto;
import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Product;

/**
 * The Interface BaseDao.
 *
 * @param <T>
 *            the generic type
 * @param <ID>
 *            the generic type
 */
public interface BaseDao<T, ID extends Serializable> {

	/**
	 * Find one.
	 *
	 * @param primaryKey
	 *            the primary key
	 * @return the t
	 */
	T findOne(ID primaryKey);
	T getOne(String id);

	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	Iterable<T> findAll();

	/**
	 * Delete.
	 *
	 * @param primaryKey
	 *            the primary key
	 * @return true, if successful
	 */
	boolean delete(ID primaryKey);

	/**
	 * Exists.
	 *
	 * @param primaryKey
	 *            the primary key
	 * @return true, if successful
	 */
	boolean exists(ID primaryKey);

	/**
	 * Update.
	 *
	 * @param id
	 *            the id
	 * @param name
	 *            the name
	 * @param price
	 *            the price
	 * @return the product
	 */
	Product update(int id, String name, double price);

	/**
	 * Save.
	 *
	 * @param id
	 *            the id
	 * @param name
	 *            the name
	 * @param price
	 *            the price
	 * @return the product
	 */
	Product save(int id, String name, double price);

	Iterable<CartDto> getAll(final String id);

	Cart addToCart(String pname, double price, int productId, String userId);

}
