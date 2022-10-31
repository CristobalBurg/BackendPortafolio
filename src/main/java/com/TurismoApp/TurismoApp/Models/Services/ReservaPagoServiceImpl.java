package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Dao.ReservaPagoRepository;
import com.TurismoApp.TurismoApp.Models.Entity.ReservaPago;

@Service
public class ReservaPagoServiceImpl implements IReservaPagoSerice {

    @Autowired
    private ReservaPagoRepository rpDao;

    @Override
    public List<ReservaPago> findAll() {
        return rpDao.findAll();

    }

    @Override
    public Optional<ReservaPago> findById(int id) {
        return rpDao.findById(id);

    }

    @Override
    public ReservaPago save(ReservaPago reservaPago) {
        return rpDao.save(reservaPago);

    }

    @Override
    public void delete(int id) {
        rpDao.deleteById(id);
        
    }
    
}
