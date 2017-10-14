package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;


/**
 * @author Pawan Manglani
 * @version 1.1 27-Sep-2017
 * 
 * The Class GenericJdbcDao.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public abstract class GenericJdbcDao<T, ID extends Serializable> implements AbstractDao<T,ID> {

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
	 * @param resultSet the result set
	 * @return the t
	 */
	protected abstract T extractResultSetRow(ResultSet resultSet);

	/**
	 * Gets the primary key column name.
	 *
	 * @return the primary key column name
	 */
	protected abstract String getPrimaryKeyColoumnName();

	/*
	 * 
	 * 
	 */
	public <S extends T> Status save(S entity) {
		Status result = Status.Success;
		Product product = (Product)entity;
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "INSERT INTO " + getTableName() + " (name,price)"+" VALUES ('" +product.getName() +"','"+ product.getPrice() + "');";
			/*throw new Exception("in save");*/
			stmt.executeUpdate(query);
		} catch(Exception e) {
			e.printStackTrace();
			result = Status.Error_Occured;
		}
		return result;
	}

	/* 
	 * 
	 * 
	 */
	public T findOne(ID primaryKey) {
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName() + " where " + getPrimaryKeyColoumnName() +" = '" + primaryKey + "'");
			while(resultSet.next()) {
				return extractResultSetRow(resultSet);
			}
			return null;
		} catch (Exception e) {
			//TODO - Logging
			System.out.println(e);
			return null;
		}
	}

	/* 
	 * 
	 * 
	 */
	public Iterable<T> findAll() {
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName());
			List<T> productList = new ArrayList<>();
			while(resultSet.next()) {
				productList.add(extractResultSetRow(resultSet));
			}
			return productList;

		} catch (Exception e) {
			//TODO - Logging
			return Collections.emptyList();
		}
	}

	/* 
	 * 
	 * 
	 */
	public Long count() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.dao.AbstractDao#delete(java.lang.Object)
	 */
	public Status delete(ID primaryKey) {
		Status result = Status.Success;
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "DELETE FROM " + getTableName() + " where " + getPrimaryKeyColoumnName() +" = '" + primaryKey + "'";
			stmt.executeUpdate(query);
		} catch(Exception e) {
			e.printStackTrace();
			result = Status.Error_Occured;
		}
		return result;
	}

	public Status edit(Product product,ID primaryKey) {
		Status result = Status.Success;
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "UPDATE " + getTableName() + " SET name = '"+ product.getName() + "' , price = " + product.getPrice()+" where " + getPrimaryKeyColoumnName() +" = " + primaryKey + " ;";
			stmt.executeUpdate(query);
		} catch(Exception e) {
			e.printStackTrace();
			result = Status.Error_Occured;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.dao.AbstractDao#exists(java.io.Serializable)
	 */
	public boolean exists(ID primaryKey) {
		return false;
	}

}
