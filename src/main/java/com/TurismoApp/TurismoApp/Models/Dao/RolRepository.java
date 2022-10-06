package com.TurismoApp.TurismoApp.Models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TurismoApp.TurismoApp.Models.Entity.Rol;

public interface RolRepository extends JpaRepository<Rol,Long> {
    
}
