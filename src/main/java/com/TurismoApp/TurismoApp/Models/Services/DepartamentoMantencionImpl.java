package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TurismoApp.TurismoApp.Models.Dao.DepartamentoMantencionRepository;
import com.TurismoApp.TurismoApp.Models.Entity.DepartamentoMantencion;

@Service
public class DepartamentoMantencionImpl implements IDepartamentoMantencion {

    @Autowired
    private DepartamentoMantencionRepository deptoMantDato;

    @Override
    @Transactional
    public List<DepartamentoMantencion> findAll() {
        return deptoMantDato.findAll();

    }

    @Override
    @Transactional
    public Optional<DepartamentoMantencion> findById(int id) {
        return deptoMantDato.findById(id);

    }

    @Override
    @Transactional
    public DepartamentoMantencion save(DepartamentoMantencion deptoMantencion) {
        return deptoMantDato.save(deptoMantencion);

    }

    @Override
    @Transactional
    public void delete(int id) {
        deptoMantDato.deleteById(id);

        
    }
    
}
