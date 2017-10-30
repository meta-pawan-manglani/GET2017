/**
 * @Date 02-October-2017
 * @author Pawan Manglani
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.shoppingcart.dto.CartDto;
import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Product;

/**
 * The Class HibernateDao.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public abstract class HibernateDao<T, ID extends Serializable> implements BaseDao<T, ID> {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory
	 *            the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** The model class. */
	private Class<T> modelClass;

	/**
	 * Gets the model class.
	 *
	 * @return the model class
	 */
	public Class<T> getModelClass() {
		return modelClass;
	}

	/**
	 * Instantiates a new hibernate dao.
	 *
	 * @param modelClass
	 *            the model class
	 */
	public HibernateDao(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#findAll()
	 */
	/*
	 * @see com.metacube.shoppingcart.dao.BaseDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<T> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		List<T> personsList = cr.list();
		return personsList;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.metacube.shoppingcart.dao.BaseDao#findOne(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findOne(final ID primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		cr = cr.add(Restrictions.eq("id", primaryKey));
		return (T) cr.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.metacube.shoppingcart.dao.BaseDao#exists(java.io.Serializable)
	 */
	@Override
	public boolean exists(final ID primaryKey) {

		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.metacube.shoppingcart.dao.BaseDao#delete(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean delete(final ID primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		boolean result = true;
		T product = (T) cr.add(Restrictions.eq("id", primaryKey));
		session.delete(product);
		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#save(int, java.lang.String,
	 * double)
	 */
	@Override
	public Product save(int id, String name, double price) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		session.save(product);
		return product;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#update(int, java.lang.String,
	 * double)
	 */
	@Override
	public Product update(int id, String name, double price) {
		Session session = this.sessionFactory.getCurrentSession();

		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		session.update(product);

		return product;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public T getOne(final String id) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		cr = cr.add(Restrictions.eq("cname", id));
		return (T) cr.uniqueResult();
	}

	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<CartDto> getAll(final String id) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		cr = cr.add(Restrictions.eq("userId", id));
		List<CartDto> productList = cr.list();
		return productList;
	}
	
	
	
	
	@Override
	public Cart addToCart(String pname, double price, int productId,
			String userId) {

		Session session = this.sessionFactory.getCurrentSession();
		Cart cart = new Cart();
		cart.setPname(pname);
		cart.setPrice(price);
		cart.setProductId(productId);
		cart.setUserId(userId);
		cart.setQuantity(1);

		session.save(cart);

		return cart;
	}
}
