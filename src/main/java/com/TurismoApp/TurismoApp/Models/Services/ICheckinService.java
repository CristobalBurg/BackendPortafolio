package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import com.TurismoApp.TurismoApp.Models.Entity.CheckIn;

public interface ICheckinService {

    public List <CheckIn> findAll();
    public Optional<CheckIn> findById(int id);
    public CheckIn save(CheckIn id);
    public void delete(int id);

    
}
