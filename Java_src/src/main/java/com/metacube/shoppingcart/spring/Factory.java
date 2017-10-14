package com.metacube.shoppingcart.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class Factory.
 * 
 * @author Pawan Manglani
 * @version 1.1 28-Sep-2017
 */
public class Factory {
	
	/** The application context. */
	static ApplicationContext applicationContext;

	static {
		applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}

	/**
	 * Gets the application context.
	 *
	 * @return the application context
	 */
	static public ApplicationContext getApplicationContext()
	{
		return applicationContext;
	}
}
