package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.dto.CartDto;
import com.metacube.shoppingcart.model.Cart;

public interface CartService {
	Iterable<CartDto> getAll(String id);

	Cart addToCart(String pname, double price, int productId, String userId);
}
