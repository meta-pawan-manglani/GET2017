package com.metacube.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;

import com.metacube.entity.Employee;
import com.metacube.helper.FileHelper;


/**
 * The Class WriteToFile.This Class write into file database
 * 
 * @author Pawan Manglani
 * @version 1.1 18-Aug-2017
 */
public class WriteToFile { 

	/** The employee. */
	private static Employee employee;

	/** The file help. */
	static FileHelper fileHelp = new FileHelper("C:/Users/User22/workspace/RestfulWebService/employees.JSON"); 

	/** The file. */
	static File file = fileHelp.getFile();

	/**
	 * Write file.This function works only when any employee is deleted
	 *
	 * @param employeeDetail the employee detail
	 */
	public static void writeFile(Map<String,Employee> employeeDetail){
		/*try-with-resources It will close all the input output stream at the end */
		try (
				FileWriter fw = new FileWriter(file,false);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw))
				{
			ObjectMapper mapper = new ObjectMapper();
			Set<String> s = employeeDetail.keySet();
			for(String temp : s)
			{
				employee = employeeDetail.get(temp);
				String jsonInString = mapper.writeValueAsString(employee);
				out.println(jsonInString);
			}
				}catch (IOException e) {
					e.printStackTrace();

				}
	}

	/**
	 * Write file.This function works only when any employee is added in database
	 *
	 * @param employee the employee
	 */
	public static void writeFile(Employee employee ){
		
		/*try-with-resources It will close all the input output stream at the end */
		try(
				FileWriter fw = new FileWriter(file,true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw))
				{
					ObjectMapper mapper = new ObjectMapper();
					String jsonInString = mapper.writeValueAsString(employee);
					out.println(jsonInString);
				}catch(Exception e){

					System.out.println(e.getMessage());
				}
	}

}
