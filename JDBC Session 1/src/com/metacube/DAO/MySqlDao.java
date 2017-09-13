/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.entity.Titles;
import com.metacube.utility.DBConnection;


/**
 * The Class MySqlDao.
 *
 * @author Pawan Manglani
 * @version 1.1 12-Sep-2017
 */
public class MySqlDao implements BaseDao{

	/** The connection. reference of database connection*/
	private Connection connection;

	/** The result. reference of result set*/
	private ResultSet result;

	/** The titles list. reference of titles list*/
	private List<Titles> titlesList;

	/** The t. reference of titles*/
	private Titles t;

	/**
	 * Instantiates a new my sql dao.
	 */
	public MySqlDao() {
		connection = DBConnection.getConnection();
	}


	/**
	 *  Get Author Details
	 * 
	 *  Fetch all the books published by author
	 * 
	 * @param authorName name of author whose details is needed
	 * @return List containing details of title
	 * @throws SQLException the SQL exception
	 */
	@Override
	public List<Titles> getAuthorDetails(String authorName) throws SQLException {
		titlesList = new ArrayList<>();

		/*query to find author details*/
		String queryFindAuthorDetails = "SELECT a.author_nm, t.title_nm from authors a "+
				" JOIN  title_author ta ON a.author_id = ta.author_id " + 
				" JOIN titles t ON t.title_id = ta.title_id " + 
				" WHERE a.author_nm = ?;";

		/*making a statement*/
		PreparedStatement prepareStatement = connection.prepareStatement(queryFindAuthorDetails);
		/*set the author name at the place of ?*/
		prepareStatement.setString(1, authorName);
		/*executing the query*/
		result = prepareStatement.executeQuery();

		/*iterating the result set*/
		while(result.next()) {
			/*making an new object of titles class*/
			t = new Titles();
			/*Setting the title name of book*/
			t.setTitleName(result.getString("title_nm"));
			/*t.setSubjectId(Integer.parseInt(result.getString("subject_id")));
			t.setPublisherId(Integer.parseInt(result.getString("publisher_id")));
			t.setTitleId(Integer.parseInt(result.getString("title_id")));*/

			/*adding the object in list*/
			titlesList.add(t);
		}
		return titlesList;
	}



	/**
	 * Checks if is available.
	 * 
	 * Return flag to indicate whether the  the book has been issued or not.
	 * 
	 * @param bookName the book name
	 * @return true, if book is available
	 * @throws SQLException the SQL exception
	 */
	public boolean isAvailable(String bookName) throws SQLException {
		boolean flag = true;

		int accessionNo = Integer.MIN_VALUE;

		/*query to find accession number of book by it's name*/
		String queryFindAccessionNo = "SELECT accession_no FROM books b "+
				" JOIN titles t ON t.title_id = b.title_id " + 
				" WHERE t.title_nm = ?;";

		/*making a statement*/
		PreparedStatement prepareStatement = connection.prepareStatement(queryFindAccessionNo);
		/*set the book name at the place of ?*/
		prepareStatement.setString(1, bookName);
		/*executing the query*/
		result = prepareStatement.executeQuery();

		/*if result set is empty*/
		if(!result.absolute(1)) {
			flag = false;
		} else {
			/*else get the accession_no from book*/
			accessionNo = result.getInt(1);

			/*query to find if the book is available*/
			String queryFindIfAvailable = "SELECT t1.count - t2.count AS Difference FROM" + 
					" (SELECT bi.accession_no,count(bi.accession_no) as Count FROM book_issue bi" + 
					" WHERE accession_no =  ? ) AS t1" +
					" JOIN" +
					" (SELECT br.accession_no,count(br.accession_no) as Count FROM book_return br" +
					" WHERE accession_no = ? ) AS t2 ;";

			/*making a statement*/
			prepareStatement =  connection.prepareStatement(queryFindIfAvailable);
			/*set the accession number at the place of ?*/
			prepareStatement.setInt(1, accessionNo);
			prepareStatement.setInt(2, accessionNo);
			/*executing the query*/
			result = prepareStatement.executeQuery();
			/*setting the cursor on the first line*/
			result.absolute(1);
			/*If the difference of issue date and return date is greater than zero 
			 * that means the book is already issued and can't be available
			 */
			if (result.getInt("Difference") > 0 ) {
				flag = false;
			}
		}
		return flag;
	}


	/**
	 * Delete books.
	 *
	 * Delete all those books which were not issued in last year
	 *
	 * @param year the number of years
	 * @return the count of number of rows affected by the query
	 * @throws SQLException the SQL exception
	 */
	public int deleteBooks(int year) throws SQLException {
		/*query to delete books which are not issued from year time*/
		String deleteQuery = "DELETE FROM books WHERE books.accession_no NOT IN "
				+ "(SELECT accession_no FROM book_issue WHERE TIMESTAMPDIFF(YEAR,issue_dt,NOW()) < ? )";
		/*preparing the statement*/
		PreparedStatement prepareStatement =  connection.prepareStatement(deleteQuery);
		/*set the number of year at the place of ?*/
		prepareStatement.setInt(1, year);
		/*return the number of rows affected by query*/
		return prepareStatement.executeUpdate();
	}

	/**
	 * Close
	 * 
	 * Closing the database connection.
	 * @throws SQLException 
	 */
	@Override
	public void close() throws SQLException {
		connection.close();
	}
}
