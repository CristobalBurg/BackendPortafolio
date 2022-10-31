package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TurismoApp.TurismoApp.Models.Dao.PagoRepository;
import com.TurismoApp.TurismoApp.Models.Entity.Pago;
@Service
public class PagoServiceImpl implements IPagoService {

    @Autowired
    private PagoRepository pagoDao;

    @Override
    @Transactional
    public List<Pago> findAll() {
        return pagoDao.findAll();

    }

    @Override
    @Transactional
    public Optional<Pago> findById(int id) {
        return pagoDao.findById(id);

    }

    @Override
    @Transactional
    public Pago save(Pago pago) {
        return pagoDao.save(pago);
    }

    @Override
    @Transactional
    public void delete(int id) {
      pagoDao.deleteById(id);
        
    }
    
}
