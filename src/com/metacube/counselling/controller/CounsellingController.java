
package com.metacube.counselling.controller;

import com.metacube.counselling.entity.Colleges;
import com.metacube.counselling.entity.Student;
import com.metacube.facade.CounsellingFacade;
import com.metacube.queue.CustomQueue;

/**
 * The Class CounsellingController.
 * 
 *
 * @author Pawan Manglani
 * @version 1.1 22-Aug-2017
 */
public class CounsellingController {

	/** The students. */
	private CustomQueue<Student> students;

	/** The colleges. */
	private CustomQueue<Colleges> colleges;

	/** The result. */
	private CustomQueue<String> result;

	/** The council. */
	private CounsellingFacade council = CounsellingFacade.getInstance();

	/**
	 * Instantiates a new counselling controller.
	 */
	public CounsellingController() {
		getAllColleges();
		getAllStudents();
	}

	/**
	 * Gets the all colleges.
	 *
	 * @return the all colleges
	 */
	public void getAllColleges(){
		colleges = council.getAllCollege();
	}

	/**
	 * Gets the all students.
	 *
	 * @return the all students
	 */
	public void getAllStudents(){
		students = council.getAllStudent();
	}

	/**
	 * Do allotment.
	 * 
	 * Print the allotment result
	 */
	public void doAllotment(){
		result = council.allotSeats();
		while(result.size()>0){
			System.out.print(result.dequeue());
		}
	}

}
