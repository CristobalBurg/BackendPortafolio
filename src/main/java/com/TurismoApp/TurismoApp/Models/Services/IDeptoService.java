package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.TurismoApp.TurismoApp.Models.Entity.Comuna;
import com.TurismoApp.TurismoApp.Models.Entity.Departamento;
import com.TurismoApp.TurismoApp.Models.Entity.InventarioProducto;

public interface IDeptoService {

    public List<Departamento> findAll();
    public Optional<Departamento> findById(int id);
    public Departamento save(Departamento id);
    public void delete(int id);
    public List<Comuna> findAllComunas();

}
