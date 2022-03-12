package com.human.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloHumanApplication {
	@RequestMapping("/")
	public String human(@RequestParam(value = "name",required=false) String name ) {
		if (name != null ) {
		return "Hello" + " " +name;
		}
		else {
			return "Hello Human";
			}
		}
	

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}

}
