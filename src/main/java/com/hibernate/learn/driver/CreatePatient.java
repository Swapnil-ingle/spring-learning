package com.hibernate.learn.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.learn.entity.Patient;

public class CreatePatient {

	public static void main(String[] args) {
		// Create session Factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Patient.class)
								.buildSessionFactory();
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {
			// Create a patient object
			Patient patient = new Patient("Ross", "Washington DC", "Illinois", 12345678, "Dr.Geller@NYU.com");
			
			// Start the transaction
			session.beginTransaction();
			
			// Save the object to DB
			session.save(patient);
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch (Exception e) {
			System.out.println("Something went wrong:");
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
