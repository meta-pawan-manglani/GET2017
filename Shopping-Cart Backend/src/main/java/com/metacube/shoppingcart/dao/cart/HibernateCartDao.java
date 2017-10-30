package com.metacube.shoppingcart.dao.cart;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.HibernateDao;
import com.metacube.shoppingcart.model.Cart;

@Repository("hibernateCartDao")
public class HibernateCartDao extends HibernateDao<Cart, String>
		implements
			CartDao {
	public HibernateCartDao() {
		super(Cart.class);
	}
}
