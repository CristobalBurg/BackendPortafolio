package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Dao.RolRepository;
import com.TurismoApp.TurismoApp.Models.Entity.Rol;

@Service
public class RolServiceImpl  implements IRolService{

    @Autowired
    private RolRepository rolDao;

    @Override
    public List<Rol> findAll() {
        return rolDao.findAll();

    }

    @Override
    public Optional<Rol> findById(int id) {
        return rolDao.findById(id);

    }

    @Override
    public Rol save(Rol rol) {
        return rolDao.save(rol);

    }

    @Override
    public void delete(int id) {
        rolDao.deleteById(id);
        
    }
    
}
