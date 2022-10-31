package com.TurismoApp.TurismoApp.Models.Services.CalculoPagoService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class TotalesService {


    public int getTotalReserva(LocalDate fechaLlegada , LocalDate fechaEntrega ,int precioDia){
        long diasArriendo = fechaEntrega.until(fechaLlegada, ChronoUnit.DAYS);
        return Math.toIntExact(diasArriendo) * precioDia;
    }
    
}
