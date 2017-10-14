package com.metacube.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.enums.Status;

/**
 * The Class ProductController.
 *
 * @author Pawan Manglani
 * @version 1.1 27-Sep-2017
 * 
 * The Class ProductController.
 * 
 * This class use is responsible to direct the service on right page
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	/** The product facade. */
	/** The product facade. */
	@Autowired
	ProductFacade productFacade;


	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@RequestMapping(value="/list", produces ="application/json")
	public @ResponseBody Iterable<ProductDto> getProducts() {
		return productFacade.getAllProducts();

	}

	/**
	 * Gets the product by id.
	 *
	 * @param id the id
	 * @return the product by id
	 */
	@RequestMapping(value="/get/{id}" , produces="application/json")
	public @ResponseBody ProductDto getProductById(@PathVariable("id") int id) {
		ProductDto result = productFacade.getProductById(id);
		if(result == null) {
			result = new ProductDto();
		} 
		return result;
	}

	/**
	 * Delete product by id.
	 *
	 * @param id the id
	 * @return the response
	 */
	@RequestMapping(value="/delete/{id}" , produces="application/json")
	public @ResponseBody Status deleteProductById(@PathVariable("id") int id){
		return productFacade.deleteProduct(id);
	}

	
/*	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(Product product) {
		Response response;
		if(product!=null && product.getName() != null && product.getPrice()>=0) {
			product.setName(product.getName().trim().toUpperCase());
			response = Response.status(Response.Status.OK).entity(productFacade.addProduct(product)).build();
		} else {
			response = Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
		return response;
	}*/
	
	/**
	 * Adds the product.
	 *
	 * @param product the product
	 * @return the response
	 */
	@RequestMapping(value="/add")
	public @ResponseBody Status addProduct(@RequestBody Product product) {
		return productFacade.addProduct(product);
	}

	
	/*@PUT
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editProduct(Product product,@PathParam("id") int id) {
		return Response.status(Response.Status.OK).entity(productFacade.editProduct(product,id)).build();
	}*/
	
	/**
	 * Edits the product.
	 *
	 * @param product the product
	 * @param id the id
	 * @return the response
	 */
	@RequestMapping(value="/edit/{id}" , produces="application/json")
	public @ResponseBody Status editProduct( @RequestBody Product product,@PathVariable("id") int id) {
		return productFacade.editProduct(product,id);
	}
}
