package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import com.TurismoApp.TurismoApp.Models.Entity.DepartamentoMantencion;

public interface IDepartamentoMantencion {

    public List <DepartamentoMantencion> findAll();
    public Optional<DepartamentoMantencion> findById(int id);
    public DepartamentoMantencion save(DepartamentoMantencion id);
    public void delete(int id);
    
}
