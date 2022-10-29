package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import com.TurismoApp.TurismoApp.Models.Entity.Multa;

public interface IMultaService {

    public List <Multa> findAll();
    public Optional<Multa> findById(int id);
    public Multa save(Multa multa);
    public void delete(int id);
    
}
