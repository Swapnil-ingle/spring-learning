package com.coach.app.coach.impl;

import com.coach.app.coach.Coach;

public class GymCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Bench press 100Kgs";
	}

}
