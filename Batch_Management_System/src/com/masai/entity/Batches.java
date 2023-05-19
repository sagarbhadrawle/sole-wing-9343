package com.masai.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class Batches implements Serializable{

	private String id;
	private String courseName;
	private int noOfSeats;
	
	private String startDate;
	private int duration; 
	private String endDate;
	private String faculty;
	
	

	public Batches(String id , String courseName  , int noOfSeats  , String startDate , int duration) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.noOfSeats = noOfSeats;
		this.startDate = startDate;
		this.duration = duration;
		this.endDate = courseEndDate(startDate, duration);
	}
	public Batches() {
       super();		
	}
	
	public String courseEndDate(String startDate , int duration) {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	LocalDate ld = LocalDate.parse(startDate , dtf);
	
	LocalDate endD = ld.plus(duration , ChronoUnit.MONTHS);
	
	return endD+"";
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	
//	String st = (faculty!=null)?"Not assigned":faculty;
	@Override
	public String toString() {
		return "Batch [ id:-  " + id +" faculty:- " + faculty + " , courseName:- " + courseName + ", noOfSeats:- " + noOfSeats + ", startDate:- "
				+ startDate+ ", endDate:- " +endDate + ", duration:-" + duration   +  " ]";
	}
	
}
