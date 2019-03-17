package com.coach.app.coach.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coach.app.coach.Coach;
import com.coach.app.service.FortuneService;

@Component
public class SwimCoach implements Coach {
	private FortuneService fortuneSvc;
	
	@Autowired
	public void setFortuneSvc(FortuneService fortuneSvc) {
		this.fortuneSvc = fortuneSvc;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Do a 200m freestyle dash";
	}

	@Override
	public String getDailyFortune() {
		return "Swim fortune: " + fortuneSvc.getFortune();
	}

}
