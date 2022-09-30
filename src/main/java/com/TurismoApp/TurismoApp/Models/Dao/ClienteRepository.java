package com.TurismoApp.TurismoApp.Models.Dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.TurismoApp.TurismoApp.Models.Entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, String> {

    
}
