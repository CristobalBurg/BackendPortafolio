package com.TurismoApp.TurismoApp.Controllers;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.mail.MessagingException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.TurismoApp.TurismoApp.Models.Entity.Departamento;
import com.TurismoApp.TurismoApp.Models.Entity.Pago;
import com.TurismoApp.TurismoApp.Models.Entity.Reserva;
import com.TurismoApp.TurismoApp.Models.Entity.ReservaPago;
import com.TurismoApp.TurismoApp.Models.Entity.ReservaServicioExtra;
import com.TurismoApp.TurismoApp.Models.Entity.ServicioExtra;
import com.TurismoApp.TurismoApp.Models.Entity.Usuario;
import com.TurismoApp.TurismoApp.Models.Services.IDeptoService;
import com.TurismoApp.TurismoApp.Models.Services.IPagoService;
import com.TurismoApp.TurismoApp.Models.Services.IReservaPagoSerice;
import com.TurismoApp.TurismoApp.Models.Services.IReservaService;
import com.TurismoApp.TurismoApp.Models.Services.IServicioExtra;
import com.TurismoApp.TurismoApp.Models.Services.IUsuarioService;
import com.TurismoApp.TurismoApp.Models.Services.EmailSender.EmailSenderService;
import com.TurismoApp.TurismoApp.Models.Services.WhatsAppService.WhatsAppSenderService;
import com.nimbusds.jose.shaded.json.JSONObject;

