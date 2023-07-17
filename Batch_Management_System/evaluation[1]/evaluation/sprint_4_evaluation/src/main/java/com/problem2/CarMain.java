package com.problem2;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CarMain {
	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("sprint_4_eval");
	}

	public static void addNewUsedCar() {
		usedcar c1 = new usedcar("RJ-14 MH 8596", "Hyundai", "Santro", 2010, 135000.00, 5);
		usedcar c2 = new usedcar("MH-14 YU 7435", "Hyundai", "i10", 2008, 145399, 5);
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(c1);
			em.persist(c2);
			et.commit();
		} catch (PersistenceException | IllegalStateException ex) {
			et.rollback();
			System.out.println(ex.getMessage());
		} finally {
			em.close();
		}
	}

	public static void printCarByResNumber() throws NoRecordFoundException {
		usedcar c = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			String selectOneQuery = "SELECT c From usedcar c WHERE c.registration_number Like :registration_number";
			Query query = em.createQuery(selectOneQuery);
			query.setParameter("registration_number", "RJ-14 MH 8596");
			c = (usedcar) query.getSingleResult();
			if (c == null) {
				throw new NoRecordFoundException("Please Enter valid car Rrgistration number");
			}
			System.out.println(c.getRegistration_number() + " " + c.getModel_name() + " " + c.getCompany_name() + " "
					+ c.getMfg_year() + " " + c.getSeating_capacity());
		} catch (IllegalArgumentException | IllegalStateException ex) {
			System.out.println(ex.getMessage());
		} finally {
			em.close();
		}
	}

	public static void findCarByYearAndPriceRange() {
		List<usedcar> carList;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			String selectCarByYearAndPriceRangeQuery = "SELECT c From usedcar c WHERE c.mfg_year Like :mfg_year AND c.price BETWEEN :startPrice AND :endPrice";
			Query query = em.createQuery(selectCarByYearAndPriceRangeQuery);
			query.setParameter("mfg_year", "2008");
			query.setParameter("startPrice", "3000000.00");
			query.setParameter("endPrice", "10000000.00");
			carList = query.getResultList();
			for (usedcar c : carList) {
				System.out.println(c.getRegistration_number() + " " + c.getModel_name() + " " + c.getCompany_name()
						+ " " + c.getMfg_year() + " " + c.getSeating_capacity());
			}
		} catch (IllegalArgumentException | IllegalStateException ex) {
			System.out.println(ex.getMessage());
		} finally {
			em.close();
		}
	}

	static void findCarByModelNameAndCompany() {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			String selectCarByModelNameAndCompanyQuery = "SELECT c From usedcar c WHERE c.model_name Like :model_name AND c.company_name Like :company_name";
			Query query = em.createQuery(selectCarByModelNameAndCompanyQuery);
			query.setParameter("model_name", "Santro");
			query.setParameter("company_name", "Hyundai");
			List<usedcar> carList = query.getResultList();
			for (usedcar c : carList) {
				System.out.println(c.getRegistration_number() + " " + c.getModel_name() + " " + c.getCompany_name()
						+ " " + c.getMfg_year() + " " + c.getSeating_capacity());
			}
		} catch (IllegalArgumentException | IllegalStateException ex) {
			System.out.println(ex.getMessage());
		} finally {
			em.close();
		}
	}

	public static void UpdateTheCar() {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			String UpdateQuery = "UPDATE usedcar SET company_name = :company_name, model_name = :model_name WHERE registration_number = :registration_number";
			Query query = em.createQuery(UpdateQuery);
			query.setParameter("company_name", "Toyota");
			query.setParameter("model_name", "Itios");
			query.setParameter("registration_number", "MH-14 YU 7435");
			et = em.getTransaction();
			et.begin();
			query.executeUpdate();
			et.commit();
		} catch (IllegalArgumentException | IllegalStateException | PersistenceException ex) {
			System.out.println(ex.getMessage());
		} finally {
			em.close();
		}
	}

	public static void DeleteAllCarsAccordingTOMfg_year() {

		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			String DeleteQuery = "DELETE FROM usedcar c WHERE c.mfg_year <= :mfg_year";
			Query query = em.createQuery(DeleteQuery);
			query.setParameter("mfg_year", "2008");
			et = em.getTransaction();
			et.begin();
			query.executeUpdate();
			et.commit();
		} catch (IllegalArgumentException | IllegalStateException | PersistenceException ex) {
			System.out.println(ex.getMessage());
		} finally {
			em.close();
		}
	}

	public static void main(String[] args) throws NoRecordFoundException {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {

			System.out.println("1. Create a new used car with details ");
			System.out.println("2. Print the information of any particular car by registration number");
			System.out.println("3. find Car By Year And Price Range");
			System.out.println("4. static void find Car By Model Name And Company");
			System.out.println(
					"5. Update the car by changing the company_name: Toyota, model_name: Itios for given registration_number");
			System.out.println("6. Delete all cars whose mfg_year is 2008 or before.");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				addNewUsedCar();
				break;
			case 2:
				printCarByResNumber();
				break;
			case 3:
				findCarByYearAndPriceRange();
				break;
			case 4:
				findCarByModelNameAndCompany();
			case 5:
				UpdateTheCar();
				break;
			case 6:
				DeleteAllCarsAccordingTOMfg_year();
				break;
			}
		} while (choice != 0);
	}
}