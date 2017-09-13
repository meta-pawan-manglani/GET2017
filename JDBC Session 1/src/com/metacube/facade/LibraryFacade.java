package com.metacube.facade;

import java.sql.SQLException;
import java.util.List;

import com.metacube.DAO.BaseDao;
import com.metacube.DAO.DAOFactory;
import com.metacube.entity.Titles;
import com.metacube.enums.DBType;
import com.metacube.enums.Status;
import com.metacube.io.Input;


/**
 * The Class LibraryFacade.
 * 
 * @author Pawan Manglani
 * @version 1.1 12-Sep-2017
 */
public class LibraryFacade {



	/** The pf.  reference of LibraryFacade*/
	private static LibraryFacade lf;

	/** The dao. reference of base DAO */
	private static BaseDao dao;

	/** The titles list. reference of list save the object of title list*/
	private List<Titles> titlesList;

	/**
	 * Instantiates a new library facade.
	 */
	private LibraryFacade() {
		dao = DAOFactory.getInstance(DBType.MySQLDao);
	}

	/**
	 * Gets the single instance of LibraryFacade.
	 *
	 * @return single instance of LibraryFacade
	 */
	public static LibraryFacade getInstance(){
		/**Double locking mechanism to make a singleton object**/
		if(lf==null){
			synchronized(LibraryFacade.class){
				if(lf==null){
					lf = new LibraryFacade();
				}
			}
		}
		return lf;
	}


	/**
	 * Gets the author details.
	 *
	 * @param authorName the author name
	 * @return the list containing author details
	 */
	public List<Titles> getAuthorDetails(String authorName) {
		try {
			/*getting the author details*/
			titlesList = dao.getAuthorDetails(authorName);
		} catch (SQLException e) {
			Input.print("Database Error Occured while getting author details " + e.getMessage());
			titlesList = null;
		} catch (Exception e) {
			Input.print("Error  Occured while getting author details " + e.getMessage());
		}
		return titlesList;
	}


	/**
	 * Checks if book is available.
	 *
	 * @param bookName the book name
	 * @return the status of book
	 */
	public Status isAvailable(String bookName) {
		Status result = Status.NOT_AVAILABLE;
		try {
			/*check if book is available*/
			if(dao.isAvailable(bookName) ) {
				result = Status.AVAILABLE;
			}
		} catch (SQLException e) {
			Input.print("Database Error Occured while getting book details " + e.getMessage());
			result = Status.Error_Occured;
		} catch (Exception e) {
			Input.print("Error Occured while getting book details " + e.getMessage());
			result = Status.Error_Occured;
		}
		return result;
	}

	/**
	 * Delete books.
	 *
	 * @param years the years
	 * @return the number of rows affected by operation
	 */
	public int deleteBooks(int years) {
		int noOfRows = Integer.MIN_VALUE;
		try {
			/*get the number of rows affected by operation*/
			noOfRows = dao.deleteBooks(years);
		} catch (SQLException e) {
			Input.print("Database Error Occured while performing delete operation " + e.getMessage());
		} catch (Exception e) {
			Input.print("Error Occured while performing delete operation " + e.getMessage());
		}
		return noOfRows;
	}

	/**
	 * Close.
	 * Closing the stream
	 */
	public void close() {
		try {
			/*closing the stream*/
			dao.close();
		} catch (SQLException e) {
			System.out.println("Error while closing databse Stream " + e.getMessage() + e.getCause());
		} catch (Exception e) {
			Input.print("Error while closing databse Stream  " + e.getMessage());
		}
	}

}
