package com.example.demo;

import com.example.demo.service.impl.Contest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.logging.Handler;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		ApplicationContext context = SpringUtil.getApplicationContext();
		Contest contest = context.getBean(Contest.class);

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
