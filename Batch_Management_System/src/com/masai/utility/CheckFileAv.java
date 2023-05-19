package com.masai.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import com.masai.entity.Address;
import com.masai.entity.Batches;
import com.masai.entity.Faculty;

public class CheckFileAv {

	public static Map<String  , Faculty >  facultyFile(){
		
		Map<String , Faculty> facFile = null;
		File f = new File("Faculty.ser");
		boolean flag = false;
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag = true;
			}
			if(flag) {
				facFile = new LinkedHashMap<>(); 
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(facFile);
				return facFile;
			} else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				facFile = (Map<String , Faculty>) ois.readObject();
				return facFile;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return facFile;
	}
	
	public static Map<String ,  Batches > batchFile(){
		Map<String  , Batches> batchFile = null;
		File f = new File("BatchFile.ser");
		boolean flag = false;
		try {
		if(!f.exists()) {
			f.createNewFile();
			flag = true;
		}
		
		if(flag) {
			
			batchFile = new LinkedHashMap<>();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(batchFile);
			return batchFile;
		} else {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			batchFile = (Map<String, Batches>) ois.readObject();
			return batchFile;
		  }
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return batchFile;
		
	}
}
