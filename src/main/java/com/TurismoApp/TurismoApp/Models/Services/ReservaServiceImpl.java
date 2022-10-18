package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Dao.ReservaRepository;
import com.TurismoApp.TurismoApp.Models.Entity.Departamento;
import com.TurismoApp.TurismoApp.Models.Entity.Reserva;
import com.TurismoApp.TurismoApp.Models.Entity.ServicioExtra;

@Service
public class ReservaServiceImpl implements IReservaService{
    @Autowired
    private ReservaRepository reservaDao;

    @Override
    @Transactional
    public List<Reserva> findAll() {
        return reservaDao.findAll();
 
    }

    @Override
    @Transactional
    public Optional<Reserva> findById(int id) {
        return reservaDao.findById(id);

    }

    @Override
    @Transactional
    public Reserva save(Reserva reserva) {
        return reservaDao.save(reserva);

    }

    @Override
    @Transactional
    public void delete(int id) {
        reservaDao.deleteById(id);
    }

    @Override
    @Transactional
    public List<Departamento> findAllDeptos() {
        return reservaDao.findAllDeptos();

    }

    @Override
    public ServicioExtra findServicioExtraById(int id) {
        return reservaDao.findServicioExtraById(id);

    }

    @Override
    @Transactional
    public void deleteReservaById(int id) {
         reservaDao.deleteReservaById(id);
        
    }
    
}
