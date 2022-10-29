package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Dao.MultaRepository;
import com.TurismoApp.TurismoApp.Models.Entity.Multa;

@Service
public class MultaServiceImpl implements IMultaService {

    @Autowired
    private MultaRepository multaDao;

    @Override
    public List<Multa> findAll() {
        return multaDao.findAll();

    }

    @Override
    public Optional<Multa> findById(int id) {
        return multaDao.findById(id);

    }

    @Override
    public Multa save(Multa multa) {
        return multaDao.save(multa);

    }

    @Override
    public void delete(int id) {
        multaDao.deleteById(id);
        
    }
    
}
