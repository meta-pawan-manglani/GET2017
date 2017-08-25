package com.metacube.printProcess.entity;


/**
 * The Class Task.
 
 * @author Pawan Manglani
 * @version 1.1 25-Aug-2017
 *
 */
public class Task implements Comparable<Task>{

	
	/** The designation. */
	private String designation;
	
	/** The priority. */
	private int priority;
	
	/** The message. */
	private String message;
	
	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	
	/**
	 * Sets the designation.
	 *
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	/**
	 * Gets the priority.
	 *
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
	
	/**
	 * Sets the priority.
	 *
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * Sets the message.
	 *
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}	
	/**
	 * Compare to method
	 * 
	 * Compare two object of task class
	 */
	@Override
	public int compareTo(Task arg0) {
		int result = 0;
		int priority1 = this.priority;
		int priority2 = arg0.priority;
		
		/*If priority of calling object is grater*/
		if(priority1<priority2){
			result = -1;
		}
		/*If priority of calling object is less than the other object*/
		else if(priority1>priority2){
			result = 1;
		}
		return result;
	}

}
