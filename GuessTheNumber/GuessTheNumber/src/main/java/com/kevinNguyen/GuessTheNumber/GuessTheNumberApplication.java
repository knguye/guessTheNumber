package com.kevinNguyen.GuessTheNumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GuessTheNumberApplication {
	public static void main(String[] args) {
		try {
			SpringApplication.run(GuessTheNumberApplication.class, args);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
