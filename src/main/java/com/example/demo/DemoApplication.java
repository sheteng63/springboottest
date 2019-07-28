package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Contest contest = new Contest();
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					contest.consume();
				}
			}).start();
		}

		new Thread(new Runnable() {
			@Override
			public void run() {
				contest.produce();
			}
		}).start();

	}

}
