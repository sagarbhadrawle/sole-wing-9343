package com.problem5;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Main {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("sprint_4_eval");
	}
	 
	
	public static void insertData() {
		EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
        Manager naveen = new Manager("Naveen", LocalDate.of(2022, 1, 2));
        Manager dheeraj = new Manager("Dheeraj", LocalDate.of(2823, 81, 2));

      
        Project automation = new Project("Automation", 270);
        Project aiDrive = new Project("AIDrive", 480);
        Project roboCall = new Project("RoboCall", 171);

        naveen.addProject(automation);
        naveen.addProject(roboCall);
        dheeraj.addProject(aiDrive);
        dheeraj.addProject(automation);

        et.begin();
        em.persist(naveen);
        em.persist(dheeraj);

        et.commit();
    } catch (Exception ex) {
        if (et != null && et.isActive())
            et.rollback();
        System.out.println(ex.getMessage());
    } finally {
        em.close();
    }
    public static void displayProjectAndManagerDetails() {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Project> query = em.createQuery("SELECT p FROM Project p", Project.class);
            List<Project> projects = query.getResultList();

            for (Project project : projects) {
                System.out.println("Project Id: " + project.getId());
                System.out.println("Project Name: " + project.getName());
                System.out.println("Duration: " + project.getDuration());

                Set<Manager> managers = project.getManagers();

                for (Manager manager : managers) {
                    System.out.println("Manager Id: " + manager.getId());
                    System.out.println("Manager Name: " + manager.getName());
                    System.out.println("Joining Date: " + manager.getJoiningDate());
                }
            }
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        insertData();
        displayProjectAndManagerDetails();
        
    }
}