import io.jsonwebtoken.io.IOException;

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
	@Autowired
	private EmailSenderService mailService;
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IReservaPagoSerice rpService;
	@Autowired
	private IPagoService pagoService;
	@Autowired
	private WhatsAppSenderService wspService;



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
		Optional<ServicioExtra> servicioExtra = seService.findById(idServicio);

		if(!servicioExtra.isPresent()){
			return ResponseEntity.notFound().build();
		}
		String nombreFotoAnterior =  servicioExtra.get().getFoto();
		if (nombreFotoAnterior != null && nombreFotoAnterior.length() > 0){
			Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
			File archivoFotoAnterior = rutaFotoAnterior.toFile();
			if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()){
				archivoFotoAnterior.delete();	
			}
		}
		deptoService.delete(idServicio);
		return ResponseEntity.ok().build()	;
	} 
	@PostMapping("servicioExtra/upload")
	public ResponseEntity<?> uploadPhoto (@RequestParam("archivo") MultipartFile archivo ,  @RequestParam("id") Integer id){
		Map<String, Object> response = new HashMap<>();
		Optional<ServicioExtra> servicioExtra = seService.findById(id);
		System.out.println(servicioExtra);

		if(!servicioExtra.isPresent()){
			return ResponseEntity.notFound().build();
		}
		if(!archivo.isEmpty()){
			String nombreArchivo = UUID.randomUUID().toString() + "_" + archivo.getOriginalFilename().replace(" ", "");
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
			try {
				Files.copy(archivo.getInputStream() , rutaArchivo);
			} catch (java.io.IOException e) {
				response.put("error", "Error al subir la imagen");
				return new ResponseEntity<Map<String, Object>>(response , HttpStatus.INTERNAL_SERVER_ERROR);
			}
			String nombreFotoAnterior =  servicioExtra.get().getFoto();
			if (nombreFotoAnterior != null && nombreFotoAnterior.length() > 0){
				Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
				File archivoFotoAnterior = rutaFotoAnterior.toFile();
				if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()){
					archivoFotoAnterior.delete();	
				}
			}
			servicioExtra.get().setFoto(nombreArchivo);
			seService.save(servicioExtra.get());
			response.put("servicioExtra", servicioExtra);
			response.put("mensaje", "Foto subida correctamente");
		}

		
		return new ResponseEntity<Map<String, Object>>(response , HttpStatus.CREATED);

	}


	
    
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@PostMapping()
	public ResponseEntity<?> CrearReserva( @RequestBody @Validated Reserva body , BindingResult br) {

		List<Reserva> checkReserva =  reservaService.checkReserva(body.getFechaLlegada(), body.getFechaEntrega(), body.getDepartamento().getIdDepartamento());

		if (checkReserva.size() != 0){
			JSONObject resp = new JSONObject();
			resp.put("error", true);
			resp.put("mensaje", "El departamento no se encuentra disponible para las fechas Seleccionadas");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
		}

		Usuario usuario = usuarioService.getUsuario(body.getUsuario().getRutUsuario()).orElse(null);
		Departamento depto = deptoService.findById(body.getDepartamento().getIdDepartamento()).orElse(null) ;
		LocalDate hoy = LocalDate.now();


		Reserva newReserva = new Reserva();
		newReserva.setFechaEntrega(body.getFechaEntrega());
		newReserva.setFechaLlegada(body.getFechaLlegada());
		newReserva.setCtdAcomanantes(body.getCtdAcomanantes());
		newReserva.setDepartamento(depto);
		newReserva.setUsuario(usuario);

		List<ReservaServicioExtra> serviciosExtra = new ArrayList<ReservaServicioExtra>();
		for (int i = 0; i < body.getReservaServicioExtra().size(); i++) {
			ReservaServicioExtra newItem = new ReservaServicioExtra();
			ServicioExtra foundSE = seService.findById(body.getReservaServicioExtra().get(i).getServicioExtra().getIdServicioExtra()).orElse(null);
			newItem.setServicioExtra(foundSE);
			newItem.setReserva(newReserva); 
			serviciosExtra.add(newItem);
		}

		List<ReservaPago> reservaPagos = new ArrayList<ReservaPago>();
		for (int i = 0; i < body.getReservaPagos().size(); i++) {
			ReservaPago newItem = new ReservaPago();
			Pago anticipo = new Pago();
			anticipo.setMonto( body.getReservaPagos().get(i).getPago().getMonto());
			anticipo.setMedioPago(body.getReservaPagos().get(i).getPago().getMedioPago());
			anticipo.setTipoPago( body.getReservaPagos().get(i).getPago().getTipoPago());
			anticipo.setFecha(hoy);
			anticipo.setObservacion("Sin Obs");
			newItem.setPago(anticipo);
			newItem.setReserva(newReserva);
			reservaPagos.add(newItem);
		}

		newReserva.setReservaServicioExtra(serviciosExtra);
		newReserva.setReservaPagos(reservaPagos);




		if (br.hasErrors()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getAllErrors());
		}
 		try {
			mailService.sendSimpleMail(usuario.getEmail(), "Su reserva fue confirmada!", "Confirmación de reserva", newReserva);
			//HABILITAR NOTIFICACION POR WSP , PERO PA LA PRESENTACION , QUE ES FREE TRIAL LA WEA Y SE GASTAN LOS MSJES
			//wspService.sendMessageUsingTwilio(newReserva);

		} catch (MessagingException e) {
			e.printStackTrace();
		} 

		return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.save(newReserva));
	}

	@GetMapping("listarReservas")
	public ResponseEntity<?> listarReservas() {
		return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.findAll());	
	}

	@GetMapping("{idReserva}")
	public ResponseEntity<?> obtenerReserva( @PathVariable(value = "idReserva") int idReserva) {
		Optional<Reserva> reserva = reservaService.findById(idReserva);
		if(!reserva.isPresent()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(reserva);
	}
	
	@PutMapping("{idReserva}")
	public ResponseEntity<?> actualizarReserva(@RequestBody @Validated Reserva body , @PathVariable(value = "idReserva") int idReserva , BindingResult br) throws Exception {
		Reserva reservaActual = reservaService.findById(idReserva).orElse(null);
	

		System.out.println(body);
		Usuario usuario = usuarioService.actualizaUsuario(body.getUsuario(), body.getUsuario().getUsuarioRoles());
		Departamento depto = deptoService.findById(body.getDepartamento().getIdDepartamento()).orElse(null) ;

		reservaActual.setFechaEntrega(body.getFechaLlegada());
		reservaActual.setFechaLlegada(body.getFechaEntrega());
		reservaActual.setCtdAcomanantes(body.getCtdAcomanantes());
		reservaActual.setDepartamento(depto);
		reservaActual.setUsuario(usuario);

		List<ReservaServicioExtra> serviciosExtra = new ArrayList<ReservaServicioExtra>();
		for (int i = 0; i < body.getReservaServicioExtra().size(); i++) {
			ReservaServicioExtra newItem = new ReservaServicioExtra();
			ServicioExtra foundSE = seService.findById(body.getReservaServicioExtra().get(i).getServicioExtra().getIdServicioExtra()).orElse(null);
			newItem.setServicioExtra(foundSE);
			newItem.setReserva(reservaActual); 
			serviciosExtra.add(newItem);
		}

		List<ReservaPago> reservaPagos = new ArrayList<ReservaPago>();
		LocalDate hoy = LocalDate.now();
		for (int i = 0; i < body.getReservaPagos().size(); i++) {
			ReservaPago item = rpService.findById(body.getReservaPagos().get(i).getIdReservaPago()).orElse(new ReservaPago());
			Pago anticipo = pagoService.findById(body.getReservaPagos().get(i).getPago().getIdPago()).orElse(new Pago());
			anticipo.setMonto( body.getReservaPagos().get(i).getPago().getMonto());
			anticipo.setMedioPago(body.getReservaPagos().get(i).getPago().getMedioPago());
			anticipo.setTipoPago( body.getReservaPagos().get(i).getPago().getTipoPago());
			anticipo.setObservacion("Sin Obs");
			anticipo.setFecha(hoy);
			item.setPago(anticipo);
			item.setReserva(reservaActual);
			reservaPagos.add(item);
		}

		reservaActual.setReservaServicioExtra(serviciosExtra);
		reservaActual.setReservaPagos(reservaPagos);



		return ResponseEntity.status(HttpStatus.OK).body(reservaService.save(reservaActual));
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
