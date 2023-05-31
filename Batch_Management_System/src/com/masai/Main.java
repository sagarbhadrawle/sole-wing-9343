package com.masai;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import com.masai.entity.Address;
import com.masai.entity.Batches;
import com.masai.entity.Faculty;
import com.masai.exceptions.DataNotFoundException;
import com.masai.exceptions.DuplicateEntryException;
import com.masai.exceptions.EmptyListException;
import com.masai.exceptions.InvalidArugumentException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.exceptions.WrongCredsException;
import com.masai.services.BatchServiceExecut;
import com.masai.services.BatchServices;
import com.masai.services.FacultyServiceExcecut;
import com.masai.services.FacultyServices;
import com.masai.utility.AdminCred;
import com.masai.utility.CheckFileAv;
//import com.masai.utility.GenerateFacID;

public class Main {

	//Admin Activity
	
	public static void adminActivity(Scanner sc,Map<String , Batches> batches , Map<String , Faculty> faculty) throws InvalidDetailsException, EmptyListException, InvalidArugumentException , DuplicateEntryException, DataNotFoundException {
//		System.out.println(batches);
		adminLoginMethod(sc);
		FacultyServices fac = new FacultyServiceExcecut();
		BatchServices batchS = new BatchServiceExecut();
		int opt = 0;
		
		do {
				System.out.println( "Press '1' -_-_-> to view all faculty"
		                            +"\n"+
						            "Press '2' -_-_-> to create new Course"
						            +"\n"+
						            "Press '3' -_-_-> to view all Course"
						            +"\n"+
						            "Press '4' -_-_-> to delete a Course"
						            +"\n"+
						            "Press '5' -_-_-> to view a particular Course"
						            +"\n"+
						            "Press '6' -_-_-> to Update a particular Course"
						            +"\n"+
						            "Press '7' -_-_-> to Assign a faculty to a Course"
						            +"\n"+
						            "Press '0' -_-_-> to Exit From Admin...");
				
				opt = sc.nextInt();
				switch(opt) {
				case 1 : 
					adminViewAllFaculties(faculty , fac);
					break;
				case 2 :
					adminCreateNewBatch(sc , batches , batchS);
					
					break;
				case 3 : 
					adminViewAllBatches(batches , batchS);
					break;
				case 4 : 
					deleteABatch(sc , batches , batchS);
					break;
				case 5 : 
					viewAPartBatch(sc , batches , batchS);
					break;	
				case 6 : 
					updateAPartBatch(sc , batches , batchS);
					break;	
				case 7 : 
					assignFaculty(sc ,faculty, batches , batchS);
					break;		
				case 0 :
					System.out.println("Successfully Existed from Admin...");
					break;
				default : 
					throw new InvalidArugumentException("Please Select a Valid one");
				}
				
		}while(opt!=0);
		
	}
	
	public static void adminViewAllFaculties(Map<String , Faculty> faculty , FacultyServices fac) throws EmptyListException {
		fac.adminViewAllFac(faculty);
	}
	public static void adminLoginMethod(Scanner sc ) throws InvalidDetailsException  {
		System.out.println("Enter Your UserName");
		String userName = sc.next();
		System.out.println("Enter Your PassWord");
		String pass = sc.next(); 
		
		if(userName.equals(AdminCred.users) && pass.equals(AdminCred.passD)) { 
			System.out.println("Admin SuccessFully Logged In.");
		} else {
			throw new InvalidDetailsException("Entered Credentials are not in place, Try Again...");
		  }
		}
	
	public static void adminCreateNewBatch(Scanner sc , Map<String , Batches> batches , BatchServices batchS) throws DuplicateEntryException {
	
		System.out.println("Enter Following Cred to Create a New Course");
		System.out.println("Enter a Unique ID :-");
		String id = sc.next();
		System.out.println("Enter Course Name :-");
		String courseName = sc.next();
		System.out.println("Enter Number of Seats for Course :- "+courseName);
		int noOfSeats = sc.nextInt();
		System.out.println("Enter a Start Date for Course :- "+courseName);
		String localDate = sc.next();
		System.out.println("Enter Duration for Course :- "+courseName);
		int duration = sc.nextInt();
		Batches newBatch = new Batches(id , courseName, noOfSeats, localDate , duration);
		
		System.out.println( batchS.createNewBatch( batches,newBatch));
		
	}
	public static void adminViewAllBatches(Map<String , Batches> batches ,BatchServices batchS) throws EmptyListException {
		
		batchS.adViewAllBatches(batches);
		
	}
	public static void deleteABatch(Scanner sc , Map<String , Batches> batches ,BatchServices batchS) throws EmptyListException, DataNotFoundException {
		System.out.println("Enter Id of the batch you want to delete");
		String id = sc.next();
		   batchS.deleteaBatch(id, batches);
		System.out.println("SuccessFully Deleted "+id+" batch from the System...");
	}
	
