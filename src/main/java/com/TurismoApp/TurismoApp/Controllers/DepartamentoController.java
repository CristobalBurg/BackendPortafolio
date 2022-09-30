package com.TurismoApp.TurismoApp.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TurismoApp.TurismoApp.Models.Entity.Comuna;
import com.TurismoApp.TurismoApp.Models.Entity.Departamento;
import com.TurismoApp.TurismoApp.Models.Services.IDeptoService;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
	private IDeptoService deptoService ;

    @PostMapping()
	public ResponseEntity<?> crearDepartamento( @RequestBody @Validated Departamento body , BindingResult br) {

		if (br.hasErrors()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getAllErrors());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(deptoService.save(body));
	}

	@GetMapping("/listarDepartamentos")
	public List<Departamento> listarDepartamentos() {
		return deptoService.findAll(); 
	}

	@GetMapping("/{idDepartamento}")
	public ResponseEntity<?> obtenerDepto( @PathVariable(value = "idDepartamento") int idDepartamento) {
		Optional<Departamento> depto = deptoService.findById(idDepartamento);
		if(!depto.isPresent()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(depto);
	}
	@PutMapping("/{idDepartamento}")
	public ResponseEntity<?> actualizarCliente(@RequestBody @Validated Departamento body , @PathVariable(value = "idDepartamento") int idDepartamento , BindingResult br) {
		Optional<Departamento> departamento = deptoService.findById(idDepartamento);
		if(!departamento.isPresent()){
			return ResponseEntity.notFound().build();
		}
        Departamento depto = new Departamento();
        BeanUtils.copyProperties(body, depto);
        depto.setIdDeparamento(departamento.get().getIdDeparamento());

		return ResponseEntity.status(HttpStatus.OK).body(deptoService.save(depto));
	}

 	@DeleteMapping("/{idDepartamento}")
	public ResponseEntity<?> borrarCliente( @PathVariable(value = "idDepartamento") int idDepartamento) {
		if(!deptoService.findById(idDepartamento).isPresent()){
			return ResponseEntity.notFound().build();
		}
		deptoService.delete(idDepartamento);
		return ResponseEntity.ok().build()	;
	} 

	@GetMapping("/listarComunas")
	public List<Comuna> listarComunas() {
		return deptoService.findAllComunas();	
	}
    
}
