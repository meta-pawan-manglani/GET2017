package com.metacube.controller;

import java.util.Iterator;
import java.util.List;

import com.metacube.entity.Titles;
import com.metacube.enums.Status;
import com.metacube.facade.LibraryFacade;


/**
 * The Class Controller.
 *  @author Pawan Manglani
 * @version 1.1 12-Sep-2017
 */
public class Controller {

	/** The lf. reference of library facade*/
	private LibraryFacade lf;

	/** The titles list. reference of list */
	private List<Titles> titlesList;

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		lf = LibraryFacade.getInstance();
	}

	/**
	 * Gets the author details.
	 *
	 * @param authorName the author name
	 * @return the author details
	 */
	public String getAuthorDetails(String authorName) {
		authorName = authorName.toLowerCase();
		String result = Status.Success.toString();
		/*calling the function in facade layer*/
		titlesList = lf.getAuthorDetails(authorName);
		/*If list reference is null it means an error has occurred*/
		if(titlesList == null) {
			result = Status.Error_Occured.toString();
		} else if(titlesList.isEmpty()) {
			/*In case if an author books is not present in library*/
			result = "This author has no books in library\n";
		} else {
			/*else parsing the result to send it to view*/
			result = "Author Name\t" + "Title Name\n";
			Iterator<Titles> itr = titlesList.iterator();
			while(itr.hasNext()) {
				result += authorName + "\t\t" + itr.next().getTitleName() + "\n";
			}
		}
		result += "\n\n<------------------End--------------------->";
		/*returning the result*/
		return result;
	}


	/**
	 * Checks if book is available.
	 *
	 * @param bookName the book name
	 * @return the string Status of book
	 */
	public String isAvailable(String bookName) {
		String result = "Book Is";
		bookName = bookName.toLowerCase();
		/*get the operation status*/
		Status answer = lf.isAvailable(bookName);
		/*if book is available*/
		if(answer == Status.AVAILABLE) {
			result +=  " Available\n";
		} else if(answer == Status.NOT_AVAILABLE) {
			/*in case if book is not available*/
			result += " Not Available\n";
		} else {
			/*In case of error*/
			result = Status.Error_Occured.toString() + "\n";
		}

		result += "\n\n<------------------End--------------------->\n";
		return result;
	}

	/**
	 * Delete books.
	 *
	 * @param years the years
	 * @return the string which tells about the number of rows affected by operation
	 */
	public String deleteBooks(int years) {
		String result = "";
		/*get the number of rows affected by operation*/
		int count = lf.deleteBooks(years);
		/*if number of rows are equal to Integer.MIN_VALUE it means an error has occurred*/
		if(count==Integer.MIN_VALUE) {
			result = Status.Error_Occured.toString() + " While performing delete operation \n";
		} else {
			/*else print the result*/
			result = "" + count + " rows affected \n";
		}

		result += "\n\n<------------------End--------------------->\n";
		return result;
	}

	/**
	 * Close.
	 * Closing the database connection
	 */
	public void close() {
		lf.close();
	}
}
