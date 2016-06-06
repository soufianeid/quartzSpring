package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ImportResource("jobBean.xml")
public class QuartzTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuartzTestApplication.class, args);
	}
}
