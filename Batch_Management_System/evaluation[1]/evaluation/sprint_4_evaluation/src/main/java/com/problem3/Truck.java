package com.problem3;

import jakarta.persistence.Entity;

@Entity
public class Truck extends Vehicle {
	private double loadingCapacity;

	public double getLoadingCapacity() {
		return loadingCapacity;
	}

	public void setLoadingCapacity(double loadingCapacity) {
		this.loadingCapacity = loadingCapacity;
	}
}
