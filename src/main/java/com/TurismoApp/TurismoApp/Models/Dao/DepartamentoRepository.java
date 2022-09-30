package com.TurismoApp.TurismoApp.Models.Dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TurismoApp.TurismoApp.Models.Entity.Comuna;
import com.TurismoApp.TurismoApp.Models.Entity.Departamento;




public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    
    @Query("from Comuna")
    public List<Comuna> findAllComunas();
    
}
