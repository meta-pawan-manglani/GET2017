/*
 * @author Pawan Manglani
 * @version 1.1 28-Aug-2017
 */
package com.metacube.controller;

import com.metacube.entity.Employee;
import com.metacube.enums.Status;
import com.metacube.facade.EmployeeFacade;

/**
 * The Class EmployeeController.
 */
public class EmployeeController {

	/** The ef. */
	private EmployeeFacade ef;

	/**
	 * Instantiates a new employee com.metacube.controller.
	 */
	public EmployeeController() {
		ef = EmployeeFacade.getInstance();
	}

	/**
	 * Check duplicate.
	 *
	 * @param e the e
	 * @return true, if successful
	 */
	public boolean checkDuplicate(Employee e) {
		boolean result = false;
		Status s = ef.checkDuplicate(e);
		if(s == Status.Duplicate) {
			result = true;
		}
		return result;
	}

	/**
	 * Adds the employee.
	 *
	 * @param e the e
	 * @return the status
	 */
	public Status addEmployee(Employee e) {
		return ef.addEmployee(e);
	}

	/**
	 * Prints the all employee.
	 *
	 * @return the string
	 */
	public String printAllEmployee() {
		return ef.printAllEmployee();
	}

	/**
	 * Sort on name.
	 */
	public void sortOnName() {
		ef.sortOnName();
	}

	/**
	 * Sort on id.
	 */
	public void sortOnId() {
		ef.sortOnId();
	}
}
