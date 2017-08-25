package com.metacube.roomAllotment.entity;

public class Guest {
	
	private String name;
	
	private int age;
	private int room;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the room
	 */
	public int getRoom() {
		return room;
	}
	/**
	 * @param room the room to set
	 */
	public void setRoom(int room) {
		this.room = room;
	}
	/**Set the details of guest
	 * 
	 * @param name
	 * @param age
	 */
	public void addDetails(String name,int age){
		this.name = name;
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
  * String representation of Object
  * @return 
  */
    @Override
    public String toString() {
        return "Guest " + "name= " + name + ", age=  "  + age + ", room=  " + room ;
    }
	
}
