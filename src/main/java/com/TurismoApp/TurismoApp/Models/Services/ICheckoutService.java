package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import com.TurismoApp.TurismoApp.Models.Entity.CheckOut;

public interface ICheckoutService {


    public List <CheckOut> findAll();
    public Optional<CheckOut> findById(int id);
    public CheckOut save(CheckOut checkout);
    public void delete(int id);
    
}
