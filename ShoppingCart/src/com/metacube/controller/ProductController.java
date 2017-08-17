/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.controller;

import com.metacube.Facade.ProductFacade;
import com.metacube.enums.Status;



/**
 * The Class ProductController.
 * 
 * Control the product related operations
 * 
 * @author Pawan Manglani
 * @version 1.1 14-Aug-2017
 */
public class ProductController {
	
	
	/** The pf. object of product facade class */
	ProductFacade pf;
	
	
	/**
	 * Instantiates a new product controller.
	 */
	public ProductController() {
		pf = ProductFacade.getInstance();
	}


	/**
	 * Search product.
	 *
	 *This method search the product if it is present or not
	 *
	 * @param id the id
	 * @return the status
	 */
	public Status searchProduct(String id){
		return pf.searchproduct(id);
	}
	
	
	/**
	 * Prints the product.
	 * 
	 * This method print all the product to console
	 */
	public void printProduct(){
			pf.getAllProduct();
			
	}
	
	
		
}


