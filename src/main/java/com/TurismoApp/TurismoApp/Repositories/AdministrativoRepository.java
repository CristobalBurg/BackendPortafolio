package com.TurismoApp.TurismoApp.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.TurismoApp.TurismoApp.Entity.Trabajador;


public interface AdministrativoRepository extends JpaRepository<Trabajador, Long> {
    
}
