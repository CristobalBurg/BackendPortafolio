package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import com.TurismoApp.TurismoApp.Models.Entity.Mantencion;

public interface IMantencionService {


    
    public List <Mantencion> findAll();
    public Optional<Mantencion> findById(int id);
    public Mantencion save(Mantencion mantencion);
    public void delete(int id);
    
}
