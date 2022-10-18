package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import com.TurismoApp.TurismoApp.Models.Entity.Transportista;

public interface ITransportistaService {

    
    public List<Transportista> findAll();
    public Optional<Transportista> findById(String rut);
    public Transportista save(Transportista reserva);
    public void delete(String rut);
    
}
