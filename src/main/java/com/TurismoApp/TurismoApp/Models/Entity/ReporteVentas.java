package com.TurismoApp.TurismoApp.Models.Entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ReporteVentas {

    private BigDecimal id_departamento;
    private BigDecimal dias;
    private BigDecimal ingresos;
    @Temporal(TemporalType.DATE)
    private Date fecha_primera_reserva;
    @Temporal(TemporalType.DATE)
    private Date fecha_ultima_reserva;
    private BigDecimal numero_reservas;
   
    
}
