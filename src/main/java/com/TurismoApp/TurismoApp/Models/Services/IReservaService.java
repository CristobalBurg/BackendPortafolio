package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import com.TurismoApp.TurismoApp.Models.Entity.Departamento;
import com.TurismoApp.TurismoApp.Models.Entity.Reserva;
import com.TurismoApp.TurismoApp.Models.Entity.ServicioExtra;

public interface IReservaService {

    public List<Reserva> findAll();
    public Optional<Reserva> findById(int id);
    public Reserva save(Reserva reserva);
    public void delete(int id);
    public List<Departamento> findAllDeptos();
    public ServicioExtra findServicioExtraById( int id);
    public void deleteReservaById(int id);
    
}
