package com.jabl.cbr;


import com.jabl.Grabber.Grabber;
import com.jabl.Grabber.Valute;
import com.jabl.Grabber.ValuteList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.util.List;

@ComponentScan()
@SpringBootApplication
public class CbrApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbrApplication.class, args);
	}
}
