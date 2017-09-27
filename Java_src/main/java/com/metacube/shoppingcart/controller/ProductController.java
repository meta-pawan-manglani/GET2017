package com.metacube.shoppingcart.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.metacube.shoppingcart.dao.product.JdbcProductDao;
import com.metacube.shoppingcart.facade.DefaultProductFacade;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.service.DefaultProductService;

/**
 * @author Pawan Manglani
 * @version 1.1 27-Sep-2017
 * 
 * The Class ProductController.
 * 
 * This class use is responsible to direct the service on right page
 */
@Path("/product")
public class ProductController {

	/** The product facade. */
	ProductFacade productFacade;

	/**
	 * Instantiates a new product controller.
	 */
	public ProductController() {
		productFacade = new DefaultProductFacade(new DefaultProductService(new JdbcProductDao()));
	}

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {

		return Response.status(Response.Status.OK).entity(productFacade.getAllProducts()).build();

	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductById(@PathParam("id") int id) {
		return Response.status(Response.Status.OK).entity(productFacade.getProductById(id)).build();
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProductById(@PathParam("id") int id){
		return Response.status(Response.Status.OK).entity(productFacade.deleteProduct(id)).build();
	}

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(Product product) {
		return Response.status(Response.Status.OK).entity(productFacade.addProduct(product)).build();
	}

	@PUT
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editProduct(Product product,@PathParam("id") int id) {
		return Response.status(Response.Status.OK).entity(productFacade.editProduct(product,id)).build();
	}

}
