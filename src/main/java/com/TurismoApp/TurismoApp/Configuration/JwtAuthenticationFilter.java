package com.TurismoApp.TurismoApp.Configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.TurismoApp.TurismoApp.Models.Services.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl usuarioService;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String reqTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;

        if(reqTokenHeader != null && reqTokenHeader.startsWith("Bearer ")){
            System.out.println("1");

            jwtToken = reqTokenHeader.substring(7);

            try {
                username = this.jwtUtils.extractUsername(jwtToken);
                
            } catch (ExpiredJwtException e) {
                System.out.println("Token Expirado");
            } catch (Exception e){
                e.printStackTrace();

            }
        } 

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            System.out.println("2");


            UserDetails userDetails = this.usuarioService.loadUserByUsername(username);
            if (this.jwtUtils.validateToken(jwtToken, userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails , null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            } else {
                System.out.println("Token Invalido");
            }

        }
        filterChain.doFilter(request, response);

        System.out.println(request.getHeader("Authorization"));

    }


    
}
