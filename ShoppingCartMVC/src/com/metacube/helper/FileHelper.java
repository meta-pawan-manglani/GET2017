package com.metacube.helper;

import java.io.File;


/**
 * The Class FileHelper.
 * 
 * The helper class will provide the object to read the file
 * 
 * @author Pawan Manglani
 * @version 1.1 14-Aug-2017
 */
public class FileHelper {

	/** The file. object of File*/
	private File file;
	
	/**
	 * Instantiates a new file helper.
	 *
	 * @param fileName the file name
	 */
	public FileHelper(String fileName) {
		
	file =  new File(fileName);
	}
	
	/**
	 * Gets the file.
	 *
	 * @return the file object
	 */
	public File getFile(){
		return file;
	}
}
