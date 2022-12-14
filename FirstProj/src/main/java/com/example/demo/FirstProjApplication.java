package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstProjApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(FirstProjApplication.class, args);
		Student s=context.getBean(Student.class);
		s.show();
		Student s1=context.getBean(Student.class);
		s1.show();
	}

}
