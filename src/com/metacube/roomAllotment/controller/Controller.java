package com.metacube.roomAllotment.controller;

import com.metacube.roomAllotment.entity.Guest;
import com.metacube.roomAllotment.facade.AllotmentFacade;

/**
 * The Class Controller.
 * * @author Pawan Manglani
 * @version 1.1 25-Aug-2017
 */
public class Controller {

	/** The af. */
	private AllotmentFacade af; 

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		af = AllotmentFacade.getInstance();
	}



	/**
	 * Free rooms.
	 *
	 * @return the int
	 */
	public int freeRooms() {
		int num = 0;
		try {
			num = af.freeRooms(); 
		}catch(Exception e) {
			System.out.println("error in calculating free rooms" + e.getMessage());
		}
		return num;
	} 

	/**
	 * Allot room.
	 *
	 * @param guest the guest
	 * @return the int
	 */
	public void allotRoom(Guest guest) {
		af.allotRooms(guest);
	}


	/**
	 * This method gives information of all guest
	 * @return
	 */
	public String getAllGuest(){
		String answer = "";
		try {
			answer= af.getAllGuest();
		}catch(Exception e) {
			System.out.println("Error while getting all guest information "+ e.getMessage());
		}
		return answer;
	}

	/**
	 * This method search for particular guest entry
	 * @return
	 */
	public Guest getGuest(String name,int age){
		Guest guest = new Guest();
		try {
			name = name.trim().toUpperCase();
			guest.addDetails(name, age);
			guest =  af.getGuest(guest);
		}catch(Exception e) {
			System.out.println("Error while getting guest information "+ e.getMessage());
		}
		return guest;
	}

}
