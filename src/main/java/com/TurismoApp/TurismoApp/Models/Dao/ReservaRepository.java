package com.TurismoApp.TurismoApp.Models.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.TurismoApp.TurismoApp.Models.Entity.Departamento;
import com.TurismoApp.TurismoApp.Models.Entity.Reserva;
import com.TurismoApp.TurismoApp.Models.Entity.ServicioExtra;

public interface ReservaRepository extends JpaRepository <Reserva, Integer > {


    @Query("from Departamento")
    public List<Departamento> findAllDeptos();

    @Query("SELECT s FROM ServicioExtra s  where s.idServicioExtra=?1")
    public ServicioExtra findServicioExtraById(int  id );

    @Modifying
    @Query("delete from Reserva r where r.idReserva = ?1")
    void deleteReservaById(int id);
    
}
