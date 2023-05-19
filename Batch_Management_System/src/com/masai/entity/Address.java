package com.masai.entity;

import java.io.Serializable;

public class Address implements Serializable{

	private String city;
	private String state;
	private String zipCode;
	private String landmark;
	public Address(String city, String state, String zipCode, String landmark) {
		super();
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.landmark = landmark;
	}
	
	public Address() {
		super();
	
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	@Override
	public String toString() {
		return "Address [city: " + city + ", state: " + state + ", zipCode: " + zipCode + ", landmark: " + landmark + "]";
	}
	
}
