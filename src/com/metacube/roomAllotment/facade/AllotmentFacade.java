package com.metacube.roomAllotment.facade;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.metacube.roomAllotment.entity.Guest;

/**
 * The Class AllotmentFacade.
 *
 * * @author Pawan Manglani
 * @version 1.1 25-Aug-2017
 */
public class AllotmentFacade {

    /**
     * The af.
     */
    private static volatile AllotmentFacade af;

    /**
     * The num.
     */
    private static int num = 1;

    /**
     * Gets the single instance of AllotmentFacade.
     *
     * @return single instance of AllotmentFacade
     */
    public static AllotmentFacade getInstance() {
        AllotmentFacade af = AllotmentFacade.af;
        if (af == null) {
            synchronized (AllotmentFacade.class) {
                if (af == null) {
                    AllotmentFacade.af = af = new AllotmentFacade();
                }
            }

        }

        return af;
    }

    /**
     * The info map.
     */
    private Map<Guest, Integer> infoMap;

    /**
     * The rooms.
     */
    private TreeMap<Integer, Boolean> rooms;

    /**
     * The Constant totalRooms.
     */
    private final static int totalRooms = 11;

    /**
     * Instantiates a new allotment facade.
     */
    public AllotmentFacade() {
        rooms = new TreeMap<Integer, Boolean>();
        infoMap = new HashMap<>();
        for (int index = 1; index <= totalRooms; index++) {
            rooms.put(index, true);
        }
    }

    /**
     * Allot rooms.
     *
     * @param guest the guest
     * @return the room Number
     */
    public int allotRooms(Guest guest) {
        int hash = guest.hashCode();
        hash = hash * num;
        num++;
        /**
         * Getting the room number
         */
        int roomNumber = hash % totalRooms;

        /**
         * If room is already full get another room which is free
         */
        if (!rooms.get(roomNumber)) {
            Set<Integer> set = rooms.keySet();
            Iterator<Integer> itr = set.iterator();
            /**
             * Check which room is free
             */
            while (itr.hasNext()) {
                roomNumber = itr.next();
                if (rooms.get(roomNumber)) {
                    break;
                }
            }
        }
        /**
         * Allot that room to guest
         */
        guest.setRoom(roomNumber);
        infoMap.put(guest, roomNumber);
        rooms.put(roomNumber, false);
        return roomNumber;
    }

    /**
     * The free room
     *
     * @return the number of free rooms
     */
    public int freeRooms() {
        int result = 0;
        Set<Integer> keys = rooms.keySet();
        Iterator<Integer> itr = keys.iterator();
        while (itr.hasNext()) {
            if (rooms.get(itr.next())) {
                result++;
            }
        }
        return result;
    }

    /**
     * Get all guest
     *
     * @return The string containing information of all guest
     */
    public String getAllGuest() {
        Set<Guest> keys = infoMap.keySet();
        Iterator<Guest> itr = keys.iterator();
        String allotment = "";
        while (itr.hasNext()) {
            allotment += itr.next().toString() + "\n";
        }
        return allotment;
    }

    /**
     * Get guest search for the guest
     *
     * @param guest
     * @return guest
     */
    public Guest getGuest(Guest guest) {
        Guest result = null;
        Guest temp;
        Set<Guest> keys = infoMap.keySet();
        Iterator<Guest> itr = keys.iterator();
        while (itr.hasNext()) {
            temp = itr.next();
            if (temp.equals(guest)) {
                result = temp;
                break;
            }
        }
        return result;
    }
}
