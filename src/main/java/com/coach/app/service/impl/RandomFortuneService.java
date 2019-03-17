package com.coach.app.service.impl;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import com.coach.app.service.FortuneService;

@Component
public class RandomFortuneService implements FortuneService {
	private static final String[] fortunes = {
			"Today you're going to have a very good day", 
			"Today, spirits are not very happy with you", 
			"Today your day is going to be in your hands"}; 

	@Override
	public String getFortune() {
		return fortunes[ThreadLocalRandom.current().nextInt(0, fortunes.length)];
	}

}
