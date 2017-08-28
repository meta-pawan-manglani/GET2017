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
		int num = af.freeRooms();
		return num;
	} 

	/**
	 * Allot room.
	 *
	 * @param guest the guest
	 * @return the int
	 */
	public int allotRoom(Guest guest) {
		return af.allotRooms(guest);
	}
	
	
	/**
	 * This method gives information of all guest
	 * @return
	 */
	public String getAllGuest(){
		String answer= af.getAllGuest();
		return answer;
	}
	
	/**
	 * This method search for particular guest entry
	 * @return
	 */
	public Guest getGuest(String name,int age){
		Guest guest = new Guest();
		name = name.trim().toUpperCase();
		guest.addDetails(name, age);
		return af.getGuest(guest);
	}

}
