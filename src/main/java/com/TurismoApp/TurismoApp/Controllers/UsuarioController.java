package com.TurismoApp.TurismoApp.Controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import com.TurismoApp.TurismoApp.Models.Entity.Rol;
import com.TurismoApp.TurismoApp.Models.Entity.Usuario;
import com.TurismoApp.TurismoApp.Models.Entity.UsuarioRol;
import com.TurismoApp.TurismoApp.Models.Services.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping()
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{

        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();

		if (usuario.getIsAdmin() == 1){
			rol.setidRol(1L);
			rol.setRolNombre("ADMINISTRATIVO");
		} else {
			rol.setidRol(2L);
			rol.setRolNombre("CLIENTE");
		}


        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);
        return usuarioService.guardarUsuario(usuario,usuarioRoles);
    }


	@GetMapping("/{rutUsuario}")
	public ResponseEntity<?> obtenerDepto( @PathVariable(value = "rutUsuario") String rutUsuario) {
		Optional<Usuario> user = usuarioService.getUsuario(rutUsuario);
		if(!user.isPresent()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}


	@GetMapping("/listarUsuarios")
    public List<Usuario> listarUsuarios(){
        return usuarioService.findAll();
    }

    @DeleteMapping("/{rutUsuario}")
    public void eliminarUsuario(@PathVariable("rutUsuario") String usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }

	@PutMapping("/{rutUsuario}")
	public ResponseEntity<?> actualizarCliente(@RequestBody @Validated Usuario body , @PathVariable(value = "rutUsuario") String rutUsuario , BindingResult br) throws Exception {
		Optional<Usuario> usuario = usuarioService.getUsuario(rutUsuario);
		if(!usuario.isPresent()){
			return ResponseEntity.notFound().build();
		} else {
			Usuario updatedUser = new Usuario();
			BeanUtils.copyProperties(body, updatedUser);
			updatedUser.setRutUsuario(usuario.get().getRutUsuario());
			Set<UsuarioRol> usuarioRoles = new HashSet<>();
	
			Rol rol = new Rol();
	
			if (usuario.get().getIsAdmin() == 1){
				rol.setidRol(1L);
				rol.setRolNombre("ADMINISTRATIVO");
			} else {
				rol.setidRol(2L);
				rol.setRolNombre("CLIENTE");
			}
	
	
			UsuarioRol usuarioRol = new UsuarioRol();
			usuarioRol.setUsuario(usuario.get());
			usuarioRol.setRol(rol);
	
			usuarioRoles.add(usuarioRol);
	
			return ResponseEntity.status(HttpStatus.OK).body(usuarioService.actualizaUsuario(updatedUser, usuarioRoles));
		}

	}
    
}
