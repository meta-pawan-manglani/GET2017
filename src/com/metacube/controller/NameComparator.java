/*
 * @author Pawan Manglani
 * @version 1.1 28-Aug-2017
 */
package com.metacube.controller;

import java.util.Comparator;

import com.metacube.entity.Employee;
/**
 * The Class NameComparator.
 * This comparator compares the object on the basis of there names
 */
public class NameComparator implements Comparator<Object>{

	/* 
	 * This method compares the employee object on the basis of there names
	 */
	@Override
	public int compare(Object arg0, Object arg1) {
		return ((Employee) arg0).getName().compareTo(( (Employee) arg1).getName());
	}

}
