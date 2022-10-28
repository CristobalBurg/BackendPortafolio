package com.TurismoApp.TurismoApp.Controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TurismoApp.TurismoApp.Models.Entity.CheckIn;
import com.TurismoApp.TurismoApp.Models.Entity.Reserva;
import com.TurismoApp.TurismoApp.Models.Services.ICheckinService;
import com.TurismoApp.TurismoApp.Models.Services.IInventarioProductoService;
import com.TurismoApp.TurismoApp.Models.Services.IReservaService;
import com.TurismoApp.TurismoApp.Models.Services.CalculoPagoService.TotalesService;
import com.TurismoApp.TurismoApp.Models.Services.pdfGenerator.pdfService;
import com.lowagie.text.DocumentException;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/checkin")
public class CheckinController {

    @Autowired
    private ICheckinService checkinService;

    @Autowired
    private IReservaService reservaService;

    @Autowired
    private IInventarioProductoService ipSerivce;

    @Autowired
    private pdfService pdfService;

    @Autowired
    private TotalesService calcuadoService;

    @PostMapping()
    public ResponseEntity<?> crearCheckin(@RequestBody @Validated CheckIn body, BindingResult br)
            throws IOException, DocumentException {

        Reserva reserva = reservaService.findById(body.getReserva().getIdReserva()).orElse(null);

        CheckIn newCheckIn = new CheckIn();
        newCheckIn.setReserva(reserva);
        newCheckIn.setFirmado(false);

        if (br.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getAllErrors());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(checkinService.save(newCheckIn));
    }

    @GetMapping("/download/{idCheckin}")
    public ResponseEntity<?> downloadCheckin(@PathVariable(value = "idCheckin") int idCheckin,
            final HttpServletRequest request,
            final HttpServletResponse response) throws DocumentException {
        UUID filename = UUID.randomUUID();
        CheckIn foundCheckin = checkinService.findById(idCheckin).orElse(null);

        int total = calcuadoService.getTotalReserva(
                foundCheckin.getReserva().getFechaLlegada(),
                foundCheckin.getReserva().getFechaEntrega(),
                foundCheckin.getReserva().getDepartamento().getValorArriendoDia());

        ByteArrayOutputStream byteArrayOutputStreamPDF = pdfService.createPdf(foundCheckin.getReserva(), total,
                request, response);
        ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + filename + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(inputStreamResourcePDF.contentLength()).body(inputStreamResourcePDF);

    }

    
	@GetMapping("/listarCheckins")
	public ResponseEntity<?> listarReservas() {
		return ResponseEntity.status(HttpStatus.CREATED).body(checkinService.findAll());	
	}

	@GetMapping("{idCheckin}")
	public ResponseEntity<?> obtenerCheckin( @PathVariable(value = "idCheckin") int idCheckin) {
        Optional<CheckIn> servicio = checkinService.findById(idCheckin);
		if(!servicio.isPresent()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(servicio);

    }

    @DeleteMapping("{idCheckin}")
	public ResponseEntity<?> eliminarReserva( @PathVariable(value = "idCheckin") int idCheckin) {
		Optional<CheckIn> checkin = checkinService.findById(idCheckin);
		if(!checkin.isPresent()){
			return ResponseEntity.notFound().build();
		}
		checkinService.delete(checkin.get().getIdCheckIn());
		return ResponseEntity.ok().build(); 
	}
}
