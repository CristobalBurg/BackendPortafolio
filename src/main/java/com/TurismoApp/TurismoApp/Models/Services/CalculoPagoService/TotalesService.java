package com.TurismoApp.TurismoApp.Models.Services.CalculoPagoService;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class TotalesService {


    public int getTotalReserva(String fechaLlegada , String fechaEntrega ,int precioDia){

        LocalDate  llegada = LocalDate.parse(fechaLlegada);
        LocalDate  entrega = LocalDate.parse(fechaEntrega);
        long diasArriendo = entrega.until(llegada, ChronoUnit.DAYS);
        
        return Math.toIntExact(diasArriendo) * precioDia;
    }
    
}
