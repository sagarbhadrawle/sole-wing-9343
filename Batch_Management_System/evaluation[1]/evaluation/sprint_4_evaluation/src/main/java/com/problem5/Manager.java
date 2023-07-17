package com.problem5;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private LocalDate joiningDate;
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(
			name = "Manager_Project",joinColumns = @JoinColumn(name= "Manager_id"),inverseJoinColumns = @JoinColumn(name= "project_id"))
	private Set<Project> projects;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int id, String name, LocalDate joiningDate, Set<Project> projects) {
		super();
		this.id = id;
		this.name = name;
		this.joiningDate = joiningDate;
		this.projects = projects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	
	
	
}