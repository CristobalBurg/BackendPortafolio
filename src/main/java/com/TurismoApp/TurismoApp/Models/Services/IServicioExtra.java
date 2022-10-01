package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;


import com.TurismoApp.TurismoApp.Models.Entity.ServicioExtra;

public interface IServicioExtra {

    public List<ServicioExtra> findAll();
    public Optional<ServicioExtra> findById(int id);
    public ServicioExtra save(ServicioExtra servicioExtra);
    public void delete(int id);

    

    
}
