package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import com.TurismoApp.TurismoApp.Models.Entity.Inventario;

public interface IInventarioService {

    public List<Inventario> findAll();
    public Optional<Inventario> findById(int id);
    public Inventario save(Inventario id);
    public void delete(int id);

    
}
