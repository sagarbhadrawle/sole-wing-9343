package com.masai.exceptions;

public class DuplicateEntryException extends Exception{

	public DuplicateEntryException(String msg) {
		super(msg);
	}
	public DuplicateEntryException() {
		super("Dupicate");
	}
}
