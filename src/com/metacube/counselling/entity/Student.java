package com.metacube.counselling.entity;

import java.util.Arrays;

/**
 * The Class Student.
 * 
 * @author Pawan Manglani
 * @version 1.1 22-Aug-2017
 */
public class Student implements Comparable<Object>{

	/** The choice. */
	private int choice[];

	/** The name. */
	private String name;

	/** The rank. */
	private int rank;

	/**
	 * Instantiates a new student.
	 *
	 * 
	 */
	public Student(){
	}
	/**
	 * The total
	 */
	private static int total = 0;
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the rank.
	 *
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Sets the rank.
	 *
	 * @param rank the new rank
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * Gets the choice.
	 *
	 * @return the choice
	 */
	public int[] getChoice() {
		return choice;
	}


	/**
	 * Sets the choice.
	 *
	 * @param choice the new choice
	 */
	public void setChoice(int[] choice) {
		this.choice = choice;
	}

	/**
	 * Adds the student detail.
	 *
	 * @param choice the choice
	 * @param name the name
	 * @param rank the rank
	 */
	public void addStudentDetail(String name,int rank,int choice[]){
		this.setName(name);
		this.setRank(rank);
		this.setChoice(choice);
		total++;
	}


	/**
	 * String representation of Student
	 */
	@Override
	public String toString() {
		return "Student [choice=" + Arrays.toString(choice) + ", name=" + name
				+ ", rank=" + rank + "]";
	}

	/**Compare to
	 * 
	 * This function compares the student object
	 */
	@Override
	public int compareTo(Object arg0) {
		Student s = (Student)arg0;
		int result = 0;
		if(this.getRank() < s.getRank()){
			result = -1;
		}
		else if(this.getRank() > s.getRank()){
			result = 1;
		}
		return result;
	}
	/**Get total
	 * 
	 * @return the total number of students
	 */
	public static int getTotal(){
		return total;
	}
}
