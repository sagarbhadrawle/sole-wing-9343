package com.masai.exceptions;

public class WrongCredsException extends Exception{

	public WrongCredsException(String msg){
		super(msg);
	}
	public WrongCredsException() {
		super("wrong Creds");
	}
}
