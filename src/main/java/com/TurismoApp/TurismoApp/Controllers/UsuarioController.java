package com.TurismoApp.TurismoApp.Controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import com.TurismoApp.TurismoApp.Models.Dao.RolRepository;
import com.TurismoApp.TurismoApp.Models.Entity.Rol;
import com.TurismoApp.TurismoApp.Models.Entity.Usuario;
import com.TurismoApp.TurismoApp.Models.Entity.UsuarioRol;
import com.TurismoApp.TurismoApp.Models.Services.IRolService;
import com.TurismoApp.TurismoApp.Models.Services.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;
	@Autowired
	private IRolService rolService;

	@Autowired
	private BCryptPasswordEncoder encoder;

    @PostMapping()
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{

		usuario.setPassword(this.encoder.encode(usuario.getPassword()));
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

		Rol rol = rolService.findById( usuario.getIsAdmin()).orElse(null);

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
			updatedUser.setRutUsuario(usuario.get().getRutUsuario());
			updatedUser.setNombre(body.getNombre());
			updatedUser.setApellido(body.getApellido());
			updatedUser.setUsername(body.getUsername());
			updatedUser.setPassword(this.encoder.encode(body.getPassword()));
			updatedUser.setEmail(body.getEmail());
			updatedUser.setTelefono(body.getTelefono());
			updatedUser.setIsAdmin(body.getIsAdmin());
			Rol rol = rolService.findById(body.getIsAdmin() ).orElse(null);

			Set<UsuarioRol> usuarioRoles = new HashSet<>();

			UsuarioRol usuarioRol = new UsuarioRol();
			usuarioRol.setUsuario(usuario.get());
			usuarioRol.setRol(rol);
			usuarioRoles.add(usuarioRol);

	
			return ResponseEntity.status(HttpStatus.OK).body(usuarioService.actualizaUsuario(updatedUser, usuarioRoles));
		}

	}
    
}
