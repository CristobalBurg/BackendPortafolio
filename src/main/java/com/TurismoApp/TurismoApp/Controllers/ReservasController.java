package com.TurismoApp.TurismoApp.Controllers;

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

import com.TurismoApp.TurismoApp.Models.Entity.ServicioExtra;
import com.TurismoApp.TurismoApp.Models.Services.IServicioExtra;
@RestController
@RequestMapping("/api/reserva/")
public class ReservasController {

    @Autowired
	private IServicioExtra seService ;

    @PostMapping("servicioExtra")
	public ResponseEntity<?> crearServicioExtra( @RequestBody @Validated ServicioExtra body , BindingResult br) {
		
		if (br.hasErrors()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getAllErrors());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(seService.save(body));
	}

	@GetMapping("servicioExtra/listarServiciosExtra")
	public ResponseEntity<?> listarServiciosExtra() {
		return ResponseEntity.status(HttpStatus.CREATED).body(seService.findAll());	
	}

	@GetMapping("servicioExtra/{idServicio}")
	public ResponseEntity<?> obtenerServicioExtra( @PathVariable(value = "idServicio") int idServicio) {
		Optional<ServicioExtra> servicio = seService.findById(idServicio);
		if(!servicio.isPresent()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(servicio);
	}
	@PutMapping("servicioExtra/{idServicio}")
	public ResponseEntity<?> actualizarCliente(@RequestBody @Validated ServicioExtra body , @PathVariable(value = "idServicio") int idServicio , BindingResult br) {
		Optional<ServicioExtra> servicio = seService.findById(idServicio);
		if(!servicio.isPresent()){
			return ResponseEntity.notFound().build();
		}

        ServicioExtra auxSe = new ServicioExtra();
        BeanUtils.copyProperties(body, auxSe);
        auxSe.setIdServicioExtra(servicio.get().getIdServicioExtra());



		return ResponseEntity.status(HttpStatus.OK).body(seService.save(auxSe));
	}

 	@DeleteMapping("servicioExtra/{idServicio}")
	public ResponseEntity<?> borrarCliente( @PathVariable(value = "idServicio") int idServicio) {
		if(!seService.findById(idServicio).isPresent()){
			return ResponseEntity.notFound().build();
		}
		seService.delete(idServicio);
		return ResponseEntity.ok().build()	;
	} 
    
}
