/*
 * @author Pawan Manglani
 * @version 1.1 28-Aug-2017
 */
package com.metacube.entity;
// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
public class Employee implements Comparable<Employee>{

	/** The name. */
	String name;

	/** The id. */
	int id;

	/** The address. */
	String address;

	/**
	 * Instantiates a new employee.
	 */
	public Employee() {

	}

	/**
	 * Instantiates a new employee.
	 *
	 * @param name the name
	 * @param id the id
	 * @param address the address
	 */
	public Employee(int id, String name, String address) {
		this.name = name.trim().toUpperCase();
		this.id = id;
		this.address = address;
	}

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
		this.name = name.trim().toUpperCase();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "name= " + name + "\t id=" + id + "\t address=" + address;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Employee arg0) {
		int result = 0;
		if(this.id < arg0.id) {
			result = -1;
		} else if(this.id > arg0.id){
			result = 1;
		}
		return result;
	}
}
