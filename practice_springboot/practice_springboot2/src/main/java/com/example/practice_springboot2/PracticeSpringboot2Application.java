package com.example.practice_springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class PracticeSpringboot2Application {

	@GetMapping("home")
	public String func(){
		return " this is home page ";
	}  

	public static void main(String[] args) {
		SpringApplication.run(PracticeSpringboot2Application.class, args);
	}

}
