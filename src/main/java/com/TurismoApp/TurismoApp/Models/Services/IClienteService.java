package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import com.TurismoApp.TurismoApp.Models.Entity.Cliente;

public interface IClienteService {

    public List<Cliente> findAll();
    public Optional<Cliente> findById(String id);
    public Cliente save(Cliente id);
    public void delete(String id);
    
}
