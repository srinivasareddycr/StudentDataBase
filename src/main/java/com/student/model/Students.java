package com.student.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Students {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private  int id ;
	private  String firstName;
	private String LastName;
	private String standard;
	private Date dob;
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
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Students(int id, String firstName, String lastName, String standard, Date dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		LastName = lastName;
		this.standard = standard;
		this.dob = dob;
	}
	public Students() {
		super();
	}

	
	
	

}
