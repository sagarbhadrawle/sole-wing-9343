package com.masai.entity;

import java.io.Serializable;

public class Users implements Serializable{
	private String userName;
	private String passWord;
	private Address address;
	private String email;
	public Users() {
		super();
	}
	public Users(String userName, String passWord, Address address, String email) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.address = address;
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Users [userName: " + userName + ", passWord: " + passWord + ", address: " + address + ", email: " + email
				+ "]";
	}
}
