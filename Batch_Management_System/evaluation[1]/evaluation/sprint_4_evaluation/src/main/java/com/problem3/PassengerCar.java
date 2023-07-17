package com.problem3;



public class PassengerCar extends Vehicle {

	private int seating_capacity;
	private double groundClearance;
	
	public int getSeating_capacity() {
		return seating_capacity;
	}
	public void setSeating_capacity(int seating_capacity) {
		this.seating_capacity = seating_capacity;
	}
	public double getGroundClearance() {
		return groundClearance;
	}
	public void setGroundClearance(double groundClearance) {
		this.groundClearance = groundClearance;
	}
}