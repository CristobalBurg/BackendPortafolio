package com.TurismoApp.TurismoApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TurismoApp.TurismoApp.Configuration.JwtUtils;
import com.TurismoApp.TurismoApp.Models.Entity.JwtRequest;
import com.TurismoApp.TurismoApp.Models.Entity.JwtResponse;
import com.TurismoApp.TurismoApp.Models.Services.UserDetailsServiceImpl;

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
        try {
            autenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Usuario No Encontrado");
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



    
}
