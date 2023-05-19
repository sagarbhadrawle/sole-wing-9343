package com.masai.entity;

import java.io.Serializable;

import com.masai.utility.GenerateFacID;

public class Faculty  extends Users implements Serializable{

	private String facId;
	public Faculty(String userName, String passWord, Address address, String email) {
		super(userName, passWord, address, email);
		this.facId = userName+GenerateFacID.generateID()+"";
	}
	public Faculty() {
		super();
	}
	public String getFacId() {
		return facId;
	}

	public void setFacId(String facId) {
		this.facId = facId;
	}

	@Override
	public String toString() {
		return "Faculty [Id:- " + facId + ", UserName:- " + getUserName() + ", PassWord:- " + getPassWord()
				+ ", Address:- " + getAddress() + ", Email:- " + getEmail() + "]";
	}

	
}
