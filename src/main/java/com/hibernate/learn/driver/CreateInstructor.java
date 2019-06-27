package com.hibernate.learn.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.learn.entity.Course;
import com.hibernate.learn.entity.Instructor;
import com.hibernate.learn.entity.InstructorDetail;

public class CreateInstructor {

	public static void main(String[] args) {
		// Create session Factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {
			/* createInstructorAndDetail(session); */
			/* addCourseAndDisplay(session); */
			addCoursesToInstructor(session);
			/* updatePatientUsingIdWithSave(session); */
		} catch (Exception e) {
			System.out.println("Something went wrong:");
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

	private static void addCoursesToInstructor(Session session) {
		// Start transaction
		session.beginTransaction();
		
		// Get instructor
		Instructor inst = session.get(Instructor.class, 1);
		System.out.println(inst);
		
		// Add courses
		Course course1 = new Course("The TimeMachine Course");
		Course course2 = new Course("The Pinball Masterclass");
		
		inst.add(course1);
		inst.add(course2);
		
		// Save the object to DB
		session.save(course1);
		session.save(course2);
		
		// Commit the transaction
		session.getTransaction().commit();
		
		System.out.println("Done!");
	}

	private static void updatePatientUsingIdWithSave(Session session) {
		// Create a patient object
		// Instructor instructor = new Instructor("Dr.Ross Geller", "Washington DC", "Illinois", 12345678, "Dr.Geller@NYU.com");
		// InstructorDetail instructorDetail = new InstructorDetail("youtube.com/Dr.RossDc", "Paleontology");
		
		// Start the transaction
		session.beginTransaction();
		
		// Get from Hibernate
		Instructor instructor = session.get(Instructor.class, 1);
		InstructorDetail instDetail = instructor.getInstructorDetail();
		instDetail.setHobby("Dinosaurs");
		
		// Associate the objects
		// instructor.setIdentifier(1);
		// instructor.setInstructorDetail(instDetail);
		
		// Save the object to DB
		// session.save(instructor);
		session.update(instructor);
		// session.persist(instructor);
		
		// Commit the transaction
		session.getTransaction().commit();
		
		System.out.println("Done!");
	}

	private static void addCourseAndDisplay(Session session) {
		// Start transaction
		session.beginTransaction();
		
		// Get instructor
		Instructor inst = session.get(Instructor.class, 1);
		System.out.println(inst);
		
		// Get courses
		System.out.println(inst.getCourses());
		
		// Add courses
		inst.add(new Course("The TimeMachine Course"));
		// Save the object to DB
		session.save(inst);
		// Commit the transaction
		session.getTransaction().commit();
		
		// Display the added courses
		System.out.println(inst.getCourses());
		
		System.out.println("Done!");
	}

	private static void createInstructorAndDetail(Session session) {
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
	}

}
