package com.coach.app.coach.impl;

import com.coach.app.coach.Coach;

public class SwimCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Do a 200m freestyle dash";
	}

}
