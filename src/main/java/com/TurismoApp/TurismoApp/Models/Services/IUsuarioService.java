package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.TurismoApp.TurismoApp.Models.Entity.Usuario;
import com.TurismoApp.TurismoApp.Models.Entity.UsuarioRol;

public interface IUsuarioService {

    public List<Usuario> findAll();
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;
    public void eliminarUsuario(String rutUsuario);
    public Optional<Usuario> getUsuario(String rutUsuario);
    public Usuario actualizaUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    
}
