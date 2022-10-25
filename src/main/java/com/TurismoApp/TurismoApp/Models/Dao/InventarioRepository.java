package com.TurismoApp.TurismoApp.Models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TurismoApp.TurismoApp.Models.Entity.Inventario;

public interface InventarioRepository  extends JpaRepository<Inventario , Integer>{
    
}
