package com.venu;

import javax.persistence.Entity;

import org.mongodb.morphia.annotations.Embedded;

@org.mongodb.morphia.annotations.Entity
public class Address {

	public Address(){
		
	}
	
	private String streetName;
	private String zipCode;
	private String state;
	private String aptNumber;
	
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAptNumber() {
		return aptNumber;
	}
	public void setAptNumber(String aptNumber) {
		this.aptNumber = aptNumber;
	}
	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", zipCode=" + zipCode
				+ ", state=" + state + ", aptNumber=" + aptNumber + "]";
	}
	
	
}
