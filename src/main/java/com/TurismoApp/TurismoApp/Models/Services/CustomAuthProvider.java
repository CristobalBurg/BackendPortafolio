package com.TurismoApp.TurismoApp.Models.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthProvider implements AuthenticationProvider {
    @Autowired
    private UserDetailsServiceImpl usuarioService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("3");

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails user = usuarioService.loadUserByUsername(username);
        return checkPassword (user , password);
    }

    private Authentication checkPassword(UserDetails user, String rawPassword) {
        if (passwordEncoder.matches(rawPassword, user.getPassword())){
            return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword() , user.getAuthorities());
        } else {
            throw new BadCredentialsException("Credenciales Incorrectas");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    
}