	public static void viewAPartBatch(Scanner sc  , Map<String , Batches> batches ,BatchServices batchS) throws DataNotFoundException, EmptyListException {
		System.out.println("Enter Id of the batch you want to See");
		String id = sc.next();
	Batches batch =	batchS.viewABatchById(id, batches);
	System.out.println(batch);
	}
	
	public static void updateAPartBatch(Scanner sc  , Map<String , Batches> batches ,BatchServices batchS)throws DataNotFoundException {
		System.out.println("Enter Id of the batch you want to Update");
		String id = sc.next();
		batchS.updateABatch(sc, id, batches);
	}
	
	public static void assignFaculty(Scanner sc ,Map<String , Faculty> faculty,  Map<String , Batches> batches ,BatchServices batchS )throws DataNotFoundException {
		batchS.assignAFacultyToBactch(sc, batches ,faculty);
	}
	
	
	
	
	
	public static void facultyActivity(Scanner sc  , Map<String , Faculty> faculty , Map<String , Batches> batches) throws WrongCredsException {
		// TODO Auto-generated method stub
		FacultyServices  facService = new FacultyServiceExcecut();
		System.out.println("Enter Following Details to LogIn to System...");
		System.out.println("Enter Your ID");
		String id = sc.next();
		System.out.println("Enter Your UserName");
		String name = sc.next();
		System.out.println("Enter Your Email");
		String email = sc.next();
		System.out.println("Enter Your Password");
		String pass = sc.next();
		facultyLogin(id , name , email, pass ,faculty ,facService);
	    System.out.println(" Faculty "+ name+" SuccessFully Logged In...");	
		
	}
	
	public static void facultyLogin(String id , String name , String email , String pass  , Map<String , Faculty> faculty , FacultyServices facService) throws WrongCredsException {
		facService.login(id,name, email , pass , faculty);
	}
	
	public static void facultySignup(Scanner sc , Map<String , Faculty> faculty ) throws DuplicateEntryException, FileNotFoundException, IOException {
		
		System.out.println("Enter Following details");
		System.out.println("Enter Your First Name (last name don't bother)");
		String userName = sc.next();
		System.out.println("Create a password");
		String password = sc.next();
		System.out.println("Enter Your City");
		String city = sc.next();
		System.out.println("Enter Your State");
		String state = sc.next();
		System.out.println("Enter Your ZipCode");
		String zip = sc.next();
		System.out.println("Enter a Landmark");
		String landmark = sc.next();
		Address address = new Address(city, state ,zip , landmark);
		System.out.println("Enter Your Email");
		String email = sc.next();
		Faculty fac = new Faculty(userName,password,address,email );
		
		FacultyServices facSer = new FacultyServiceExcecut();
		
		facSer.signUp(fac,faculty);
		
	}
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		Map<String , Batches> batches = CheckFileAv.batchFile();
		Map<String , Faculty> faculty = CheckFileAv.facultyFile();
//		System.out.println(batches);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Alpha Batch Management System");
		
		try {
			int pref = 0;
			do {
				System.out.println("Enter Your Preferences, What do you want ,"
			                        +"\n" + 
						            "Press '1' -_-_-> For Admin Login"
			                        +"\n" + 
						            "Press '2' -_-_-> For Faculty Login ,"
			                        +"\n" + 
						            "Press '3' -_-_-> For Faculty SignUp ," 
			                        +"\n" + 
						            "Press '0' -_-_-> For Existing the System. " + "\n");
				
				pref = sc.nextInt();
				
				switch(pref) {
				case 1 : adminActivity(sc,batches,faculty);
				break;
				case 2 : facultyActivity(sc , faculty , batches);
				break;
				case 3 : facultySignup(sc , faculty);
				break;
				case 0 : System.out.println("Successfully Existed from the System");
				break;
				default : throw new InvalidArugumentException("Please Select a Valid one");
				
				}
			}
			while(pref!=0);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
		  try {
				ObjectOutputStream batchSt = new ObjectOutputStream(new FileOutputStream("BatchFile.ser"));
				batchSt.writeObject(batches);
				ObjectOutputStream facultySt = new ObjectOutputStream(new FileOutputStream("Faculty.ser"));
				facultySt.writeObject(faculty);
				batchSt.close();
				facultySt.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
