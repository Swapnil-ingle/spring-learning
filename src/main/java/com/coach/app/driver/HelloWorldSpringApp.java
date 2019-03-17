package com.coach.app.driver;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coach.app.coach.Coach;

public class HelloWorldSpringApp {

	public static void main(String[] args) {
		// load the spring configuration
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from the spring configuration
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
//		System.out.println(theCoach.getName());
//		System.out.println(theCoach.geteMailAddress());
		
		// close the context
		context.close();
	}

}
