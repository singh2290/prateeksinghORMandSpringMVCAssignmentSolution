package com.prateeksingh.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for each record of customer
 * @author prateeksingh
 *
 */
@Entity
@Table(name="customer")
public class Customer {

	/**
	 * Unique id of each record of customer
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/**
	 * First name of the customer
	 */
	@Column(name="first_name")
	private String firstName;
	
	/**
	 * Last name of the customer
	 */
	@Column(name="last_name")
	private String lastName;
	
	/**
	 * Email id of teh customer
	 */
	@Column(name="email")
	private String email;
	
	public Customer() {
		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	
	
}
