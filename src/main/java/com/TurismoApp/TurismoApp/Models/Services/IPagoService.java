package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import com.TurismoApp.TurismoApp.Models.Entity.Pago;

public interface IPagoService  {

    public List <Pago> findAll();
    public Optional<Pago> findById(int id);
    public Pago save(Pago pago);
    public void delete(int id);
    
}
