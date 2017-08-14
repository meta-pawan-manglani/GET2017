package com.metacube.Facade;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.metacube.DAO.BaseDao;
import com.metacube.DAO.DAOFactory;
import com.metacube.entity.Product;
import com.metacube.enums.DBType;
import com.metacube.enums.Status;

/**
 * The Class ProductFacade.
 * 
 * @author Pawan Manglani
 * @version 1.1 14-Aug-2017
 */
public class ProductFacade{

	/** The product map. binds the object of product class to Product id*/
	private Map<String,Product> productMap ;
	
	/** The product. object of Product class */
	private Product product;
	
	/** The product details. contains the list of all products */
	private List<Product> productDetails;

	
	/** The pf.  reference of ProductFacade*/
	private static ProductFacade pf;
	
	/**
	 * Instantiates a new product facade.
	 */
	private ProductFacade() {
		productMap = new HashMap<>();	
	}

	/**
	 * Gets the single instance of ProductFacade.
	 *
	 * @return single instance of ProductFacade
	 */
	public static ProductFacade getInstance(){
		/**Double locking mechanism to make a singleton object**/
		 if(pf==null){
	       synchronized(ProductFacade.class){
	    	   if(pf==null){
	    		   pf = new ProductFacade();
	    	   }
	       }
		 }
		return pf;
	}
	
	/**
	 * Gets the all product.
	 *
	 * @return the all product
	 */
	public void getAllProduct() {
		/**Make a DAO object**/
		BaseDao bd = DAOFactory.getInstance(DBType.FileDao);
		/**call the get products method specified in DAO**/
		productDetails = bd.getAllProduct();
		/**Iterator to iterate the product list**/
		Iterator<Product> itr = productDetails.iterator();
		while(itr.hasNext()){
			product = itr.next();
			/**Print the Product String**/
			System.out.println(product.toString());
			productMap.put(product.getId(),product);
		}
	
	}
	
	/**
	 * Searchproduct.
	 *
	 *This method search product by using it's Id
	 * @param id the id
	 * @return Found if successful else NOT_Found
	 */
	public Status searchproduct(String id) {
		if(productMap.containsKey(id)){
			return Status.Found;
		}
		return Status.NOT_Found;
		
	}
	
	/**
	 * Gets the product.
	 *
	 * @param id the id
	 * @return the product
	 * 
	 */
	public Product getProduct(String id){
		return productMap.get(id);
	}
	

}
