package com.example.onlineexamination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class OnlineExaminationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineExaminationSystemApplication.class, args);
	}

}
