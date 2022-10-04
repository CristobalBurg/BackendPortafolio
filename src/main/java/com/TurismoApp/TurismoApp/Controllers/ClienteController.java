package com.TurismoApp.TurismoApp.Controllers;

import java.util.Optional;

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
import com.TurismoApp.TurismoApp.Models.Entity.Cliente;
import com.TurismoApp.TurismoApp.Models.Services.ClienteServiceImpl;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
	private ClienteServiceImpl clienteService ;

    @PostMapping()
	public ResponseEntity<?> crearCliente( @RequestBody @Validated Cliente body , BindingResult br) {
		
		if (br.hasErrors()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getAllErrors());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(body));
	}

	@GetMapping("/listarClientes")
	public ResponseEntity<?> listarClientes() {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.findAll());	
	}

	@GetMapping("/{rutCliente}")
	public ResponseEntity<?> obtenerCliente( @PathVariable(value = "rutCliente") String rutCliente) {
		Optional<Cliente> cliente = clienteService.findById(rutCliente);
		if(!cliente.isPresent()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente);
	}
	@PutMapping("/{rutCliente}")
	public ResponseEntity<?> actualizarCliente(@RequestBody @Validated Cliente body , @PathVariable(value = "rutCliente") String rutCliente , BindingResult br) {
		Optional<Cliente> cliente = clienteService.findById(rutCliente);
		if(!cliente.isPresent()){
			return ResponseEntity.notFound().build();
		}

		cliente.get().setNombre(body.getNombre());
		cliente.get().setApellido(body.getApellido());
		cliente.get().setContacto(body.getContacto());
		cliente.get().setCorreo(body.getCorreo());

		return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente.get()));
	}

 	@DeleteMapping("/{rutCliente}")
	public ResponseEntity<?> borrarCliente( @PathVariable(value = "rutCliente") String rutCliente) {
		if(!clienteService.findById(rutCliente).isPresent()){
			return ResponseEntity.notFound().build();
		}
		clienteService.delete(rutCliente);
		return ResponseEntity.ok().build()	;
	} 
    
}
