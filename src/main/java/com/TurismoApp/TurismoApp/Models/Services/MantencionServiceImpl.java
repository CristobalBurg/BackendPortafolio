package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TurismoApp.TurismoApp.Models.Dao.MantencionRepository;
import com.TurismoApp.TurismoApp.Models.Entity.Mantencion;

@Service
public class MantencionServiceImpl implements IMantencionService{

    @Autowired
    private MantencionRepository mantencionDao;

    @Override
    @Transactional
    public List<Mantencion> findAll() {
        return mantencionDao.findAll();

    }

    @Override
    @Transactional
    public Optional<Mantencion> findById(int id) {
       return mantencionDao.findById(id);
    }

    @Override
    @Transactional
    public Mantencion save(Mantencion mantencion) {
        return mantencionDao.save(mantencion);
    }

    @Override
    @Transactional
    public void delete(int id) {
        mantencionDao.deleteById(id);
        
    }
    
}
