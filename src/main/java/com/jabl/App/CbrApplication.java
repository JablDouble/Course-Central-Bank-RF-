package com.jabl.App;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan()
@SpringBootApplication
public class CbrApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbrApplication.class, args);
	}
}
