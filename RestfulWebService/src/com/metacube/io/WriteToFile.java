package com.metacube.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import com.metacube.entity.Employee;

public class WriteToFile { 
	private static Employee employee;
	public static void writeFile(Map<String,Employee> employeeDetail){
		try (
				FileWriter fw = new FileWriter("C:/Users/User22/workspace/RestfulWebService/employees.JSON",false);
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
	
	public static void writeFile(Employee employee ){
		try(
				FileWriter fw = new FileWriter("C:/Users/User22/workspace/RestfulWebService/employees.JSON",true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)){
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(employee);
			out.println(jsonInString);
		}catch(Exception e){
			
		}
				
	}

}