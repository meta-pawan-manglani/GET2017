package com.metacube.Facade;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.metacube.DAO.BaseDao;
import com.metacube.DAO.DAOFactory;
import com.metacube.entity.Employee;
import com.metacube.enums.DBType;
import com.metacube.enums.Status;
import com.metacube.io.WriteToFile;



/**
 * The Class EmployeeFacade.
 * 
 * @author Pawan Manglani
 * @version 1.1 18-Aug-2017
 */
public class EmployeeFacade{

	/** The employee map. binds the object of employee class to Employee id*/
	private Map<String,Employee> employeeMap ;

	/** The employee. object of Employee class */
	private Employee employee;

	/** The employee details. contains the list of all products */
	private List<Employee> employeeDetails;


	/** The pf.  reference of EmployeeFacade*/
	private static EmployeeFacade pf;



	/**
	 * Instantiates a new employee facade.
	 */
	private EmployeeFacade() {
		employeeMap = new HashMap<>();	
		getAllEmployee();
	}

	/**
	 * Gets the single instance of EmployeeFacade.
	 *
	 * @return single instance of EmployeeFacade
	 */
	public static EmployeeFacade getInstance(){
		/**Double locking mechanism to make a singleton object**/
		if(pf==null){
			synchronized(EmployeeFacade.class){
				if(pf==null){
					pf = new EmployeeFacade();
				}
			}
		}
		return pf;
	}

	/**
	 * Gets the all employee.
	 * @return A string which contains status of the operation
	 */
	public String getAllEmployee() throws IllegalArgumentException{
		
		String result = Status.Success.toString();
		try{
		/**Make a DAO object**/
		BaseDao bd = DAOFactory.getInstance(DBType.FileDao);
		/**call the get products method specified in DAO**/
		employeeDetails = bd.getAllEmployee();
		if(employeeDetails.size()==0){
			result = Status.Error_Occured.toString() + " While Reading The file Database";
		}
		else{
		 /**Iterator to iterate the employee list**/
		 Iterator<Employee> itr = employeeDetails.iterator();
		 while(itr.hasNext()){
			employee = itr.next();
			employeeMap.put(employee.getId(),employee);
		 }
		}

		}catch(Exception e){
			result = Status.Error_Occured.toString();
		}

		return result;
	}

	/*
	 *This method is used to print the employees
	 *
	 *@return String array containing all the products
	 */
	public String[] printEmployee(){
		/**Iterator to iterate the employee list**/
		String sar[] = new String[employeeDetails.size()+1];
		int index = 1;
		Iterator<Employee> itr = employeeDetails.iterator();
		sar[0] = "Employee Id\tEmployee Name\tEmployee Age";
		while(itr.hasNext()){
			employee = itr.next();
			sar[index] = employee.toString();
			index++;
		}
		return sar;
	}
	/**
	 * SearchEmployee.
	 *
	 *This method search employee by using it's Id
	 * @param id the id
	 * @return employee object
	 */
	public Employee searchEmployee(String id) {
		BaseDao dao =  DAOFactory.getInstance(DBType.FileDao);
		employee = (Employee)dao.searchEmployee(id);
		return employee;
	}

	/**
	 * This function writes  into the file when a new employee is added
	 * @param emp the employee id
	 */
	public void writeFile(Employee emp){
		WriteToFile.writeFile(emp);
	}

	/**
	 * This function writes  into the file when a employee is deleted
	 * @param employeeMap the map containing the employee object
	 */
	public void writeFile(Map<String,Employee> employeeMap){
		WriteToFile.writeFile(employeeMap);
	}
	/*
	 * This Method Add the employee in Employee File
	 * @param emp object of employee class
	 * @return Status return the status of operation
	 */
	public Status addEmployee(Employee emp){
		Status answer;
		try{
		if(employeeMap.containsKey(emp.getId())){
			answer = Status.Duplicate;
		}
		else{
			employeeMap.put(emp.getId(),emp);
			employeeDetails.add(emp);
			writeFile(emp);
			answer = Status.Success;
		}
		}catch(Exception e){
			answer = Status.Error_Occured;
		}
		return answer;
	}
	/*
	 * This Method Delete the employee from Employee File
	 * @param id of employee 
	 * @return Status return the status of operation
	 */
	public Status deleteEmployee(String id){
		
		Status answer;
		try{
		id = id.trim();
		if(employeeMap.containsKey(id)){
			employeeDetails.remove(employeeMap.get(id));
			employeeMap.remove(id);
			System.out.println(employeeMap.toString());
			writeFile(employeeMap);
			answer = Status.Success;
		}else{
			answer = Status.NOT_Found;
		}
	  }catch(Exception e){
		  answer = Status.Error_Occured;
	  }
		return answer;
	}

}
