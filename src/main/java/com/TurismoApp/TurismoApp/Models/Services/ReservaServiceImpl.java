package com.TurismoApp.TurismoApp.Models.Services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Tuple;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Dao.ReservaRepository;
import com.TurismoApp.TurismoApp.Models.Entity.Departamento;
import com.TurismoApp.TurismoApp.Models.Entity.ReporteVentas;
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

    @Override
    @Transactional
    public List<Reserva> checkReserva(LocalDate fechaLlegada, LocalDate fechaEntrega, int idDepartamento) {
        return reservaDao.checkReserva(fechaLlegada, fechaEntrega, idDepartamento);

    }

    @Override
    @Transactional
    public List<ReporteVentas> getReservasByFecha(String fechaLlegada, String fechaEntrega) {
         reservaDao.getReservasByFecha(fechaLlegada, fechaEntrega);
         List<Tuple> reporteTupla = reservaDao.getReservasByFecha(fechaLlegada,fechaEntrega);

         System.out.println(reporteTupla);
    
         List<ReporteVentas> reporteVentasDTO = reporteTupla.stream()
                 .map(t -> new ReporteVentas(
                         t.get(0, BigDecimal.class),  // deptoID
                         t.get(1, BigDecimal.class),  //dias
                         t.get(2, BigDecimal.class), //ingresos
                         t.get(3, Date.class), //fecha1
                         t.get(4, Date.class), //fecha2
                         t.get(5, BigDecimal.class) // numeroReservas
                         ))
                 .collect(Collectors.toList());
         
         return reporteVentasDTO;
    }
    
}
