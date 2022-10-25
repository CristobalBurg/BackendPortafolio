package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import com.TurismoApp.TurismoApp.Models.Entity.Producto;

public interface IProductoService {

    public List <Producto> findAll();
    public Optional<Producto> findById(int id);
    public Producto save(Producto id);
    public void delete(int id);
    
}
