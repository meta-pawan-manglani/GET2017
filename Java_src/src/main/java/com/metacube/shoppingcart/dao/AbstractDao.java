package com.metacube.shoppingcart.dao;

import java.io.Serializable;

import com.metacube.shoppingcart.enums.Status;


/**
 * 
   @author Pawan Manglani
 * @version 1.1 27-Sep-2017

 * The Interface AbstractDao.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public interface AbstractDao<T, ID extends Serializable> {

	/**
	 * Save.
	 *
	 * @param <S> the generic type
	 * @param entity the entity
	 * @return the s
	 */
	<S extends T> Status save(S entity);

	/**
	 * Find one.
	 *
	 * @param primaryKey the primary key
	 * @return the t
	 */
	T findOne(ID primaryKey);

	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	Iterable<T> findAll();

	/**
	 * Count.
	 *
	 * @return the number 
	 */
	Long count();

	/**
	 * Delete.
	 *
	 * @param primaryKey the primary key
	 * @return the status
	 */
	Status delete(ID primaryKey);

	/**
	 * Edits the.entity
	 *
	 * @param primaryKey the primary key
	 * @return the status
	 */
	<S extends T>Status edit(S entity,ID primaryKey);
	/**
	 * Exists.
	 *
	 * @param primaryKey the primary key
	 * @return true, if successful
	 */
	boolean exists(ID primaryKey);
}
