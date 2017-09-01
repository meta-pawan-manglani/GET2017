/*
 * @author Pawan Manglani
 * @version 1.1 28-Aug-2017
 */
package com.metacube.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.metacube.entity.Employee;
import com.metacube.facade.EmployeeFacade;
/**
 * The Class TestEmployeeFacade.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestEmployeeFacade {

	/** The ef. */
	private static EmployeeFacade ef;
	
	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ef = EmployeeFacade.getInstance();
		ef.addEmployee(new Employee(1, "shubham","Karol Bagh"));
		ef.addEmployee(new Employee(4, "pawan","RK Colony"));
		ef.addEmployee(new Employee(3, "rajat","RC Vyas Colony"));
		ef.addEmployee(new Employee(2, "gourav","Lajpat Nagar"));

	}

	
	/**
	 * Test add employee.
	 * @throws Exception 
	 */
	@Test
	public void testAddEmployee() throws Exception {
		Employee e = new Employee();
		int id = 5;
		String name = "pawan",address = "jpr";
		e.setId(id);
		e.setAddress(address);
		e.setName(name);
		String actual = ef.addEmployee(e).toString();
		String expected = "Added";
		assertEquals(expected,actual);
	}
	
	/**
	 * Test on duplicate id.
	 */
	@Test
	public void testOnDuplicateId() {
		Employee e = new Employee();
		int id = 1;
		e.setId(id);
		String actual = ef.checkDuplicate(e).toString();
		String expected = "Duplicate";
		assertEquals(expected,actual);
	}
	
	/**
	 * Test on names sort.
	 */
	@Test
	public void testOnNamesSort() {
		ef.sortOnName();
		String actual = ef.printAllEmployee();
		String expected = "name= GOURAV	 id=2	 address=LAJPAT NAGAR\n";
		expected += "name= PAWAN	 id=4	 address=RK COLONY\n";
		expected += "name= PAWAN	 id=5	 address=JPR\n";
		expected += "name= RAJAT	 id=3	 address=RC VYAS COLONY\n";
		expected += "name= SHUBHAM	 id=1	 address=KAROL BAGH\n";
		assertEquals(expected,actual);
	}
	
	/**
	 * Test sort by id.
	 */
	@Test
	public void testSortById() {
		ef.sortOnId();
		String actual = ef.printAllEmployee();
		String expected = "name= SHUBHAM	 id=1	 address=KAROL BAGH\n";
		expected += "name= GOURAV	 id=2	 address=LAJPAT NAGAR\n";
		expected += "name= RAJAT	 id=3	 address=RC VYAS COLONY\n";
		expected += "name= PAWAN	 id=4	 address=RK COLONY\n";
		expected += "name= PAWAN	 id=5	 address=JPR\n";
		assertEquals(expected,actual);
	}
	
	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ef = null;
	}


}
