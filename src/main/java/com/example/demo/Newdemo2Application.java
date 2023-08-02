package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Newdemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Newdemo2Application.class, args);
	}
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
   
}
