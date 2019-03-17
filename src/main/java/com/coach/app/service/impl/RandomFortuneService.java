package com.coach.app.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.coach.app.service.FortuneService;

@Component
public class RandomFortuneService implements FortuneService {
	@Value("${fortunes.file.path}")
	private String fortuneFilePath;

	private List<String> fortunes;

	public String loadRandomFortunes() {
		try {
			File input = new File(fortuneFilePath);
			BufferedReader reader = new BufferedReader(new FileReader(input));
			String thisLine;
			fortunes = new ArrayList<>();
			while ((thisLine = reader.readLine()) != null) {
				fortunes.add(thisLine);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Error while reading from fortune file: " + e.getLocalizedMessage());
		}
		return getSingleRandomFortune();
	}

	@Override
	public String getFortune() {
		return fortunes != null ? getSingleRandomFortune() : loadRandomFortunes();
	}

	private String getSingleRandomFortune() {
		return fortunes.get(ThreadLocalRandom.current().nextInt(0, fortunes.size()));
	}

}
