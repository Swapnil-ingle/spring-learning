package com.coach.app.service.impl;

import org.springframework.stereotype.Component;

import com.coach.app.service.FortuneService;

@Component
public class StaticFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "You define your fortune!";
	}

}
