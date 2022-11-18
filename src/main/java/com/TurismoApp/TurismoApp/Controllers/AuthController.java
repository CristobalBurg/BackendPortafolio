package com.TurismoApp.TurismoApp.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TurismoApp.TurismoApp.Configuration.JwtUtils;
import com.TurismoApp.TurismoApp.Models.Entity.JwtRequest;
import com.TurismoApp.TurismoApp.Models.Entity.JwtResponse;
import com.TurismoApp.TurismoApp.Models.Entity.Usuario;
import com.TurismoApp.TurismoApp.Models.Services.UserDetailsServiceImpl;
import com.nimbusds.jose.shaded.json.JSONObject;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl usuarioService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken( @RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println(jwtRequest.getUsername());
        System.out.println(jwtRequest.getPassword());

        try {
            autenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
            
        } catch (Exception e) {
            e.printStackTrace();
            JSONObject resp = new JSONObject();
			resp.put("error", true);
			resp.put("mensaje", "Usuario No encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
        }
        UserDetails userDetails = this.usuarioService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void autenticar (String username , String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            
        } catch (DisabledException e) {
            throw new Exception("Usuario Deshabilitado" + e.getMessage());

        } catch (BadCredentialsException e){
            throw new Exception("Credenciales Incorrectas" + e.getMessage());
        }

    }
    @GetMapping("/current-user")
    public Usuario obtenerUsuarioActual (Principal principal){
        return (Usuario) this.usuarioService.loadUserByUsername(principal.getName());

    }



    
}
