/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.metacube.Facade.EmployeeFacade;
import com.metacube.entity.Employee;
import com.metacube.enums.Status;



/**
 * The Class EmployeeController.
 * 
 * Control the product related operations
 * 
 * @author Pawan Manglani
 * @version 1.1 14-Aug-2017
 */
@Path("/employee")
public class EmployeeController {


	/** The ef. object of product facade class */
	EmployeeFacade ef = EmployeeFacade.getInstance();

	Employee emp;

	/**
	 * Search product.
	 *
	 *This method search the product if it is present or not
	 *
	 * @param id the id
	 * @return the status
	 */


	@GET
	@Path("/getEmployee")
	@Produces(MediaType.TEXT_PLAIN)
	public String getEmployee(){
		String s = "";
		String array[] = ef.printEmployee();
		for(String temp : array){
			s += temp + "\n";
		}
		return s;
	}
	/**
	 * Prints the product.
	 * 
	 * This method print all the product to console
	 */
	@GET
	@Path("/searchEmployee/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String searchEmployee(@PathParam("id")String id){
		emp =  ef.searchEmployee(id);
		String answer="";
		if(emp==null){
			answer = Status.NOT_Found.toString();
		}
		else{
			answer = emp.toString();
		}
		
		return answer;
	}

	@POST
	@Path("/addEmp/{id},{name},{age}")
	@Produces({ MediaType.TEXT_PLAIN })
	public String addEmploy(@PathParam("id") String empNo,@PathParam("name") String name,@PathParam("age") String a) {
		String answer=Status.Error_Occured.toString();
		boolean flag = true;
		double age = 0;
		if(empNo.equalsIgnoreCase("null")){
			flag = false;
		}else if(name.equalsIgnoreCase(null)){
			flag = false;
		}else{
			try{
				age = Double.parseDouble(a);
			}catch(Exception e){
				flag = false;
			}
		}
		if(flag){
		emp = new Employee();
		emp.setName(name);
		emp.setId(empNo);
		emp.setAge(age);
		answer = ef.addEmployee(emp).toString();
	   }
		else{
			answer = Status.Wrong_Input.toString();
		}
		return answer;
	}

	@DELETE
	@Path("/delEmp/{id}")
	@Produces({  MediaType.TEXT_PLAIN })
	public String deleteEmploy(@PathParam("id") String empNo) {
		return ef.deleteEmployee(empNo).toString();
	}

}


