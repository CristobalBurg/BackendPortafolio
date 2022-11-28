package com.TurismoApp.TurismoApp.Controllers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.TurismoApp.TurismoApp.Models.Entity.ReporteVentas;
import com.TurismoApp.TurismoApp.Models.Entity.Reserva;
import com.TurismoApp.TurismoApp.Models.Services.IReservaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/reportes")
public class ReportesController {

    @Autowired
    private IReservaService rService ;


@GetMapping("/ventas")
@ResponseBody
public ResponseEntity<?> getReservas(@RequestParam String fecha_inicio , @RequestParam String fecha_fin) {

    

    List<ReporteVentas> reporteVentas = rService.getReservasByFecha(fecha_inicio,fecha_fin);


    System.out.println(reporteVentas);

    return ResponseEntity.status(HttpStatus.OK).body(reporteVentas);
    
}
    
}
