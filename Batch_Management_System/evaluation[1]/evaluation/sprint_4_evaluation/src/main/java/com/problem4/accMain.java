package com.problem4;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class accMain {
static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("sprint_4_eval");
	}
	 

    public static void main(String[] args) {
    	
    }
}