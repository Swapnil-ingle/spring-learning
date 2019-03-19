package com.coach.app.coach.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.coach.app.coach.Coach;
import com.coach.app.service.FortuneService;

//@Component
public class SwimCoach {
//	@Autowired
	private FortuneService fortuneSvc;
	
	@Value("${coach.email}")
	private String email;
	
	@Value("${coach.name}")
	private String name;
	
	public SwimCoach(FortuneService fortuneSvc) {
		this.fortuneSvc = fortuneSvc;
	}

//	@Override
	public String getDailyWorkout() {
		return "Do a 200m freestyle dash";
	}

//	@Override
	public String getDailyFortune() {
		return "Swim fortune: " + fortuneSvc.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}
}
