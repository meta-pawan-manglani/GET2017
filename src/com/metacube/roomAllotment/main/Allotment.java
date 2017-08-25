package com.metacube.roomAllotment.main;

import com.metacube.printProcess.io.Input;
import com.metacube.roomAllotment.controller.Controller;
import com.metacube.roomAllotment.entity.Guest;

/**
 *
 * @author Pawan Manglani
 * @version 1.1 25-Aug-2017
 */
public class Allotment {

    private static Controller cl;
    private static int remainingRooms;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Guest guest;
        cl = new Controller();
        int choice = Input.takeIntegerAsInput();
        while (true) {
            switch (choice) {
                case 1:
                    if (isFree()) {
                        guest = new Guest();
                        System.out.println("Enter total guests");
                        int num = Input.takeIntegerAsInput();
                        /*If number is less than the total rooms*/
                        if (num <= remainingRooms) {
                            for (int index = 0; index < num; index++) {
                                System.out.println("Enter name of guest " + (index + 1));
                                String name = Input.takeStringAsInput();
                                System.out.println("Enter age of guest " + (index + 1));
                                int age = Input.takeIntegerAsInput();
                                guest.addDetails(name, age);
                                /*Allot the rom to the object*/
                                cl.allotRoom(guest);
                            }
                        } else {
                            System.out.println("Rooms not available");
                        }
                    } else {
                        System.out.println("all are booked");
                    }
                    break;
                    /**Searching a particular guest*/
                case 2:
                    System.out.println("Enter age of guest");
                    int age = Input.takeIntegerAsInput();
                    System.out.println("Enter name of guest");
                    String name = Input.takeStringAsInput();
                    guest = cl.getGuest(name, age);
                    if (cl != null) {
                        System.out.println("\nName : " + guest.getName() + "\tAge : " + guest.getAge() + "\tRoomNo. : " + guest.getRoom());
                    } else {
                        System.out.println("Entry Not Found");
                    }
                    break;
                    /*Getting all information*/
                case 3:
                    String result = cl.getAllGuest();
                    System.out.println(result);
                    break;
                case 4:
                    Input.close();
                    System.exit(0);
                    break;
            }
        }
    }

    /**
     * Prints the menu.
     */
    public static void printMenu() {
        System.out.println("\n1. Add Guests");
        System.out.println("2. See Guest Information");
        System.out.println("3. See All Guest Information");
        System.out.println("4. Exit");
        System.out.println("enter your choice");
    }

    /**Is Free
     *
     * @return true if rooms are available
     */
    public static boolean isFree() {
        remainingRooms = cl.freeRooms();
        boolean answer = false;
        if (remainingRooms > 0) {
            answer = true;
        }
        return answer;
    }

}
