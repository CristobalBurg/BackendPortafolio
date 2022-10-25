package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import com.TurismoApp.TurismoApp.Models.Entity.Comuna;
import com.TurismoApp.TurismoApp.Models.Entity.Departamento;

public interface IDeptoService {

    public List<Departamento> findAll();
    public Optional<Departamento> findById(int id);
    public Departamento save(Departamento id);
    public void delete(int id);
    public List<Comuna> findAllComunas();
    public Comuna getComunaById(int id);

}
