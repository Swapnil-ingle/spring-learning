package com.coach.app.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.coach.app.coach.Coach;
import com.coach.app.coach.impl.SwimCoach;
import com.coach.app.service.FortuneService;
import com.coach.app.service.impl.RandomFortuneService;
import com.coach.app.service.impl.SadFortuneService;

@Configuration
//@ComponentScan("com.coach.app")
@PropertySource("classpath:sports.properties")
public class SportsConfig {
	// define a method to expose our bean
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	@Bean FortuneService RandomFortuneService() {
		return new RandomFortuneService();
	}
	
	// define a bean for swim coach and inject dependencies
	@Bean
	public SwimCoach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
