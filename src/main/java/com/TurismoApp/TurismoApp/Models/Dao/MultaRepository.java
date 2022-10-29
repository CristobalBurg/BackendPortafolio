package com.TurismoApp.TurismoApp.Models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TurismoApp.TurismoApp.Models.Entity.Multa;

public interface MultaRepository  extends JpaRepository<Multa, Integer>{
    
}
