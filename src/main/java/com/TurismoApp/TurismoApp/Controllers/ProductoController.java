package com.TurismoApp.TurismoApp.Controllers;

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

import com.TurismoApp.TurismoApp.Models.Entity.InventarioProducto;
import com.TurismoApp.TurismoApp.Models.Entity.Producto;
import com.TurismoApp.TurismoApp.Models.Services.IInventarioProductoService;
import com.TurismoApp.TurismoApp.Models.Services.IProductoService;
import com.google.common.base.Optional;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private IProductoService pS;

    @Autowired
    private IInventarioProductoService ipS;

    @PostMapping()
	public ResponseEntity<?> CrearProducto( @RequestBody @Validated Producto body , BindingResult br) {


		Producto newProducto = new Producto();
        newProducto.setNombre(body.getNombre());
        newProducto.setValor(body.getValor());

		if (br.hasErrors()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getAllErrors());
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(pS.save(newProducto));
	}

	@GetMapping("/listadoProductos")
	public ResponseEntity<?> listarProductos() {
		return ResponseEntity.status(HttpStatus.CREATED).body(pS.findAll());	
	}

	@GetMapping("/{idProducto}")
	public ResponseEntity<?> obtenerMantecion( @PathVariable(value = "idProducto") int idProducto) {
		Producto producto = pS.findById(idProducto).orElse(null);
		return ResponseEntity.ok(producto);
	}
	
	@PutMapping("/{idProducto}")
	public ResponseEntity<?> actualizarProducto(@RequestBody @Validated Producto body , @PathVariable(value = "idProducto") int idProducto , BindingResult br) {
		Producto productoActual = pS.findById(idProducto).orElse(null);


        Producto auxProducto = new Producto();
        BeanUtils.copyProperties(body, auxProducto);
        auxProducto.setIdProducto(productoActual.getIdProducto());



		return ResponseEntity.status(HttpStatus.OK).body(pS.save(auxProducto));
	}

 	@DeleteMapping("/{idProducto}")
	public ResponseEntity<?> eliminarProducto( @PathVariable(value = "idProducto") int idProducto) {
		Producto producto = pS.findById(idProducto).orElse(null);

		pS.delete(producto.getIdProducto());
		return ResponseEntity.ok().build();
	}

    @DeleteMapping("/ip/{idInventarioProducto}")
	public ResponseEntity<?> eliminarInventarioProducto( @PathVariable(value = "idInventarioProducto") int idInventarioProducto) {
		InventarioProducto ip = ipS.findById(idInventarioProducto).orElse(null);

		ipS.delete(ip.getIdInventarioProducto());
		return ResponseEntity.ok().build();
	}
    
}
