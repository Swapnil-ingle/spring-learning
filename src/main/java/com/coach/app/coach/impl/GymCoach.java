package com.coach.app.coach.impl;

import com.coach.app.service.FortuneService;

public class GymCoach {
	private FortuneService fortuneSvc;
	
	private String name;
	
	private String eMailAddress;
	
	public void setFortuneSvc(FortuneService fortuneSvc) {
		this.fortuneSvc = fortuneSvc;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteMailAddress() {
		return eMailAddress;
	}

	public void seteMailAddress(String eMailAddress) {
		this.eMailAddress = eMailAddress;
	}

	public String getDailyWorkout() {
		return "Bench press 100Kgs";
	}
	
	public String getDailyFortune() {
		return fortuneSvc.getFortune();
	}

}
