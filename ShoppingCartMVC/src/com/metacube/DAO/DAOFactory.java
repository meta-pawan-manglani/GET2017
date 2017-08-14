package com.metacube.DAO;

import com.metacube.enums.DBType;

/**
 * A factory for creating DAO objects.
 * 
 * @author Pawan Manglani
 * @version 1.1 14-Aug-2017
 */
public class DAOFactory {
	
		
		/**
		 * Gets the single instance of DAOFactory.
		 *
		 * @param dbType tells the type of database
		 * @return single instance of DAOFactory
		 */
		public static BaseDao getInstance(DBType dbType){
			
			switch(dbType){
			case FileDao:
				return new FileDao();
			case InMemoryDao:
				return new InMemoryDao();
			case MySQLDao:
				return new MySqlDao();		
			default:
				return null;
			}
		}
}
