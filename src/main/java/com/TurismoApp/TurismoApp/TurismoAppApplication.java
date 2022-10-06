package com.TurismoApp.TurismoApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class TurismoAppApplication implements CommandLineRunner {



	public static void main(String[] args) {

		SpringApplication.run(TurismoAppApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {


	}

}
