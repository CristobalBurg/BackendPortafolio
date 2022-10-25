package com.TurismoApp.TurismoApp.Models.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TurismoApp.TurismoApp.Models.Entity.InventarioProducto;

public interface InventarioProductoRepository extends JpaRepository<InventarioProducto , Integer> {


    @Query("SELECT ip FROM InventarioProducto ip  where ip.inventario.idInventario=?1")
    public List<InventarioProducto> findByDeptoId(int  id );
    
    
}
