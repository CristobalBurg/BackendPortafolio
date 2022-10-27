package com.TurismoApp.TurismoApp.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.TurismoApp.TurismoApp.Models.Entity.Departamento;
import com.TurismoApp.TurismoApp.Models.Entity.InventarioProducto;
import com.TurismoApp.TurismoApp.Models.Services.IDeptoService;
import com.TurismoApp.TurismoApp.Models.Services.IInventarioProductoService;
import com.TurismoApp.TurismoApp.Models.Services.IProductoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/inventario/")
public class InventarioController {


    @Autowired
    private IInventarioProductoService ipService;

    @Autowired
    private IDeptoService deptoService;
    @Autowired IProductoService productoService;

    //Crear Inventario de acuerdo al id del departamento
    @RequestMapping(value="{idDepartamento}", method=RequestMethod.POST,
         consumes="application/json",
         produces="application/json")
    @ResponseBody
	public ResponseEntity<?> CrearInventario( @RequestBody @Validated List<InventarioProducto> body , @PathVariable int idDepartamento, BindingResult br) {

        
        Departamento foundDepto = deptoService.findById(idDepartamento).orElse(null);
/*         Inventario  inventario = new Inventario();
        inventario.setIdInventario(foundDepto.getIdDepartamento());
        inventario.setDepartamento(foundDepto)  ;
        inventarioService.save(inventario);

        List<InventarioProducto> returnAux = new ArrayList<InventarioProducto>();
        for (InventarioProducto ip : body) {
            InventarioProducto newIp = new InventarioProducto();
            newIp.setInventario(inventarioService.findById(foundDepto.getIdDepartamento()).orElse(null));
            newIp.setCantidad(ip.getCantidad());
            newIp.setProducto(productoService.findById(ip.getProducto().getIdProducto()).orElse(null));
            returnAux.add(newIp);
            ipService.save(newIp);
        }


		if (br.hasErrors()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getAllErrors());
		} */


		return ResponseEntity.status(HttpStatus.OK).body(foundDepto);
	}

    @RequestMapping(value="{idDepartamento}", method=RequestMethod.PUT,
         consumes="application/json",
         produces="application/json")
    @ResponseBody
	public ResponseEntity<?> actualizarInventario(@RequestBody @Validated List<InventarioProducto> body , @PathVariable(value = "idDepartamento") int idDepartamento , BindingResult br) {
		Optional<Departamento> depto = deptoService.findById(idDepartamento);
		if(!depto.isPresent()){
			return ResponseEntity.notFound().build();
		}

        for (int i = 0; i < body.size(); i++) {
            System.out.print(body.get(i));
            InventarioProducto foundIP = ipService. findById(body.get(i).getIdInventarioProducto()).orElse(null);

            InventarioProducto aux = new InventarioProducto();
            BeanUtils.copyProperties(body.get(i), aux);
            aux.setIdInventarioProducto(foundIP.getIdInventarioProducto());
            ipService.save(aux);
        }

		return ResponseEntity.status(HttpStatus.OK).body(depto);
	}
	
    @GetMapping("listarInventarios")
	public ResponseEntity<?> listarInventarios() {
		return ResponseEntity.status(HttpStatus.CREATED).body(ipService.findAll());	
	}


    
}
