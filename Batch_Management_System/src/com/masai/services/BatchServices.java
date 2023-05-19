package com.masai.services;

import java.util.Map;
import java.util.Scanner;

import com.masai.entity.Batches;
import com.masai.entity.Faculty;
import com.masai.exceptions.DataNotFoundException;
import com.masai.exceptions.DuplicateEntryException;
import com.masai.exceptions.EmptyListException;

public interface BatchServices {

	public String createNewBatch(Map<String , Batches> batches , Batches newBatch)throws DuplicateEntryException;
	
	public void adViewAllBatches(Map<String , Batches> batches)throws EmptyListException;
	
	public void deleteaBatch(String id , Map<String , Batches> batches) throws EmptyListException , DataNotFoundException;
	
	public Batches viewABatchById(String id , Map<String  , Batches> batches)throws DataNotFoundException,EmptyListException;

	public void updateABatch( Scanner sc ,String id , Map<String  , Batches> batches )throws DataNotFoundException;
	public void assignAFacultyToBactch(Scanner sc ,Map<String , Batches> batches , Map<String , Faculty> faculty)throws DataNotFoundException;
}
