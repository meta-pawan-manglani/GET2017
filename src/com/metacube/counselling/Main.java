
package com.metacube.counselling;

import com.metacube.counselling.controller.CounsellingController;

/**
 * The Class Main.
 * 
 * @author Pawan Manglani
 * @version 1.1 22-Aug-2017
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		CounsellingController cl = new CounsellingController();
		cl.doAllotment();
	}
}
