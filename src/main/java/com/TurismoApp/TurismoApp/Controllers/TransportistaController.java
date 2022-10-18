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

import com.TurismoApp.TurismoApp.Models.Entity.Transportista;
import com.TurismoApp.TurismoApp.Models.Services.ITransportistaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/transportista")
public class TransportistaController {

    @Autowired
    private ITransportistaService transportistaService;

    @PostMapping()
	public ResponseEntity<?> CrearReserva( @RequestBody @Validated Transportista body , BindingResult br) {


		Transportista newTransportista = new Transportista();
        newTransportista.setRutTransportista(body.getRutTransportista());
		newTransportista.setNombre(body.getNombre());
		newTransportista.setApellido(body.getApellido());
		newTransportista.setVehiculo(body.getVehiculo());
		newTransportista.setFechaDesde(body.getFechaDesde());
        newTransportista.setFechaHasta(body.getFechaHasta());



		if (br.hasErrors()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getAllErrors());
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(transportistaService.save(newTransportista));
	}

	@GetMapping("/listarTransportistas")
	public ResponseEntity<?> listarTransportistas() {
		return ResponseEntity.status(HttpStatus.CREATED).body(transportistaService.findAll());	
	}

	@GetMapping("/{rutTransportista}")
	public ResponseEntity<?> obtenerReserva( @PathVariable(value = "rutTransportista") String rutTransportista) {
		Optional<Transportista> transportista = transportistaService.findById(rutTransportista);
		if(!transportista.isPresent()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(transportista);
	}
	
	@PutMapping("/{rutTransportista}")
	public ResponseEntity<?> actualizarReserva(@RequestBody @Validated Transportista body , @PathVariable(value = "rutTransportista") String rutTransportista , BindingResult br) {
		Optional<Transportista> reservaActual = transportistaService.findById(rutTransportista);
		if(!reservaActual.isPresent()){
			return ResponseEntity.notFound().build();
		}

        Transportista auxTransportista = new Transportista();
        BeanUtils.copyProperties(body, auxTransportista);
        auxTransportista.setRutTransportista(reservaActual.get().getRutTransportista());



		return ResponseEntity.status(HttpStatus.OK).body(transportistaService.save(auxTransportista));
	}

 	@DeleteMapping("/{rutTransportista}")
	public ResponseEntity<?> eliminarReserva( @PathVariable(value = "rutTransportista") String rutTransportista) {
		Optional<Transportista> transportista = transportistaService.findById(rutTransportista);
		if(!transportista.isPresent()){
			return ResponseEntity.notFound().build();
		}
		transportistaService.delete(rutTransportista);
		return ResponseEntity.ok().build();
	}
    

}
