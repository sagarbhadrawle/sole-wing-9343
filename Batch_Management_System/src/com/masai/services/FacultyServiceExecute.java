package com.masai.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;
import com.masai.entity.Faculty;
import com.masai.exception.DuplicateEntryException;
import com.masai.exception.EmptyListException;
import com.masai.exception.WrongCredsException;

public class FacultyServiceExcecute implements FacultyServices {
	

	@Override
	public void signup(Faculty fac, Map<String, Faculty> faculty) throws DuplicateEntryException, FileNotFoundException, IOException {
// 	TODO Auto-generated method stub
		if (faculty.containsKey(fac.getFacId())) {
			throw new DuplicateEntryException("This with ID: "+fac.getFacId()+" is Already Registered, Register another Faculty");
		}
		else {
				faculty.put(fac.getFacId(), fac);
				System.out.println("Faculty has Successfully been SignedUp.. "+"\n"+"Here are Details ");
				System.out.println(fac);
				ObjectOutputStream facultySt = new ObjectOutputStream(new FileOutputStream("Faculty.ser"));
				facultySt.writeObject(faculty);
				facultyst.close();
			}
	}
		
		@Override
		public boolean login (String id, String name,String mail, String password, Map<String, Faculty> faculty) throws WrongCredsException{
		// TODO Auto-generated method stub
		if (faculty.containsKey(id)) {
			
		
			if (faculty.get(id).getPassword().equals(password)) {
				return true;
			}
			else {
				throw new WrongCredsException("You've Entered wrong credential! try Again");
			}
			
		}
		}
		
		
		@Override
		public void adminViewAllFac(Map<String, Faculty> faculty) throws EmptyListException {
		// TODO Auto-generated method stub
		if (faculty!=null && faculty.size()>0) {
			for (Map.Entry<String, Faculty> ent: faculty.entrySet() ) { 
				System.out.println(ent.getValue());
			}
		} else {
			throw new EmptyListException("Empty Faculty List, First Add Few Faculty...");
			}
		}
		
}	


	

