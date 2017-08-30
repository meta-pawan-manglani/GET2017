package com.metacube.roomAllotment.entity;


/**
 * The Class Guest.
 * 
 * * @author Pawan Manglani
 * @version 1.1 25-Aug-2017
 */
public class Guest {

	/** The name. */
	private String name;

	/** The age. */
	private int age;
	
	/** The room. */
	private int room;
	
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Sets the age.
	 *
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Gets the room.
	 *
	 * @return the room
	 */
	public int getRoom() {
		return room;
	}
	
	/**
	 * Sets the room.
	 *
	 * @param room the room to set
	 */
	public void setRoom(int room) {
		this.room = room;
	}
	
	/**
	 * Set the details of guest.
	 *
	 * @param name the name
	 * @param age the age
	 */
	public void addDetails(String name,int age){
		this.name = name.toUpperCase().trim();
		this.age = age;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 17;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + room;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guest other = (Guest) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		return true;
	}
	
	/**
	 * String representation of Object.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Guest " + "name= " + name + ", age=  "  + age + ", room=  " + room ;
	}

}
