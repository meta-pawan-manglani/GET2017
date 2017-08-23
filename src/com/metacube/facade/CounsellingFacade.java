
package com.metacube.facade;

import java.util.HashMap;
import java.util.Map;

import com.metacube.counselling.dao.FileDao;
import com.metacube.counselling.entity.Colleges;
import com.metacube.counselling.entity.Student;
import com.metacube.queue.CustomQueue;
import com.metacube.util.Utility;

/**
 * The Class CounsellingFacade.
 * 
 * @author Pawan Manglani
 * @version 1.1 22-Aug-2017
 */
public class CounsellingFacade {



	/** The student. */
	private CustomQueue<Student> student;


	/** The college. */
	private CustomQueue<Colleges> college;

	private Colleges c;

	/** The cf. */
	private static CounsellingFacade cf;


	/** The college details. */
	private Map<Integer,Colleges> collegeDetails;

	/** The result. */
	CustomQueue<String> result;

	/** The dao. */
	private FileDao fDao;

	/**
	 * Instantiates a new counselling facade.
	 */
	private CounsellingFacade() {
		fDao = new FileDao();
		result = new CustomQueue<>();
	}
	/**
	 * Gets the single instance of CounsellingFacade.
	 *
	 * @return single instance of CounsellingFacade
	 */
	public static CounsellingFacade getInstance(){
		/**Double locking mechanism to make a singleton object**/
		if(cf==null){
			synchronized(CounsellingFacade.class){
				if(cf==null){
					cf = new CounsellingFacade();
				}
			}
		}
		return cf;
	}

	/**
	 * Gets the all student.
	 *
	 * @return the all student
	 */
	public CustomQueue<Student> getAllStudent(){
		student = fDao.getAllStudent();
		/*A utility function to sort the data*/
		Utility.sort(student);
		return student;
	}

	/**
	 * Gets the all college.
	 *
	 * @return the all college
	 */
	public CustomQueue<Colleges> getAllCollege(){
		college = fDao.getAllColleges();
		return college;
	}

	/**This function store all the college details in a map corresponding to its rank as a key
	 * 
	 */
	public void getCollegeDetails(){
		collegeDetails = new HashMap<Integer,Colleges>();
		while(college.size()>0){
			c = college.dequeue();
			collegeDetails.put(c.getRank(),c);
		}
	}

	/**
	 * Allot seats.
	 *
	 * @return the queue containing allotment details
	 */
	public CustomQueue<String> allotSeats(){


		int totalSeats = Colleges.getTotal();
		int totalStudents = Student.getTotal();
		int[] choice;
		int seats = 0 , key = 0;
		getCollegeDetails();
		/*This loop runs till the seats or number of students is greater than zero*/
		while((student.size()>0) && (totalStudents>0) && (totalSeats>0)){
			Student s = student.dequeue();
			choice = s.getChoice();
			String allotment = null;
			/*This loop will allot the seats according to the user choice*/
			for(int index = 0 ; index<choice.length ; index++){
				key = choice[index];
				if(collegeDetails.containsKey(key)){
					c = collegeDetails.get(key);
					seats = c.getSeats();
					/*If number of seats in college is greater than the zero than allot one seat to student*/
					if(seats>0){
						/*allotment result*/
						allotment = "Student Name = " + s.getName() + "\t Alloted College = ";
						allotment += c.getName() +"\n";
						seats = seats - 1;
						c.setSeats(seats);
						result.enqueue(allotment);
						/*break the loop and give seat to another user*/
						break;
					}
				}
			}
		}
		return result;

	}

}
