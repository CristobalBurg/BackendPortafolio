package com.TurismoApp.TurismoApp.Models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TurismoApp.TurismoApp.Models.Entity.Mantencion;

public interface MantencionRepository extends JpaRepository<Mantencion , Integer> {
    
}
