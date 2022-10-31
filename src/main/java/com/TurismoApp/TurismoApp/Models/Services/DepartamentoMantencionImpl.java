package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Dao.DepartamentoMantencionRepository;
import com.TurismoApp.TurismoApp.Models.Entity.DepartamentoMantencion;

@Service
public class DepartamentoMantencionImpl implements IDepartamentoMantencion {

    @Autowired
    private DepartamentoMantencionRepository deptoMantDato;

    @Override
    public List<DepartamentoMantencion> findAll() {
        return deptoMantDato.findAll();

    }

    @Override
    public Optional<DepartamentoMantencion> findById(int id) {
        return deptoMantDato.findById(id);

    }

    @Override
    public DepartamentoMantencion save(DepartamentoMantencion deptoMantencion) {
        return deptoMantDato.save(deptoMantencion);

    }

    @Override
    public void delete(int id) {
        deptoMantDato.deleteById(id);

        
    }
    
}
