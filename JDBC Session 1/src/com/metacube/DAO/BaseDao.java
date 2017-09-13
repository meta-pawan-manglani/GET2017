/**
 * 
 */
package com.metacube.DAO;

import java.sql.SQLException;
import java.util.List;

import com.metacube.entity.Titles;


/**
 * The Interface BaseDao.
 *
 * @author Pawan Manglani
 * @version 1.1 12-Sep-2017
 */
public interface BaseDao { 

	/**
	 * Gets the author details.
	 *
	 * @param query the query
	 * @return the author details
	 * @throws SQLException the SQL exception
	 */
	public List<Titles> getAuthorDetails(String query) throws SQLException;

	/**
	 * Checks if is available.
	 *
	 * @param bookName the book name
	 * @return true, if book is available
	 * @throws SQLException the SQL exception
	 */
	public boolean isAvailable(String bookName) throws SQLException;

	/**
	 * Delete books.
	 *
	 * @param years the years
	 * @return the number of rows affected by delete operation
	 * @throws SQLException the SQL exception
	 */
	public int deleteBooks(int years) throws SQLException;

	/**
	 * Close.
	 * Closing the stream
	 */
	public void close() throws SQLException;
}
