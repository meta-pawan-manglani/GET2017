/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template employeeFile, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.metacube.entity.Employee;
import com.metacube.helper.FileHelper;


/**
 * The Class FileDao.
 *
 * This class will perform the operation regarding the employeeFile operation
 *
 * @author Pawan Manglani
 * @version 1.1 18-Aug-2017
 */
public class FileDao  implements BaseDao {

    /**
     * The employeeFile.
     */
    private File employeeFile;

    /**
     * The employees.
     */
    private List<Employee> employees;

    /**
     * Instantiates a new employeeFile dao.
     */
    public FileDao() {
        employeeFile = new FileHelper("C:/Users/User22/workspace/RestfulWebService/employees.JSON").getFile();
    }

    /**
     * Read the product from employeeFile specified
     *
     * @return the list containing the object of product class
     */
    @Override
    public List<Employee> getAllEmployee() {
        try {
            /**
             * Making a list to storing the product *
             */
        	 employees = new ArrayList<Employee>();

            /**
             * Opening the stream to read from employeeFile*
             */
            FileInputStream fstream = new FileInputStream(employeeFile);

            BufferedReader sc = new BufferedReader(new InputStreamReader(fstream));

           
            /*
             * Making a parser to convert it to a Json object
             */
            JSONParser parser = new JSONParser();
           
            /**
             * Object of employee
             */
            Employee employee = null;

            /**
             * line denotes the line in employeeFile*
             */
            String line;
            while ((line = sc.readLine()) != null) {
                JSONObject js = (JSONObject)parser.parse(line);
                employee = new Employee();
                employee.setName((String)js.get("name"));
                employee.setAge((Double)js.get("age"));
                employee.setId((String)js.get("id"));
                employees.add(employee);
            }
            /**
             * Closing the reader*
             */
            sc.close();
        } catch (IOException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Halting the code");
            System.exit(1);
        } catch (ParseException e) {
			System.out.println("Error while parsing the Json Object");
		}
        /**
         * returning the list*
         */
        return employees;
    }

    /* (non-Javadoc)
	 * @see com.metacube.DAO.BaseDao#searchproduct(java.lang.String)
     */
    @Override
    public Employee searchEmployee(String id) {
        // TODO Auto-generated method stub
        Iterator<Employee> itr = employees.iterator();
        Employee e = null;
        boolean flag = false;
        while (itr.hasNext()) {
            e = itr.next();
            if (e.getId().equals(id)) {
                flag = true;
                break;
            }
        }
        if(!flag){
            e = null;
        }
        return e;
    }
   

}
