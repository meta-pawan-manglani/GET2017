package com.metacube.shoppingcart.dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.shoppingcart.dao.GenericJdbcDao;
import com.metacube.shoppingcart.modal.Product;

public class JdbcProductDao extends GenericJdbcDao<Product, Integer> implements ProductDao {

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "Product";
	}

	@Override
	protected Product extractResultSetRow(ResultSet resultSet) {
		// TODO Auto-generated method stub
		Product product = new Product();
		try {
			product.setName(resultSet.getString("name"));
			product.setId(resultSet.getInt("id"));
			product.setPrice(resultSet.getDouble("price"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	protected String getPrimaryKeyColoumnName() {
		// TODO Auto-generated method stub
		return "id";
	}


}
