package com.TurismoApp.TurismoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.TurismoApp.TurismoApp.Entity.Trabajador;
import com.TurismoApp.TurismoApp.Repositories.AdministrativoRepository;

@RestController
@SpringBootApplication
public class TurismoAppApplication implements CommandLineRunner {

	@Autowired
	private AdministrativoRepository administrativoRepo ;

	public static void main(String[] args) {

		SpringApplication.run(TurismoAppApplication.class, args);
	}



	@GetMapping("/listarTrabajadores")
	public String listarTrabajadores() {
		Iterable<Trabajador> listadoTrabajadores  = administrativoRepo.findAll();
		listadoTrabajadores.forEach(System.out :: println);
		return listadoTrabajadores.toString();
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
