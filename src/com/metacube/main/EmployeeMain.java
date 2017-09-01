/*
 * @author Pawan Manglani
 * @version 1.1 28-Aug-2017
 */
package com.metacube.main;

import com.metacube.controller.EmployeeController;
import com.metacube.entity.Employee;
import com.metacube.io.Input;

/**
 * The Class EmployeeMain.
 */
public class EmployeeMain {

	/** The com.metacube.controller. */
	private static EmployeeController controller;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice = 0;
		/*Make an instance of com.metacube.controller and employee*/
		controller = new EmployeeController();
		Employee e;
		try {
			while(true) {
				/*Printing menu*/
				Input.printMenuForEmployee();
				/*Taking user choice*/
				choice = Input.takeIntegerAsInput("choice");
				switch(choice) {
				/*For adding an employee into database*/
				case 1:
					e = createEmployee();
					Input.print(controller.addEmployee(e).toString());
					break;
					/*For printing the list of employee*/
				case 2:
					Input.print(controller.printAllEmployee());
					break;
					/*sorting the list on the base of employee name*/
				case 3:
					controller.sortOnName();
					break;
					/*sorting the list on the base of employee id*/
				case 4:
					controller.sortOnId();
					break;
					/*For Exit*/
				case 5:
					Input.close();
					System.exit(0);
					break;
				default:
					Input.print("Please Enter a Valid Option");
				}
			}
		}catch(Exception ex) {
			Input.print(ex.getMessage());
		}

	}

	/**
	 * Creates the employee.
	 *
	 * @return the employee
	 */
	public static Employee createEmployee() {
		Employee employee = new Employee();
		String name="",address="";
		try {
			int id;
			while(true) {
				/*taking id of employee as input*/
				try {
					Input.print("Enter Id of employee");
					id = Input.takeIntegerAsInput("Id of Employee");
					employee.setId(id);
					/*Check if id is duplicate*/
					if(controller.checkDuplicate(employee)) {
						/*In case of duplicate id*/
						throw new Exception("Duplicate Id");
					}
					break;
				}catch(Exception e) {
					Input.print("Error " + e.getMessage());
				}
			}
			/*Take name of employee*/
			Input.print("Enter Name of Employee");
			name = Input.takeStringAsInput("Name of Employee");

			/*take address of employee*/
			Input.print("Enter City of Employee");
			address = Input.takeStringAsInput("City of Employee");

			/*set these parameters*/
			employee.setName(name);
			employee.setAddress(address);
		}catch(Exception e) {
			Input.print(e.getMessage());
		}
		/*return employee object*/
		return employee;
	}

}
