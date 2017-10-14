package com.metacube.shoppingcart.dao.product;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.GenericHibernateDao;

import com.metacube.shoppingcart.modal.Product;



@Repository("hibernateProductDao")
public class HibernateProductDao extends GenericHibernateDao<Product, Integer> implements ProductDao{

	public HibernateProductDao() {
		super(Product.class);
	}

}
