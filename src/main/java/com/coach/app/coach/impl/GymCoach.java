package com.coach.app.coach.impl;

import com.coach.app.coach.Coach;
import com.coach.app.service.FortuneService;

public class GymCoach implements Coach {
	private FortuneService fortuneSvc;
	
	public void setFortuneSvc(FortuneService fortuneSvc) {
		this.fortuneSvc = fortuneSvc;
	}

	@Override
	public String getDailyWorkout() {
		return "Bench press 100Kgs";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneSvc.getFortune();
	}

}
