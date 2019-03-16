package com.coach.app.driver;

import com.coach.app.coach.Coach;
import com.coach.app.coach.impl.GymCoach;
import com.coach.app.coach.impl.SwimCoach;

public class AppDriver {
	public static void main(String[] args) {
		// Create object
		Coach theCoach = new SwimCoach();
		// Use object
		System.out.println(theCoach.getDailyWorkout());
	}
}
