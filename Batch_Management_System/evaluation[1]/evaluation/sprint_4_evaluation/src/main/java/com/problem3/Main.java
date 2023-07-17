package com.problem3;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("sprint_4_eval");
	}
	
	public static void insertRecords() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            Truck truck1 = new Truck();
            truck1.setBrand("Tata");
            truck1.setModel("Ace");
            truck1.setPrice(3400000);
            truck1.setLoadingCapacity(45);
            em.persist(truck1);

            Truck truck2 = new Truck();
            truck2.setBrand("Tata");
            truck2.setModel("Magic");
            truck2.setPrice(2158955);
            truck2.setLoadingCapacity(25);
            em.persist(truck2);

            Truck truck3 = new Truck();
            truck3.setBrand("Ashoka");
            truck3.setModel("A4875");
            truck3.setPrice(3192500);
            truck3.setLoadingCapacity(38);
            em.persist(truck3);

            PassengerCar car1 = new PassengerCar();
            car1.setBrand("Toyota");
            car1.setModel("Itios");
            car1.setPrice(785000);
            car1.setSeating_capacity(5);
            car1.setGroundClearance(15);
            em.persist(car1);

            PassengerCar car2 = new PassengerCar();
            car2.setBrand("Suzuki");
            car2.setModel("Brezza");
            car2.setPrice(1025499);
            car2.setSeating_capacity(5);
            car2.setGroundClearance(18);
            em.persist(car2);

            PassengerCar car3 = new PassengerCar();
            car3.setBrand("Toyota");
            car3.setModel("Innova");
            car3.setPrice(2195625);
            car3.setSeating_capacity(8);
            car3.setGroundClearance(17);
            em.persist(car3);

            et.commit();
        } catch (Exception ex) {
            et.rollback();
            System.out.println(ex.getMessage());
        } finally {
            em.close();
        }
    }
	
	public static void displayVehicles() {
        EntityManager em = emf.createEntityManager();

        try {
            String queryStr = "SELECT v.brand, v.model, v.price FROM Vehicle v " +
                    "WHERE v.seatingCapacity > 6 OR v.loadingCapacity < 50";
            Query query = em.createQuery(queryStr);
            List<Vehicle> results = query.getResultList();
            for(Vehicle v  : results) {
            	System.out.println("Brand :"+ v.getBrand()+ "Model :" + v.getModel()+"Price :"+ v.getPrice());
            }
            
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
        } finally {
            em.close();
        }
    }

    public static void displayGroundClearanceAndPrice() {
        EntityManager em = emf.createEntityManager();

        try {
            String queryStr = "SELECT v.id, v.brand, v.model, v.groundClearance FROM Vehicle v " +
                    "WHERE v.groundClearance < 20 AND v.price BETWEEN 750000 AND 3950000";
            Query query = em.createQuery(queryStr);
            List<Object[]> results = query.getResultList();

            System.out.println("Vehicles with ground clearance < 20 and price between 750000 and 3950000:");
            for (Object[] result : results) {
                int id = (int) result[0];
                String brand = (String) result[1];
                String model = (String) result[2];
                double groundClearance = (double) result[3];
                System.out.println("ID: " + id + ", Brand: " + brand + ", Model: " +
                        model + ", Ground Clearance: " + groundClearance);
            }
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
        } finally {
            em.close();
        }
    }

    public static void displayBrandStatistics() {
        EntityManager em = emf.createEntityManager();

        try {
            String queryStr = "SELECT v.brand, COUNT(v), MAX(v.price) " +
                    "FROM Vehicle v GROUP BY v.brand HAVING COUNT(v) >= 2 " +
                    "ORDER BY v.brand DESC";
            Query query = em.createQuery(queryStr);
            query.setMaxResults(2);
            List<Object[]> results = query.getResultList();

            System.out.println("Brand Statistics (with at least 2 vehicles):");
            for (Object[] result : results) {
                String brand = (String) result[0];
                long count = (long) result[1];
                double maxPrice = (double) result[2];
                System.out.println("Brand: " + brand + ", Total Vehicles: " +
                        count + ", Costliest Vehicle Price: " + maxPrice);
            }
        } catch (Exception ex ) {
            System.out.println(ex.getMessage());
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        insertRecords();
        displayVehicles();
        displayGroundClearanceAndPrice();
        displayBrandStatistics();
    }
}
