package com.TurismoApp.TurismoApp.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.TurismoApp.TurismoApp.Entity.Trabajador;


public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    
}
