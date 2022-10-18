package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Dao.TransportistaRepository;
import com.TurismoApp.TurismoApp.Models.Entity.Transportista;

@Service
public class TransportistaServiceImpl implements ITransportistaService {

    @Autowired
    public TransportistaRepository transportistaDao;

    @Override
    public List<Transportista> findAll() {
        return transportistaDao.findAll();

    }

    @Override
    public Optional<Transportista> findById(String rut) {
        return transportistaDao.findById(rut);

    }

    @Override
    public Transportista save(Transportista transportista) {
        return transportistaDao.save(transportista);

    }

    @Override
    public void delete(String rut) {
        transportistaDao.deleteById(rut);
        
    }
    
}
