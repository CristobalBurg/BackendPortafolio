package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import com.TurismoApp.TurismoApp.Models.Entity.InventarioProducto;

public interface IInventarioProductoService {

    public List<InventarioProducto> findAll();
    public Optional<InventarioProducto> findById(int id);
    public InventarioProducto save(InventarioProducto id);
    public void delete(int id);
    public List<InventarioProducto> findByDeptoId(int id);
    
}
