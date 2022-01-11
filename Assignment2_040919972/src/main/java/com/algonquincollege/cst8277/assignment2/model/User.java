/**
 * File: User.java
 * Course materials (19F) CST 8277
 * @author (original) Mike Norman
 * 
 * @Author: Gloria Omoba 
 * @Student#: 040-919-972
 * @modified: 2019/10/10
 */
package com.algonquincollege.cst8277.assignment2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Description - This class represents the user model 
 * and implements serializables
 * @author omoba
 *
 */
@ManagedBean
@ViewScoped
@Entity
@Table(name = "users")
public class User implements Serializable {
    /** explicit set serialVersionUID */
    private static final long serialVersionUID = 1L;

    protected int id;
    // TODO - other member fields
    protected String firstName;
    protected String lastName;
    protected String emailAddress;
    protected String phoneNumber;

    /**
     *  default constructor 
     */
    public User() {
        super();
    }

    /**
     * get the user id
     * @return the value of Id
     */
    @Id // JPA will automatically generate the primary key based on IDENTITY column-type
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     * set the value of id
     * @param id - the new id value
     */
    public void setId(int id) {
        this.id = id;
    }

    // TODO - other getters/setters, mappings
    /**
     * get the user first name
     * @return the value of first name
     */
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * set the value of first name
     * @param firstName- new value of first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * get the user last name
     * @return the value of last name
     */
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * set the user last name
     * @param lastName - new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * get user email address
     * @return the value of email
     */
    @Column(name = "email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * set user email address
     * @param emailAddress - new value of email
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * get user phone number 
     * @return the value of phone number
     */
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * set user phone number 
     * @param emailAddress - new value of email
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * @returns a string of values contained 
     * in  class variables
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
                + emailAddress + ", phoneNumber=" + phoneNumber + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        return true;
    }
}