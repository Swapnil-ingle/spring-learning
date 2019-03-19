package com.coach.app.service.impl;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import com.coach.app.service.FortuneService;

//@Component
public class SadFortuneService implements FortuneService {
	private static final String[] fortunes = {
			"Bad day", 
			"Worse day", 
			"Can't be any badder XD"};

	@Override
	public String getFortune() {
		return fortunes[ThreadLocalRandom.current().nextInt(0, fortunes.length)];
	}

}
