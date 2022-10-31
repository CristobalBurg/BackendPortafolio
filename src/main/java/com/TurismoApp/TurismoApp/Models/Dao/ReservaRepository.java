package com.TurismoApp.TurismoApp.Models.Dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

/*     @Query(value = "SELECT * FROM TURISMOREAL.TR_RESERVA r WHERE r.fecha_llegada >= :fecha_llegada AND r.fecha_entrega <= :fecha_entrega AND r.id_departamento = :id_departamento" , nativeQuery = true) */
    @Query("select r from Reserva r where r.fechaLlegada >= :fecha_llegada AND r.fechaEntrega <= :fecha_entrega AND r.departamento.idDepartamento = :id_departamento")
    public List<Reserva> checkReserva(@Param("fecha_llegada") LocalDate fechaLlegada, @Param("fecha_entrega") LocalDate fechaEntrega, @Param("id_departamento") int idDepartamento);
    
}
