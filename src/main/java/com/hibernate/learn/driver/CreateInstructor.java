package com.hibernate.learn.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.learn.entity.Instructor;
import com.hibernate.learn.entity.InstructorDetail;

public class CreateInstructor {

	public static void main(String[] args) {
		// Create session Factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {
			// Create a patient object
			Instructor instructor = new Instructor("Ross", "Washington DC", "Illinois", 12345678, "Dr.Geller@NYU.com");
			InstructorDetail instructorDetail = new InstructorDetail("youtube.com/RossDc", "Paleontology");
			
			// Associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			// Start the transaction
			session.beginTransaction();
			
			// Save the object to DB
			session.save(instructor);
			
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
