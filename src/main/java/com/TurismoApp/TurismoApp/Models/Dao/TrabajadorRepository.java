package com.TurismoApp.TurismoApp.Models.Dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.TurismoApp.TurismoApp.Models.Entity.Trabajador;


public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    
}
