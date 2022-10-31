package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import com.TurismoApp.TurismoApp.Models.Entity.ReservaPago;

public interface IReservaPagoSerice {


    public List <ReservaPago> findAll();
    public Optional<ReservaPago> findById(int id);
    public ReservaPago save(ReservaPago reservaPago);
    public void delete(int id);
    
}
