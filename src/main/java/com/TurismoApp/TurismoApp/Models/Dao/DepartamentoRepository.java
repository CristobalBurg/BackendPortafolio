package com.TurismoApp.TurismoApp.Models.Dao;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TurismoApp.TurismoApp.Models.Entity.Comuna;
import com.TurismoApp.TurismoApp.Models.Entity.Departamento;
import com.TurismoApp.TurismoApp.Models.Entity.InventarioProducto;




public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    
    @Query("from Comuna")
    public List<Comuna> findAllComunas();

    @Query("FROM InventarioProducto s  where s.inventario.idInventario = ?1")
  public Set<InventarioProducto> getInventarioBydepto(int id);


    
}
