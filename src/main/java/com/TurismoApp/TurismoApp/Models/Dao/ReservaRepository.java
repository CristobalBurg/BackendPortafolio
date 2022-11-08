package com.TurismoApp.TurismoApp.Models.Dao;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.TurismoApp.TurismoApp.Models.Entity.Departamento;
import com.TurismoApp.TurismoApp.Models.Entity.ReporteVentas;
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

    @Query("select r from Reserva r where r.fechaLlegada >= :fecha_llegada AND r.fechaEntrega <= :fecha_entrega AND r.departamento.idDepartamento = :id_departamento")
    public List<Reserva> checkReserva(@Param("fecha_llegada") LocalDate fechaLlegada, @Param("fecha_entrega") LocalDate fechaEntrega, @Param("id_departamento") int idDepartamento);

    @Query(nativeQuery = true,
     value = "SELECT t1.ID_DEPARTAMENTO, t1.DIAS, t2.INGRESOS ,t1.FECHA_PRIMERA_RESERVA , t1.FECHA_ULTIMA_RESERVA ,t1.NUMERO_RESERVAS FROM (\n" +
     "     SELECT d.ID_DEPARTAMENTO, \n" +
     "     SUM(to_date(r.fecha_entrega, 'dd-mm-yyyy') - to_date(r.fecha_llegada, 'dd-mm-yyyy')) AS DIAS,\n" +
     "     MAX(r.fecha_entrega) as FECHA_ULTIMA_RESERVA,\n" +
     "     MIN(r.fecha_entrega) as FECHA_PRIMERA_RESERVA,\n" +
     "     COUNT(r.id_reserva) as NUMERO_RESERVAS\n" +
     "     FROM TURISMOREAL.TR_DEPARTAMENTO d\n" +
     "     INNER JOIN  TURISMOREAL.TR_RESERVA r ON d.ID_DEPARTAMENTO = r.ID_DEPARTAMENTO\n" +
     "     INNER JOIN  TURISMOREAL.TR_COMUNA cm ON d.ID_COMUNA = cm.ID_COMUNA\n" +
     "     WHERE r.fecha_entrega BETWEEN to_date(:fechaInicio, 'dd-mm-yyyy') AND to_date(:fechaFin, 'dd-mm-yyyy') AND\n" +
     "     GROUP BY d.ID_DEPARTAMENTO \n" +
     "     ) t1\n" +
     "     INNER JOIN (\n" +
     "     SELECT d.ID_DEPARTAMENTO, SUM(p.MONTO) AS INGRESOS FROM  TURISMOREAL.TR_DEPARTAMENTO d\n" +
     "     INNER JOIN  TURISMOREAL.TR_RESERVA r ON d.ID_DEPARTAMENTO = r.ID_DEPARTAMENTO\n" +
     "     INNER JOIN  TURISMOREAL.TR_RESERVA_PAGO rp ON r.ID_RESERVA =rp.ID_RESERVA\n" +
     "     INNER JOIN  TURISMOREAL.TR_PAGO p ON p.ID_PAGO = rp.ID_PAGO\n" +
     "     WHERE r.fecha_entrega BETWEEN to_date(:fechaInicio, 'dd-mm-yyyy') AND to_date(:fechaFin, 'dd-mm-yyyy')\n" +
     "     GROUP BY d.ID_DEPARTAMENTO\n" +
     "     ) t2\n" +
     "     ON t1.ID_DEPARTAMENTO = t2.ID_DEPARTAMENTO")
    public List<Tuple> getReservasByFecha(@Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin);
}
