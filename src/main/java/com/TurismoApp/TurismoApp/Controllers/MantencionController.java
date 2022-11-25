package com.TurismoApp.TurismoApp.Controllers;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TurismoApp.TurismoApp.Models.Entity.Mantencion;
import com.TurismoApp.TurismoApp.Models.Entity.Pago;
import com.TurismoApp.TurismoApp.Models.Services.IMantencionService;
import com.TurismoApp.TurismoApp.Models.Services.IPagoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/mantencion")
public class MantencionController {

    @Autowired
    private IMantencionService mantencionService;

	@Autowired
	private IPagoService pagoService;

    @PostMapping()
	public ResponseEntity<?> CrearMantencion( @RequestBody @Validated Mantencion body , BindingResult br) {


		Mantencion newMantencion = new Mantencion();
        newMantencion.setDescripcion(body.getDescripcion());
        newMantencion.setValor(body.getValor());

		if (br.hasErrors()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getAllErrors());
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(mantencionService.save(newMantencion));
	}

	@GetMapping("/listadoMantenciones")
	public ResponseEntity<?> listarMantenciones() {
		return ResponseEntity.status(HttpStatus.CREATED).body(mantencionService.findAll());	
	}

	@GetMapping("/{idMantencion}")
	public ResponseEntity<?> obtenerMantecion( @PathVariable(value = "idMantencion") int idMantencion) {
		Optional<Mantencion> mantencion = mantencionService.findById(idMantencion);
		if(!mantencion.isPresent()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(mantencion);
	}
	
	@PutMapping("/{idMantencion}")
	public ResponseEntity<?> actualizarMantencion(@RequestBody @Validated Mantencion body , @PathVariable(value = "idMantencion") int idMantencion , BindingResult br) {
		Optional<Mantencion> mantencionActual = mantencionService.findById(idMantencion);
		if(!mantencionActual.isPresent()){
			return ResponseEntity.notFound().build();
		}

        Mantencion auxMantencion = new Mantencion();
        BeanUtils.copyProperties(body, auxMantencion);
        auxMantencion.setIdMantencion(mantencionActual.get().getIdMantencion());



		return ResponseEntity.status(HttpStatus.OK).body(mantencionService.save(auxMantencion));
	}

 	@DeleteMapping("/{idMantancion}")
	public ResponseEntity<?> eliminarMantencion( @PathVariable(value = "idMantancion") int idMantancion) {
		Optional<Mantencion> mantencion = mantencionService.findById(idMantancion);
		if(!mantencion.isPresent()){
			return ResponseEntity.notFound().build();
		}
		mantencionService.delete(idMantancion);
		return ResponseEntity.ok().build();
	}

	/////////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/pago")
	public ResponseEntity<?> ingresarPago ( @RequestBody @Validated Pago body , BindingResult br) {


		Pago newPago = new Pago();
        newPago.setMonto(body.getMonto());
        newPago.setFecha(body.getFecha());
		newPago.setMedioPago(body.getMedioPago());
		newPago.setObservacion(body.getObservacion());
		newPago.setTipoPago(body.getTipoPago());

		if (br.hasErrors()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getAllErrors());
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.save(newPago));
	}
    
}
