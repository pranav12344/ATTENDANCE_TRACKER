package com.example.attendance_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class AttendanceTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceTrackerApplication.class, args);
	}

}
