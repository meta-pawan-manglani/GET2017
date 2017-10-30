package com.metacube.shoppingcart.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.shoppingcart.dao.cart.CartDao;
import com.metacube.shoppingcart.dto.CartDto;
import com.metacube.shoppingcart.model.Cart;
@Service("cartService")
@Transactional
public class DefaultCartService implements CartService {

	@Resource(name = "hibernateCartDao")
	CartDao cartDao;

	@Override
	public Iterable<CartDto> getAll(final String id) {
		return cartDao.getAll(id);
	}

	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	@Override
	public Cart addToCart(String pname, double price, int productId,
			String userId) {
		return cartDao.addToCart(pname, price, productId, userId);
	}

}
