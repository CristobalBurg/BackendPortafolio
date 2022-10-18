package com.TurismoApp.TurismoApp.Models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TurismoApp.TurismoApp.Models.Entity.Transportista;

public interface TransportistaRepository extends JpaRepository<Transportista , String> {
    
}
