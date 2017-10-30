package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.dto.CartDto;
import com.metacube.shoppingcart.model.Cart;

public interface CartFacade {

	Iterable<CartDto> getAll(final String id);

	Cart addToCart(String pname, double price, int productId, String userId);

}
