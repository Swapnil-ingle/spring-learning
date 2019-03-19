package com.coach.app.coach.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coach.app.coach.Coach;
import com.coach.app.service.FortuneService;

@Component
public class GymCoach implements Coach {
	@Autowired
	private FortuneService fortuneSvc;
	
	@Override
	public String getDailyWorkout() {
		return "Bench press 100Kgs";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneSvc.getFortune();
	}

}
