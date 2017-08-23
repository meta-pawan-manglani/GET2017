package com.metacube.counselling.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.metacube.counselling.entity.Colleges;
import com.metacube.counselling.entity.Student;
import com.metacube.queue.CustomQueue;

/**
 * The Class FileDao.
 *
 * This class will perform the operation regarding the studentFile operation
 *
 * @author Pawan Manglani
 * @version 1.1 22-Aug-2017
 */
public class FileDao {

	/**
	 * The studentFile.
	 */
	private File studentFile;

	private File collegeFile;

	/**
	 * The students.
	 */
	private CustomQueue<Student> students;


	private CustomQueue<Colleges> colleges;

	/**
	 * Instantiates a new studentFile dao.
	 */
	public FileDao() {
		studentFile = new File(Constants.STUDENT_FILE);
		collegeFile = new File(Constants.COLLEGE_FILE);
	}

	/**
	 * Read the student from studentFile specified
	 *
	 * @return the list containing the object of student class
	 */
	public CustomQueue<Student> getAllStudent() {

		BufferedReader sc = null;
		try {
			/**
			 * Making a queue to storing the student *
			 */
			students = new CustomQueue<Student>();

			/**
			 * Opening the stream to read from studentFile
			 */
			FileInputStream fstream = new FileInputStream(studentFile);

			sc  = new BufferedReader(new InputStreamReader(fstream));

			/**
			 * A Utility string array
			 */
			String[] itemDetail;

			/**
			 * Object of student
			 */
			Student student;

			/**
			 * line denotes the line in studentFile*
			 */
			String line;
			while ((line = sc.readLine()) != null) {
				/**
				 * splicing the detail using pipe operator (|) as a delimiter*
				 */
				if (!line.equals("")) {
					itemDetail = line.split("\\|");
					student = new Student();
					if (itemDetail.length < 3) {
						throw new IllegalArgumentException("File containing Student list have missing entry");
					} else {
						String name = itemDetail[0].trim();
						int rank = Integer.parseInt(itemDetail[1].trim());
						int length = colleges.size();
						int choice[] = new int[length];
						String choiceArr[] = itemDetail[2].split(",");
						for(int i=0 ; i<length ; i++){
							choice[i] = Integer.parseInt(choiceArr[i].trim());
						}
						student.addStudentDetail(name,rank,choice);
						students.enqueue(student);
					}
				}
				if(students.size()==0){
					throw new IllegalArgumentException("File containing Student list is empty");
				}
			}

		} catch (IOException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println("Halting the code");
			System.exit(1);
		}finally{
			/**
			 * Closing the reader
			 */
			try {
				sc.close();
			} catch (IOException e) {

			}
		}
		/**
		 * returning the queue
		 */
		return students;
	}

	/**
	 * Read the college from collegeFile specified in constants File
	 *
	 * @return the queue containing the object of college class
	 */
	public CustomQueue<Colleges> getAllColleges() {

		BufferedReader sc = null;
		try {
			/**
			 * Making a queue to storing the colleges *
			 */
			colleges = new CustomQueue<>();

			/**
			 * Opening the stream to read from collegeFile
			 * 
			 */
			FileInputStream fstream = new FileInputStream(collegeFile);

			sc = new BufferedReader(new InputStreamReader(fstream));

			/**
			 * A Utility string array
			 */
			String[] itemDetail;

			/**
			 * Object of college
			 */
			Colleges college;

			/**
			 * line denotes the line in collegeFile
			 */
			String line;
			while ((line = sc.readLine()) != null) {
				/**
				 * splicing the detail using pipe operator (|) as a delimiter
				 */
				if (!line.equals("")) {
					itemDetail = line.split("\\|");
					college = new Colleges();
					if (itemDetail.length < 3) {
						throw new IllegalArgumentException("File containing college list have missing entry");
					} else {
						String name = itemDetail[0].trim();
						int rank = Integer.parseInt(itemDetail[1].trim());
						int seats = Integer.parseInt(itemDetail[2].trim());
						college.addCollegeDetail(name, rank, seats);
						colleges.enqueue(college);
					}
				}
				if(colleges.size()==0){
					throw new IllegalArgumentException("File containing college list is empty");
				}
			}

		} catch (IOException | IllegalArgumentException e) {
			System.out.println("Error in File containing college details");
			System.out.println(e.getMessage());
			System.out.println("Halting the code");
			System.exit(1);
		}finally{
			/**
			 * Closing the reader*
			 */
			try {
				sc.close();
			} catch (IOException e) {
			}
		}
		/**
		 * returning the queue*
		 */
		return colleges;
	}
}
