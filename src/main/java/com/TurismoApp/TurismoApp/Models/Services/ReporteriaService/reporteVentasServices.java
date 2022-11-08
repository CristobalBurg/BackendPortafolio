package com.TurismoApp.TurismoApp.Models.Services.ReporteriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Services.IMultaService;
import com.TurismoApp.TurismoApp.Models.Services.IPagoService;

@Service
public class reporteVentasServices {


    @Autowired
    private IPagoService pagoService;

    @Autowired
    private IMultaService multaService;



    
    
}
