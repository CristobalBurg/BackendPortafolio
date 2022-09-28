package com.TurismoApp.TurismoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.TurismoApp.TurismoApp.Entity.Trabajador;
import com.TurismoApp.TurismoApp.Repositories.TrabajadorRepository;

@RestController
@SpringBootApplication
public class TurismoAppApplication implements CommandLineRunner {

	@Autowired
	private TrabajadorRepository trabajadorRepo ;

	public static void main(String[] args) {

		SpringApplication.run(TurismoAppApplication.class, args);
	}

	@PostMapping("/guardarTrabajador")
	public String saveTrabajador( @RequestBody Trabajador body) {
		Trabajador newTrabajador = new Trabajador(body);
		trabajadorRepo.save(newTrabajador);
		return "SAVED";
	}



	@GetMapping("/listarTrabajadores")
	public String listarTrabajadores() {
		Iterable<Trabajador> listadoTrabajadores  = trabajadorRepo.findAll();
		listadoTrabajadores.forEach(System.out :: println);
		return listadoTrabajadores.toString();
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
