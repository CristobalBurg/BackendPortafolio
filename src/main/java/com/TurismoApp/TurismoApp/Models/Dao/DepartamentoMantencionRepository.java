package com.TurismoApp.TurismoApp.Models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TurismoApp.TurismoApp.Models.Entity.DepartamentoMantencion;

public interface DepartamentoMantencionRepository extends JpaRepository<DepartamentoMantencion , Integer> {
    
}
