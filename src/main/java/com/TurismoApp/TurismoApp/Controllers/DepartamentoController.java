package com.TurismoApp.TurismoApp.Controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.management.RuntimeErrorException;

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

import com.TurismoApp.TurismoApp.Models.Entity.Comuna;
import com.TurismoApp.TurismoApp.Models.Entity.Departamento;
import com.TurismoApp.TurismoApp.Models.Entity.Inventario;
import com.TurismoApp.TurismoApp.Models.Entity.InventarioProducto;
import com.TurismoApp.TurismoApp.Models.Entity.Producto;
import com.TurismoApp.TurismoApp.Models.Services.IDeptoService;

import javassist.NotFoundException;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
	private IDeptoService deptoService ;

    @PostMapping()
	public ResponseEntity<?> crearDepartamento( @RequestBody @Validated Departamento body , BindingResult br) {

		Comuna comuna = deptoService.getComunaById(body.getComuna().getIdComuna());



		Departamento newDepto = new Departamento();
		newDepto.setDireccion(body.getDireccion());
		newDepto.setCtdHabitaciones(body.getCtdHabitaciones());
		newDepto.setCtdBanos(body.getCtdBanos());
		newDepto.setValorArriendoDia(body.getValorArriendoDia());
		newDepto.setPoliticasCondiciones(body.getPoliticasCondiciones());
		newDepto.setFoto(null);
		newDepto.setComuna(comuna);


		if (br.hasErrors()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getAllErrors());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(deptoService.save(newDepto));
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



	@PutMapping("{idDepartamento}")
	public ResponseEntity<?> actualizarCliente(@RequestBody @Validated Departamento body , @PathVariable(value = "idDepartamento") int idDepartamento , BindingResult br) {
		Optional<Departamento> departamento = deptoService.findById(idDepartamento);
		if(!departamento.isPresent()){
			return ResponseEntity.notFound().build();
		}
        Departamento depto = new Departamento();
        BeanUtils.copyProperties(body, depto);
        depto.setIdDepartamento(departamento.get().getIdDepartamento());

		return ResponseEntity.status(HttpStatus.OK).body(deptoService.save(depto));
	}

 	@DeleteMapping("/{idDepartamento}")
	public ResponseEntity<?> borrarCliente( @PathVariable(value = "idDepartamento") int idDepartamento) {
		if(!deptoService.findById(idDepartamento).isPresent()){
			return ResponseEntity.notFound().build();
		}
		Optional<Departamento> departamento = deptoService.findById(idDepartamento);

		if(!departamento.isPresent()){
			return ResponseEntity.notFound().build();
		}
		String nombreFotoAnterior =  departamento.get().getFoto();
		if (nombreFotoAnterior != null && nombreFotoAnterior.length() > 0){
			Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
			File archivoFotoAnterior = rutaFotoAnterior.toFile();
			if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()){
				archivoFotoAnterior.delete();	
			}
		}
		deptoService.delete(idDepartamento);
		return ResponseEntity.ok().build()	;
	} 

	@GetMapping("/listarComunas")
	public List<Comuna> listarComunas() {
		return deptoService.findAllComunas();	
	}
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadPhoto (@RequestParam("archivo") MultipartFile archivo ,  @RequestParam("id") Integer id){
		Map<String, Object> response = new HashMap<>();
		Optional<Departamento> departamento = deptoService.findById(id);

		if(!departamento.isPresent()){
			return ResponseEntity.notFound().build();
		}
		if(!archivo.isEmpty()){
			String nombreArchivo = UUID.randomUUID().toString() + "_" + archivo.getOriginalFilename().replace(" ", "");
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
			try {
				Files.copy(archivo.getInputStream() , rutaArchivo);
			} catch (IOException e) {
				response.put("error", "Error al subir la imagen");
				return new ResponseEntity<Map<String, Object>>(response , HttpStatus.INTERNAL_SERVER_ERROR);
			}
			String nombreFotoAnterior =  departamento.get().getFoto();
			if (nombreFotoAnterior != null && nombreFotoAnterior.length() > 0){
				Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
				File archivoFotoAnterior = rutaFotoAnterior.toFile();
				if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()){
					archivoFotoAnterior.delete();	
				}
			}
			departamento.get().setFoto(nombreArchivo);
			deptoService.save(departamento.get());
			response.put("departamento", departamento);
			response.put("mensaje", "Foto subida correctamente");
		}

		
		return new ResponseEntity<Map<String, Object>>(response , HttpStatus.CREATED);

	}


    @GetMapping("/upload/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto( @PathVariable String nombreFoto){

		Path rutaArchivo = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
		Resource recurso = null;
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		if (!recurso.exists() && !recurso.isReadable()){
			throw new RuntimeException("No se pudo cargar la imagen");
		}
		HttpHeaders header  = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");


		return new ResponseEntity<Resource>(recurso ,header ,  HttpStatus.OK) ;


	}
}
