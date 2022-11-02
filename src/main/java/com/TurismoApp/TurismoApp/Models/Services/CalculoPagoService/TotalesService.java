package com.TurismoApp.TurismoApp.Models.Services.CalculoPagoService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Entity.ReservaServicioExtra;

@Service
public class TotalesService {


    public int getTotalReserva(
        LocalDate fechaLlegada , 
        LocalDate fechaEntrega , 
        int precioDia, 
        List <ReservaServicioExtra> serviciosExtras
        ){
        int totalServicioExtra = 0;
        for (ReservaServicioExtra item : serviciosExtras) {
            totalServicioExtra += item.getServicioExtra().getValor();

        }
        long diasArriendo = fechaLlegada.until(fechaEntrega, ChronoUnit.DAYS);
        return (Math.toIntExact(diasArriendo) * precioDia) + totalServicioExtra ;
    }
    
}
