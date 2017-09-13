package com.metacube.utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.metacube.io.Input;

/**
 * The Class DBConnection.
 *  @author Pawan Manglani
 *  @version 1.1 12-Sep-2017
 */
public class DBConnection {

	/** The connection. */
	private static Connection connection;

	/**
	 * Load properties file.
	 *
	 * @return the properties
	 * @throws Exception the exception
	 */
	public static Properties loadPropertiesFile() throws Exception {
		/*make an instance of properties file*/
		Properties prop = new Properties();
		/*Create Input stream*/
		InputStream in = new FileInputStream("lib/jdbc.properties");
		/*load the file specified*/
		prop.load(in);
		/*closing the input stream*/
		in.close();
		/*return properties object*/
		return prop;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection Object
	 */
	public static Connection getConnection() {
		try {
			/*load the properties file*/
			Properties prop = loadPropertiesFile();

			/*load the jdbc driver*/
			Class.forName(prop.getProperty("MYSQLJDBC.Driver"));

			/*make the connection to the database*/
			connection = DriverManager.getConnection(prop.getProperty("MYSQLJDBC.Url"),prop.getProperty("MYSQLJDBC.Username"),prop.getProperty("MYSQLJDBC.Password"));
		} catch (ClassNotFoundException e) {
			Input.print("Error Occured while Creating Connection to Database " + e.getMessage()+"\n");
		} catch (SQLException e) {
			Input.print("Error Occured while Creating Connection to Database " + e.getMessage()+"\n");
		} catch (Exception e) {
			Input.print("Error Occured while Creating Connection to Database " + e.getMessage()+"\n");
		}
		return connection;
	}
}
