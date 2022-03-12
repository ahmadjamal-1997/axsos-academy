package com.daikichi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/daikichi")

public class DaikichiApplication {
	@RequestMapping("")
	public String greeting() {
		return "Welcome";
	}
	@RequestMapping("/today")
	public String myDay() {
		return "The Is The First Day OF Java Spring";
	}
	@RequestMapping("/tomorrow")
	public String myDayAfterToday() {
		return "Tomorrow Is Gonna Be Better";
	}
	public static void main(String[] args) {
		SpringApplication.run(DaikichiApplication.class, args);
		
	}

}
