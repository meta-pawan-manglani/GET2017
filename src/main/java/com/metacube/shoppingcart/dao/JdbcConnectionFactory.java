package com.metacube.shoppingcart.dao;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *  @author Pawan Manglani
 * @version 1.1 27-Sep-2017
 *
 * A factory for creating JdbcConnection objects.
 */
public class JdbcConnectionFactory {
	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws Exception the exception
	 */
	Connection getConnection() throws Exception
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/get_testdb", "get_user", "get_pwd");
			return con;
		}
		catch (Exception e)
		{
			System.out.println(e);
			throw e;
		}
	}
}
