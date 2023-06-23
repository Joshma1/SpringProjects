package com.spring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JoshmaDtoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoshmaDtoProjectApplication.class, args);
	}
	
	// Add ModelMapper Class.
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

}
