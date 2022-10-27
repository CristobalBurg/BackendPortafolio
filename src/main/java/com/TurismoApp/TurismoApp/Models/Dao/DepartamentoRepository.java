package com.TurismoApp.TurismoApp.Models.Dao;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TurismoApp.TurismoApp.Models.Entity.Comuna;
import com.TurismoApp.TurismoApp.Models.Entity.Departamento;




public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    
    @Query("from Comuna")
    public List<Comuna> findAllComunas();


  @Query("FROM Comuna c  where c.idComuna = ?1")
  public Comuna getComunaById(int id);


    
}
