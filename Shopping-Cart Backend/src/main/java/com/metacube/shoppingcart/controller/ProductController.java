/**
 * @Date 02-October-2017
 * @author Pawan Manglani
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.shoppingcart.dto.CartDto;
import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.facade.CartFacade;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.facade.UserFacade;
import com.metacube.shoppingcart.model.Cart;

/**
 * The Class ProductController.
 */
@CrossOrigin
@Controller
@RequestMapping("/product")
public class ProductController {

	/** The product facade. */
	@Autowired
	ProductFacade productFacade;

	@Autowired
	UserFacade userFacade;

	@Autowired
	CartFacade cartFacade;
	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<ProductDto> getProducts() {
		return productFacade.getAllProducts();
	}

	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 */
	@RequestMapping(value = "/getOne/{id}")
	public @ResponseBody ProductDto getById(@PathVariable("id") int id) {
		return productFacade.getProductById(id);
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	@RequestMapping(value = "/delete/{id}")
	public @ResponseBody Boolean deleteById(@PathVariable("id") int id) {
		return productFacade.deleteById(id);
	}

	/**
	 * Save.
	 *
	 * @param product the product
	 * @return the product dto
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ProductDto save(@RequestBody ProductDto product) {
		return productFacade.save(product.getId(), product.getName(),
				product.getPrice());
	}

	/**
	 * Update by id.
	 *
	 * @param product the product
	 * @return the product dto
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ProductDto updateById(@RequestBody ProductDto product) {
		return productFacade.update(product.getId(), product.getName(),
				product.getPrice());
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getUser/{username}/{password}")
	public @ResponseBody Object getById(
			@PathVariable("username") String username,
			@PathVariable("password") String password) {
		UserDto user = userFacade.getUserById(username);
		System.out.println("i m called");
		System.out.println((user.getName()) + user.getPassword());
		if ((username.equals(user.getName()))
				&& (password.equals(user.getPassword()))) {
			JSONObject obj = new JSONObject();
			obj.put("authenticationFlag", true);
			obj.put("userId", user.getId());
			System.out.print(obj);
			return obj;
		} else {
			JSONObject obj = new JSONObject();
			obj.put("authenticationFlag", false);
			obj.put("userId", -1);
			System.out.print(obj);
			return obj;
		}
	}
	@RequestMapping(value = "/getAllCart/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<CartDto> getAllCartItems(
			@PathVariable("id") String id) {
		return cartFacade.getAll(id);
	}

	@RequestMapping(value = "/saveToCart", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Cart addtoCart(@RequestBody Cart cart) {
		return cartFacade.addToCart(cart.getPname(), cart.getPrice(),
				cart.getProductId(), cart.getUserId());
	}

}
