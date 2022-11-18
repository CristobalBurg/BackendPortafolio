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
import com.TurismoApp.TurismoApp.Models.Entity.DepartamentoMantencion;
import com.TurismoApp.TurismoApp.Models.Entity.InventarioProducto;
import com.TurismoApp.TurismoApp.Models.Entity.Mantencion;
import com.TurismoApp.TurismoApp.Models.Entity.Producto;
import com.TurismoApp.TurismoApp.Models.Services.IDepartamentoMantencion;
import com.TurismoApp.TurismoApp.Models.Services.IDeptoService;
import com.TurismoApp.TurismoApp.Models.Services.IInventarioProductoService;
import com.TurismoApp.TurismoApp.Models.Services.IMantencionService;
import com.TurismoApp.TurismoApp.Models.Services.IProductoService;

import javassist.NotFoundException;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
	private IDeptoService deptoService ;
	@Autowired
	private IProductoService productoService;
	@Autowired
	private IInventarioProductoService ipService;
	@Autowired
	private IDepartamentoMantencion dmService;
	@Autowired
	private IMantencionService mService;

    @PostMapping()
	public ResponseEntity<?> crearDepartamento( @RequestBody @Validated Departamento body , BindingResult br) {

		Comuna comuna = deptoService.getComunaById(body.getComuna().getIdComuna());

		Departamento newDepto = new Departamento();
		newDepto.setDireccion(body.getDireccion());
		newDepto.setCtdHabitaciones(body.getCtdHabitaciones());
		newDepto.setCtdBanos(body.getCtdBanos());
		newDepto.setValorArriendoDia(body.getValorArriendoDia());
		newDepto.setPoliticasCondiciones(body.getPoliticasCondiciones());
		newDepto.setTamano(body.getTamano());
		newDepto.setFoto(null);
		newDepto.setComuna(comuna);
		newDepto.setDepartamentoMantenciones(null);
		List <InventarioProducto> inventario = new ArrayList<InventarioProducto>();
		InventarioProducto defaultItem = new InventarioProducto();
		InventarioProducto defaultItem2 = new InventarioProducto();
		Producto defaultProducto1 = productoService.findById(1).orElse(null);
		Producto defaultProducto2 = productoService.findById(2).orElse(null);
		defaultItem.setDepartamento(newDepto);
		defaultItem.setProducto(defaultProducto1);
		defaultItem.setCantidad(1);
		defaultItem2.setDepartamento(newDepto);
		defaultItem2.setProducto(defaultProducto2);
		defaultItem2.setCantidad(3);
		inventario.add(defaultItem);
		inventario.add(defaultItem2);

		for (int i = 0; i < body.getInventarioProductos().size(); i++) {
			InventarioProducto newItem = new InventarioProducto();
			Producto foundProducto = productoService.findById(body.getInventarioProductos().get(i).getProducto().getIdProducto()).orElse(null);
			newItem.setCantidad(body.getInventarioProductos().get(i).getCantidad());
			newItem.setProducto(foundProducto);
			newItem.setDepartamento(newDepto);
			inventario.add(newItem);
		}



		newDepto.setInventarioProductos(inventario);




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
	public ResponseEntity<?> actualizarDepartamento(@RequestBody @Validated Departamento body , @PathVariable(value = "idDepartamento") int idDepartamento , BindingResult br) {
		Departamento departamento = deptoService.findById(idDepartamento).orElse(null);

		Comuna comuna = deptoService.getComunaById(body.getComuna().getIdComuna());

		departamento.setIdDepartamento(departamento.getIdDepartamento());
		departamento.setDireccion(body.getDireccion());
		departamento.setCtdHabitaciones(body.getCtdHabitaciones());
		departamento.setCtdBanos(body.getCtdBanos());
		departamento.setValorArriendoDia(body.getValorArriendoDia());
		departamento.setPoliticasCondiciones(body.getPoliticasCondiciones());
		departamento.setTamano(body.getTamano());
		departamento.setFoto(null);
		departamento.setComuna(comuna);
		List <InventarioProducto> inventario = new ArrayList<InventarioProducto>();
		List <DepartamentoMantencion> mantenciones = new ArrayList<DepartamentoMantencion>();


		for (int i = 0; i < body.getInventarioProductos().size(); i++) {
			InventarioProducto newItem = ipService.findById(body.getInventarioProductos().get(i).getIdInventarioProducto()).orElse(new InventarioProducto());
			Producto foundProducto = productoService.findById(body.getInventarioProductos().get(i).getProducto().getIdProducto()).orElse(null);
			newItem.setCantidad(body.getInventarioProductos().get(i).getCantidad());
			newItem.setProducto(foundProducto);
			newItem.setDepartamento(departamento);
			newItem.setIdInventarioProducto(newItem.getIdInventarioProducto());
			inventario.add(newItem);
		}

		for (int i = 0; i < body.getDepartamentoMantenciones().size(); i++) {
			DepartamentoMantencion newItem = dmService.findById(body.getDepartamentoMantenciones().get(i).getIdDepartamentoMantencion()).orElse(new DepartamentoMantencion());
			Mantencion foundMantencion = mService.findById(body.getDepartamentoMantenciones().get(i).getMantencion().getIdMantencion()).orElse(null);
			newItem.setFechaInicio(body.getDepartamentoMantenciones().get(i).getFechaInicio());
			newItem.setFechaFin(body.getDepartamentoMantenciones().get(i).getFechaFin());
			newItem.setDepartamento(departamento);
			newItem.setMantencion(foundMantencion);
			mantenciones.add(newItem);
		}

		departamento.setInventarioProductos(inventario);
		departamento.setDepartamentoMantenciones(mantenciones);
		return ResponseEntity.status(HttpStatus.OK).body(deptoService.save(departamento));
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
