package com.TurismoApp.TurismoApp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

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
