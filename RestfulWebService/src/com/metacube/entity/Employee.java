/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.entity;

import java.util.Objects;

/**
 * The Class Employee.
 * 
 * Employee Bean
 * 
 * @author Pawan Manglani
 * @version 1.1 14-Aug-2017
 */
public class Employee implements BaseEntity{

    /** The Id. */
    private String Id;
    
    /** The name. */
    private String name;
    
    /** The age. */
    private double age;

    /**
     * Instantiates a new employee.
     */
    public Employee() {

    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return Id;
    }

    /**
     * Sets the id.
     *
     * @param Id the new id
     */
    public void setId(String Id) {
        this.Id = Id;
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
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age.
     *
     * @return the age
     */
    public double getAge() {
        return age;
    }

    /**
     * Sets the age.
     *
     * @param age the new age
     */
    public void setAge(double age) {
        this.age = age;
    }

  /**Use to print Employee in string forma
     * @return t**/
    @Override
    public String toString() {
        return  ""+ name+ "\t\t"  + Id + "\t\t"  + age;
    }

    /**Override HashCode Metho
     * @return d**/
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.Id);
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.age) ^ (Double.doubleToLongBits(this.age) >>> 32));
        return hash;
    }

   /**For checking the equality of objec
     * @param obj
     * @return t**/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (Double.doubleToLongBits(this.age) != Double.doubleToLongBits(other.age)) {
            return false;
        }
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

}
