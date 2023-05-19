package com.masai.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.masai.entity.Faculty;
import com.masai.exceptions.DuplicateEntryException;
import com.masai.exceptions.EmptyListException;
import com.masai.exceptions.WrongCredsException;

public interface FacultyServices {

	public boolean login(String id , String name ,String mail , String password, Map<String, Faculty> faculty) throws WrongCredsException;
	
	public void signUp(Faculty fac , Map<String , Faculty> faculty) throws DuplicateEntryException,FileNotFoundException, IOException;
	
	public void adminViewAllFac(Map<String , Faculty> faculty) throws EmptyListException;
}