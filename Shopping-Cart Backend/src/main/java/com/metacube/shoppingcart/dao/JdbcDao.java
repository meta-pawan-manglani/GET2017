/**
 * @Date 02-October-2017
 * @author Pawan Manglani
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Class JdbcDao.
 *
 * @param <T>
 *            the generic type
 * @param <ID>
 *            the generic type
 */
public abstract class JdbcDao<T, ID extends Serializable> implements BaseDao<T, ID> {

	/** The connection factory. */
	JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();

	/**
	 * Gets the table name.
	 *
	 * @return the table name
	 */
	protected abstract String getTableName();

	/**
	 * Extract result set row.
	 *
	 * @param resultSet
	 *            the result set
	 * @return the t
	 */
	protected abstract T extractResultSetRow(ResultSet resultSet);

	/**
	 * Gets the primary key coloumn name.
	 *
	 * @return the primary key coloumn name
	 */
	protected abstract String getPrimaryKeyColoumnName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#findOne(java.io.Serializable)
	 */
	@Override
	public T findOne(final ID primaryKey) {
		Connection connection;
		try {
			connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM "
					+ getTableName() + " where " + getPrimaryKeyColoumnName()
					+ " = '" + primaryKey + "'");
			while (resultSet.next()) {
				return extractResultSetRow(resultSet);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#findAll()
	 */
	@Override
	public Iterable<T> findAll() {
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM "
					+ getTableName());
			List<T> productList = new ArrayList();
			while (resultSet.next()) {
				productList.add(extractResultSetRow(resultSet));
			}
			return productList;

		} catch (Exception e) {
			return Collections.emptyList();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#delete(java.lang.Object)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#exists(java.io.Serializable)
	 */
	@Override
	public boolean exists(final ID primaryKey) {
		// Check if primaryKey exist or not
		return false;
	}
}
