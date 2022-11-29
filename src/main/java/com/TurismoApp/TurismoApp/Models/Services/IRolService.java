package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import com.TurismoApp.TurismoApp.Models.Entity.Rol;

public interface IRolService {

    public List <Rol> findAll();
    public Optional<Rol> findById(int id);
    public Rol save(Rol rol);
    public void delete(int id);
    
}
