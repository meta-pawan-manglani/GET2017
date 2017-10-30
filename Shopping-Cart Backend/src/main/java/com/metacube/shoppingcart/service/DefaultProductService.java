/**
 * @Date 02-October-2017
 * @author Pawan Manglani
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.metacube.shoppingcart.dao.product.ProductDao;
import com.metacube.shoppingcart.model.Product;

/**
 * The Class DefaultProductService.
 */
@Service("productService")
@Transactional
public class DefaultProductService implements ProductService {

	/** The product dao. */
	@Resource(name = "hibernateProductDao")
	ProductDao productDao;

	/**
	 * Gets the product dao.
	 *
	 * @return the product dao
	 */
	public ProductDao getProductDao() {
		return productDao;
	}

	/**
	 * Sets the product dao.
	 *
	 * @param productDao
	 *            the new product dao
	 */
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	/**
	 * Instantiates a new default product service.
	 */
	public DefaultProductService() {
	}

	/**
	 * Instantiates a new default product service.
	 *
	 * @param productDao
	 *            the product dao
	 */
	public DefaultProductService(ProductDao productDao) {
		this.productDao = productDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.service.ProductService#getAllProducts()
	 */
	@Override
	public Iterable<Product> getAllProducts() {
		return productDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.service.ProductService#getProductById(int)
	 */
	@Override
	public Product getProductById(int id) {
		return productDao.findOne(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.service.ProductService#deletetById(int)
	 */
	@Override
	public Boolean deletetById(int id) {
		return productDao.delete(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.service.ProductService#save(int,
	 * java.lang.String, double)
	 */
	@Override
	public Product save(int id, String name, double price) {

		return productDao.save(id, name, price);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.service.ProductService#update(int,
	 * java.lang.String, double)
	 */
	@Override
	public Product update(int id, String name, double price) {
		return productDao.update(id, name, price);
	}
}
