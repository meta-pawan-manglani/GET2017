/*
 * @author Pawan Manglani
 * @version 1.1 28-Aug-2017
 */
package com.metacube.facade;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import com.metacube.controller.NameComparator;
import com.metacube.entity.Employee;
import com.metacube.enums.Status;
import com.metacube.io.Input;

/**
 * The Class EmployeeFacade.
 */
public class EmployeeFacade {

	/** The employee set. */
	private static TreeSet<Employee> employeeSet ;

	/** The employee list. */
	private static List<Employee> employeeList;

	/** The ef. */
	private static EmployeeFacade ef;

	/**
	 * Instantiates a new employee facade.
	 */
	private EmployeeFacade() {
		employeeSet = new TreeSet<>();
		employeeList = new LinkedList<>();
	}

	/**
	 * Gets the single instance of EmployeeFacade.
	 *
	 * @return single instance of EmployeeFacade
	 */
	public static EmployeeFacade getInstance() {
		if(ef==null) {
			synchronized(EmployeeFacade.class) {
				if(ef == null) {
					ef = new EmployeeFacade();
				}
			}
		}
		return ef;
	}

	/**
	 * Check duplicate.
	 *
	 * @param e the e
	 * @return the status Duplicate if id is duplicate else NOT_Found
	 */
	public Status checkDuplicate(Employee e) {
		Status s = Status.NOT_Found;
		try {
			if(employeeSet.contains(e)) {
				s = Status.Duplicate;
			}
		}catch(Exception ex) {
			s = Status.Error_Occured;
		}
		return s;
	}

	/**
	 * Adds the employee.
	 *
	 * @param e the e
	 * @return the status added if employee is added else Error
	 */
	public Status addEmployee(Employee e) {
		Status result = Status.Error_Occured;
		try {
			if(employeeSet.add(e)) {
				result = Status.Added;
				employeeList.add(e);
			}
		}catch(Exception ex) {
			result = Status.Error_Occured;
		}

		return result;
	}

	/**
	 * Prints the all employee.
	 *
	 * @return the string
	 */
	public String printAllEmployee() {
		String info = "";
		/*If size is greater than zero*/
		if(employeeList.size() > 0) {
			for(Employee e : employeeList) {
				info += e.toString() + "\n";
			}
		} else {
			/*else print list is empty*/
			info = "Databse Is Empty";
		}
		return info;
	}

	/**
	 * Sort on name.Sort employee on the base of there name
	 */
	public void sortOnName() {
		try {
			System.out.println(employeeList.size() + " here ");
			if(employeeList.size() > 0) {
				Collections.sort(employeeList,new NameComparator()); 
			}
		}catch(Exception e) {
			Input.print("Error Occured While Sorting " + e.getMessage());
		}
	}

	/**
	 * Sort on id.Sort employee on the base of there Id's
	 */
	public void sortOnId() {
		try {
			if(employeeList.size() > 0) {
				Collections.sort(employeeList); 
			}
		}catch(Exception e) {
			Input.print("Error Occured While Sorting " + e.getMessage());
		}
	}

}
