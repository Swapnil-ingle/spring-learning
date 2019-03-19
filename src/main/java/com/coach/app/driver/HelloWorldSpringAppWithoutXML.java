package com.coach.app.driver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coach.app.coach.Coach;
import com.coach.app.coach.impl.SwimCoach;
import com.coach.app.spring.config.SportsConfig;

public class HelloWorldSpringAppWithoutXML {

	public static void main(String[] args) {
		// read the spring configuration class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);
		
		// retrieve bean from the spring configuration
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getName());
		System.out.println(theCoach.getEmail());
		
		// close the context
		context.close();
	}

}
