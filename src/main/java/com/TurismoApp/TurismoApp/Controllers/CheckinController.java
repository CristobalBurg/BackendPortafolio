package com.TurismoApp.TurismoApp.Controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TurismoApp.TurismoApp.Models.Entity.CheckIn;
import com.TurismoApp.TurismoApp.Models.Entity.InventarioProducto;
import com.TurismoApp.TurismoApp.Models.Entity.Reserva;
import com.TurismoApp.TurismoApp.Models.Services.ICheckinService;
import com.TurismoApp.TurismoApp.Models.Services.IInventarioProductoService;
import com.TurismoApp.TurismoApp.Models.Services.IReservaService;
import com.TurismoApp.TurismoApp.Models.Services.pdfGenerator.pdfGeneratorService;
import com.lowagie.text.DocumentException;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/checkin")
public class CheckinController {

    @Autowired
    private ICheckinService checkinService;

    @Autowired
    private IReservaService reservaService;

    @Autowired
	private pdfGeneratorService pdfService;

    @Autowired IInventarioProductoService ipSerivce;

    @PostMapping()
	public ResponseEntity<?> crearCheckin( @RequestBody @Validated CheckIn body , BindingResult br) throws IOException, DocumentException {

		Reserva reserva = reservaService.findById(body.getReserva().getIdReserva()).orElse(null);

		CheckIn newCheckIn = new CheckIn();
		newCheckIn.setReserva(reserva);
        newCheckIn.setFirmado(false);

        String html = pdfService.generarTemplateReserva(newCheckIn.getReserva());
        pdfService.generatePdfFromHtml(html);


		if (br.hasErrors()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getAllErrors());
		}


		return ResponseEntity.status(HttpStatus.CREATED).body(checkinService.save(newCheckIn));
	}

	
    
}
