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

import com.TurismoApp.TurismoApp.Models.Entity.Reserva;
import com.TurismoApp.TurismoApp.Models.Entity.ServicioExtra;
import com.TurismoApp.TurismoApp.Models.Services.IDeptoService;
import com.TurismoApp.TurismoApp.Models.Services.IReservaService;
import com.TurismoApp.TurismoApp.Models.Services.IServicioExtra;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/reserva/")
public class ReservasController {

    @Autowired
	private IServicioExtra seService ;
	@Autowired
	private IDeptoService  deptoService;
	@Autowired
	private IReservaService reservaService;

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
    

	@PostMapping()
	public ResponseEntity<?> CrearReserva( @RequestBody @Validated Reserva body , BindingResult br) {

		System.out.println(body);

		Reserva newReserva = new Reserva();
		newReserva.setFechaEntrega(body.getFechaLlegada());
		newReserva.setFechaLlegada(body.getFechaEntrega());
		newReserva.setDepartamento( deptoService.findById(body.getDepartamento().getIdDepartamento()).orElse(null));
		newReserva.setServicioExtra(reservaService.findServicioExtraById( body.getServicioExtra().getIdServicioExtra()));
		newReserva.setPago(body.getPago());

		System.out.println(body.getDepartamento().getIdDepartamento());

		
		if (br.hasErrors()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getAllErrors());
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.save(newReserva));
	}

	@GetMapping("listarReservas")
	public ResponseEntity<?> listarReservas() {
		return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.findAll());	
	}

	@GetMapping("{idReserva}")
	public ResponseEntity<?> obtenerReserva( @PathVariable(value = "idReserva") int idReserva) {
		Optional<Reserva> servicio = reservaService.findById(idReserva);
		if(!servicio.isPresent()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(servicio);
	}
	
	@PutMapping("{idReserva}")
	public ResponseEntity<?> actualizarReserva(@RequestBody @Validated Reserva body , @PathVariable(value = "idReserva") int idReserva , BindingResult br) {
		Optional<Reserva> reservaActual = reservaService.findById(idReserva);
		if(!reservaActual.isPresent()){
			return ResponseEntity.notFound().build();
		}

        Reserva auxReserva = new Reserva();
        BeanUtils.copyProperties(body, auxReserva);
        auxReserva.setIdReserva(reservaActual.get().getIdReserva());



		return ResponseEntity.status(HttpStatus.OK).body(reservaService.save(auxReserva));
	}

 	@DeleteMapping("{idReserva}")
	public ResponseEntity<?> eliminarReserva( @PathVariable(value = "idReserva") int idReserva) {
		Optional<Reserva> reserva = reservaService.findById(idReserva);
		if(!reserva.isPresent()){
			return ResponseEntity.notFound().build();
		}
		reservaService.deleteReservaById(idReserva);
		return ResponseEntity.ok().build();
	}
}
