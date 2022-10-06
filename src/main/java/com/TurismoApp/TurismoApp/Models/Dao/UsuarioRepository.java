package com.TurismoApp.TurismoApp.Models.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TurismoApp.TurismoApp.Models.Entity.Rol;
import com.TurismoApp.TurismoApp.Models.Entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario , String> {

    public Usuario findByUsername(String username);
    @Query("select u from Usuario u where u.username=?1")
    public Usuario findByUsername2(String username);
    @Query("from Rol")
    public List<Rol> findAllRoles();
    
}
