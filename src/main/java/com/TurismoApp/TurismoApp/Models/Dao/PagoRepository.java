package com.TurismoApp.TurismoApp.Models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TurismoApp.TurismoApp.Models.Entity.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
    
}
