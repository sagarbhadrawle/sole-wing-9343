package com.masai.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Scanner;

import com.masai.entity.Batches;
import com.masai.entity.Faculty;
import com.masai.exceptions.DataNotFoundException;
import com.masai.exceptions.DuplicateEntryException;
import com.masai.exceptions.EmptyListException;

public class BatchServiceExecut implements BatchServices{

	@Override
	public String createNewBatch(Map<String , Batches> batches ,  Batches newBatch) throws DuplicateEntryException {
		if(!batches.containsKey(newBatch.getId())) {
			batches.put(newBatch.getId(), newBatch);
			ObjectOutputStream batchSt;
			try {
				batchSt = new ObjectOutputStream(new FileOutputStream("BatchFile.ser"));
				batchSt.writeObject(batches);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			throw new DuplicateEntryException("This Batch has already been created , create a new one");
		}
			
		// TODO Auto-generated method stub
		return "Batch with ID: "+newBatch.getId()+" has Successfully been Created";
	}

	@Override
	public void adViewAllBatches(Map<String , Batches> batches) throws EmptyListException {
		// TODO Auto-generated method stub
		if(!batches.isEmpty()) {
			for(Map.Entry<String, Batches> b : batches.entrySet()) {
				System.out.println(b);
			}
		}else {
			throw new  EmptyListException("Not Any Batches is present, first create one...");
		}
	}

	@Override
	public void deleteaBatch(String id , Map<String , Batches> batches) throws EmptyListException, DataNotFoundException{
		if(batches.size()==0) throw new EmptyListException("No Any Batches is present, first create one...");
		if(batches.containsKey(id)) {
			batches.remove(id);
		}else {
			throw new DataNotFoundException("Given id is not present in the database");
		}
		
	}

	@Override
	public Batches viewABatchById(String id, Map<String, Batches> batches) throws EmptyListException , DataNotFoundException {
		// TODO Auto-generated method stub
		if(batches.size()==0) throw new EmptyListException("No Any Batches is present, first create one...");
		if(batches.containsKey(id)) {
			Batches batch = batches.get(id);
//			System.out.println(batch);
			return batch;
		}else {
			throw new DataNotFoundException("Given id is not present in the database");
		}
	}

	@Override
	public void updateABatch(Scanner sc, String id, Map<String, Batches> batches) throws DataNotFoundException {
		// TODO Auto-generated method stub
		if(!batches.containsKey(id)) throw new DataNotFoundException("Entered Course ID is not present in the database"); 
		int opt = 0;
		do {
			System.out.println( "Press '1' -_-_-> to update Course Name ,"
		                        +"\n"+ 
					            "Press '2' -_-_-> to update Number of Seats,"
					            +"\n"+
					            "Press '3' -_-_-> to update Duration of the Course ,"
					            +"\n"+
					            "Press '4' -_-_-> to update Start date of the Course ,"
					            +"\n"+
					            "Press '0' -_-_-> to go back to previous menu...");
			 opt = sc.nextInt();
		switch(opt) {
		case 1 :
			updateName(sc , id , batches);
			break;
		case 2 :
			updateSeats(sc , id , batches);
			break;
		case 3 :
			updateDuration(sc , id , batches);
			break;
		case 4 :
			updateStartDate(sc , id , batches);
			break;	
		case 0 :
			System.out.println("Previous Menu...");
			break;
		}
	 }while(opt!=0);
	}
	
	public void updateSeats(Scanner sc , String id  , Map<String , Batches> batches) throws DataNotFoundException {
		if(batches.containsKey(id)) {
			Batches batch = batches.get(id);
			int oS = batch.getNoOfSeats();
			System.out.println("Enter the updated Strength of Course");
			int seats = sc.nextInt();
			 batch.setNoOfSeats(seats);
			 System.out.println("Strength of the Course of ID: "+batch.getId()+" Changed from: "+oS+" to " + seats);
			 ObjectOutputStream batchSt;
				try {
					batchSt = new ObjectOutputStream(new FileOutputStream("BatchFile.ser"));
					batchSt.writeObject(batches);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else {
			throw new DataNotFoundException("Entered Course ID is not present in the database");
		}
	}
    public void updateDuration(Scanner sc , String id  , Map<String , Batches> batches) throws DataNotFoundException {
    	if(batches.containsKey(id)) {
			Batches batch = batches.get(id);
			int oDur = batch.getDuration();
			System.out.println("Enter the updated Duration of Course");
			int newDur = sc.nextInt();
			 batch.setDuration(newDur);
			 System.out.println("Duration of the Course of ID: "+batch.getId()+" Changed from: "+oDur+" to " + newDur);
			 ObjectOutputStream batchSt;
				try {
					batchSt = new ObjectOutputStream(new FileOutputStream("BatchFile.ser"));
					batchSt.writeObject(batches);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else {
			throw new DataNotFoundException("Entered Course id is not present in the database");
		}
	}
    public void updateStartDate(Scanner sc , String id  , Map<String , Batches> batches) throws DataNotFoundException {
    	if(batches.containsKey(id)) {
			Batches batch = batches.get(id);
			String oD = batch.getStartDate();
			System.out.println("Enter the updated Start Date of Course");
			String newDate = sc.next();
			 batch.setStartDate(newDate);
			 System.out.println("Start Date of the Course of ID: "+batch.getId()+" Changed from: "+oD+" to " + newDate);
			 ObjectOutputStream batchSt;
				try {
					batchSt = new ObjectOutputStream(new FileOutputStream("BatchFile.ser"));
					batchSt.writeObject(batches);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else {
			throw new DataNotFoundException("Entered  Course id is not present in the database");
		}
    }
	public void updateName(Scanner sc , String id  , Map<String , Batches> batches) throws DataNotFoundException {
		
		if(batches.containsKey(id)) {
			Batches batch = batches.get(id);
			String oN = batch.getCourseName();
			System.out.println("Enter the Updated Name of Course");
			String newName = sc.next();
			 batch.setCourseName(newName);
			 System.out.println("Name of the Course of ID: "+batch.getId()+" Changed from:"+oN+" to..." + newName);
			 ObjectOutputStream batchSt;
				try {
					batchSt = new ObjectOutputStream(new FileOutputStream("BatchFile.ser"));
					batchSt.writeObject(batches);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else {
			throw new DataNotFoundException("Entered Course ID is not present in the database");
		}
		
	}

	@Override
	public void assignAFacultyToBactch(Scanner sc , Map<String, Batches> batches, Map<String, Faculty> faculty) throws DataNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println("Enter ID of the batch to which you want to assign a faculty...");
		String id = sc.next();
	if(batches.containsKey(id)) {
		Batches batch = batches.get(id);
		System.out.println("Enter ID of the Faculty to which course "+id+" is being assigned...");
		String asFac = sc.next();
		if(faculty.containsKey(asFac)){
			batch.setFaculty(asFac);
			ObjectOutputStream batchSt;
			try {
				batchSt = new ObjectOutputStream(new FileOutputStream("BatchFile.ser"));
				batchSt.writeObject(batches);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Course with ID"+batch.getId()+" is Successfully Assigned to "+asFac);
		}else {
			throw new DataNotFoundException("Entered Faculty ID is not present in the database...");
		}
//		System.out.println(batch);
	}else {
		throw new DataNotFoundException("Entered Course ID is not present in the database");
	}
		
		
	}
}
