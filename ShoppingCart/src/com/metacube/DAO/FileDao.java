/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.metacube.entity.BaseEntity;
import com.metacube.entity.Product;
import com.metacube.helper.FileHelper;


/**
 * The Class FileDao.
 * 
 * This class will perform the operation regarding the file operation
 * 
 * @author Pawan Manglani
 * @version 1.1 14-Aug-2017
 */
public class FileDao implements BaseDao{

	/** The file. */
	private File file;
	
	/** The products. */
	private List<Product> products;
	
	/**
	 * Instantiates a new file dao.
	 */
	public FileDao() {
		file= new FileHelper("products.csv").getFile();
	}
	
	
	/**
	 *Read the product from file specified
	 *@return the list containing the object of product class
	 */
	@Override
	public List<Product> getAllProduct() {
		try{
			/**Making a list to storing the product **/
			products = new ArrayList<Product>();
			
			/**Opening the stream to read from file**/
			FileInputStream  fstream = new FileInputStream(file);
			
			BufferedReader sc= new BufferedReader(new InputStreamReader(fstream));
			
			/**A Utility string array**/
			String[] itemDetail;
			
			/**Object of product**/
			Product product;
			
			/**line denotes the line in file**/
			String line;
			while((line = sc.readLine())!=null){
				/**Spliting the detail using , as a delimiter**/
				itemDetail = line.split(",");
				product = new Product();
				
				product.setId(itemDetail[0]);
				product.setName(itemDetail[1]);
				product.setPrice(Double.parseDouble(itemDetail[2]));
				/**Adding the product in products list**/
				products.add(product);
			 }
			/**Closing the reader**/
			sc.close();
			}catch(NumberFormatException | IOException e ){
				System.out.println(e.getMessage());
			}
			/**returning the list**/
			return products;
	}





	/* (non-Javadoc)
	 * @see com.metacube.DAO.BaseDao#searchproduct(java.lang.String)
	 */
	@Override
	public BaseEntity searchproduct(String id) {
		// TODO Auto-generated method stub
		return null;
	}




	
	
}
