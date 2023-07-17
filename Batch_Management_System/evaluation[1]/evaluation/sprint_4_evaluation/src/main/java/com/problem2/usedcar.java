package com.problem2;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "used_car")
public class usedcar {

	@Id
	private String registration_number;

	@Column(name = "company_name", length = 40, nullable = false)
	private String company_name;

	@Column(name = "model_name", length = 50, nullable = false)
	private String model_name;

	private int mfg_year;

	private double price;

	private int seating_capacity;

	public usedcar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public usedcar(String registration_number, String company_name, String model_name, int mfg_year, double price,
			int seating_capacity) {
		super();
		this.registration_number = registration_number;
		this.company_name = company_name;
		this.model_name = model_name;
		this.mfg_year = mfg_year;
		this.price = price;
		this.seating_capacity = seating_capacity;
	}

	public String getRegistration_number() {
		return registration_number;
	}

	public void setRegistration_number(String registration_number) {
		this.registration_number = registration_number;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public int getMfg_year() {
		return mfg_year;
	}

	public void setMfg_year(int mfg_year) {
		this.mfg_year = mfg_year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSeating_capacity() {
		return seating_capacity;
	}

	public void setSeating_capacity(int seating_capacity) {
		this.seating_capacity = seating_capacity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(registration_number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		usedcar other = (usedcar) obj;
		return Objects.equals(registration_number, other.registration_number);
	}

}