package com.coach.app.coach.impl;

import com.coach.app.coach.Coach;
import com.coach.app.service.FortuneService;

public class SwimCoach implements Coach {
private FortuneService fortuneSvc;
	
	public SwimCoach(FortuneService fortuneSvc) {
		this.fortuneSvc = fortuneSvc;
	}

	@Override
	public String getDailyWorkout() {
		return "Do a 200m freestyle dash";
	}

	@Override
	public String getDailyFortune() {
		return fortuneSvc.getFortune();
	}

}
