
package com.metacube.printProcess.controller;

import com.metacube.printProcess.entity.Task;
import com.metacube.printProcess.io.Input;
import com.metacube.printProcess.utility.Utility;
import com.metacube.queue.CustomQueue;


/**
 * The Class PrinterService.
 *  @author Pawan Manglani
 * @version 1.1 25-Aug-2017
 */
public class PrinterService {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	static private CustomQueue<Task> jobs = new CustomQueue<>();

	public static void main(String[] args) {
		Task job;
		while(true){
			/*Prints the menu*/
			Input.printMenu();
			/*take the user choice*/
			int choice = Input.takeIntegerAsInput();
			switch(choice){
			/*For assigning a task*/
			case 1:
				job = new Task();
				addTask(job);
				break;
				/*For completing the jobs*/
			case 2:	
				Utility.sort(jobs);
				/*Printing the jobs Completed*/
				while(jobs.size()>0){
					System.out.println(jobs.dequeue().getMessage());
				}
				System.out.println(" All jobs are completed ");
				break;
				/*In case of exit*/
			case 3:
				Input.close();
				System.exit(0);
				break;
			default:
				System.out.println("Please Enter a valid option");
			}

		}
	}

	/**
	 * Priority setter.
	 *
	 * @param desg the designation of Task Owner
	 * @return the int priority of task Owner
	 */
	private static int prioritySetter(String desg){
		int result = 0;
		desg = desg.toLowerCase();

		switch(desg){
		/*If designation is chairman*/
		case "chairman":
			result = 4;
			break;
			/*If designation is professor*/
		case "professor":
			result = 3;
			break;
			/*If designation is graduate*/	
		case "graduate":
			result = 2;
			break;
			/*If designation is undergraduate*/	
		case "undergraduates":
			result = 1;
			break;
			/*If not from any of these than assign 0*/
		default:
			result = 0;
		}
		return result;
	}	

	/**
	 * Method to assign a task to job queue
	 * @param job Object of task
	 */
	private static void addTask(Task job){
		String message = "" ,designation = "";
		System.out.println("Enter Designation");
		designation = Input.takeStringAsInput();
		System.out.println("Enter msg");
		message = Input.takeStringAsInput();
		job.setDesignation(designation);
		job.setMessage(message);
		job.setPriority(prioritySetter(designation));
		jobs.enqueue(job);
	}

}
