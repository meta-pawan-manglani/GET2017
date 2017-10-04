package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;


/**
 * The Class GenericHibernateDao.
 *
 *@author Pawan Manglani
 *@version 1.1 4-OCT-2017
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public abstract class GenericHibernateDao<T, ID extends Serializable> implements AbstractDao<T,ID> {
	
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
	 * @param sessionFactory the new session factory
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
	public Class<T> getModelClass()
	{
		return modelClass;
	}

	/**
	 * Instantiates a new generic hibernate dao.
	 *
	 * @param modelClass the model class
	 */
	public GenericHibernateDao(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.dao.AbstractDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override public Iterable<T> findAll()
	{
		List<T> productList = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(getModelClass());
			productList = cr.list();

		
		}catch(Exception e) {
			productList = Collections.emptyList();
		}
		return productList;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.dao.AbstractDao#findOne(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	@Override public T findOne(final ID primaryKey)
	{
		Product product = null;
		try {
		Session session = this.sessionFactory.getCurrentSession(); 
		product = (Product)session.get(Product.class,primaryKey);
		}catch(Exception e) {
			System.out.println("Error occured while getting the detail of the products");
		}
		return  (T)product;
	}


	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.dao.AbstractDao#save(java.lang.Object)
	 */
	@Override public <S extends T> Status save(final S entity)
	{
		Status result = Status.Success;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			//getting transaction object from session object
			//session.beginTransaction();

			/*saving the product*/
			session.save(entity);
			System.out.println("Inserted Successfully");

			/*Committing the transaction*/
			//session.getTransaction().commit();
		}catch(Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.dao.AbstractDao#exists(java.io.Serializable)
	 */
	@Override public boolean exists(final ID primaryKey)
	{
		return false;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.dao.AbstractDao#delete(java.io.Serializable)
	 */
	@Override public Status delete(final ID primaryKey)
	{
		Status result = Status.Success;
		try {

			//getting transaction object from session object
			Session session = this.sessionFactory.getCurrentSession();

			/*begin transaction*/
		//	session.beginTransaction();

			/*loading the object using session*/
			Product product = (Product) session.get(Product.class,primaryKey);

			/*deleting the object*/
			session.delete(product);

			/*commit the changes*/
		//	session.getTransaction().commit();
		}catch(Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.dao.AbstractDao#edit(java.lang.Object, java.io.Serializable)
	 */
	@Override
	public <S extends T> Status edit(S entity, ID primaryKey) {
		// TODO Auto-generated method stub
		Status result = Status.Added;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			//session.beginTransaction();

			/*casting the entity into product*/
			Product update = (Product) entity;

			/*loading the object using session*/
			Product product = (Product) session.get(Product.class,primaryKey);

			/*updating the values*/
			product.setName(update.getName());
			product.setPrice(update.getPrice());
			session.update(product);
			

			/*commit the changes*/
			//session.getTransaction().commit();
		}catch(Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.dao.AbstractDao#count()
	 */
	@Override public Long count()
	{
		return null;
	}
}
