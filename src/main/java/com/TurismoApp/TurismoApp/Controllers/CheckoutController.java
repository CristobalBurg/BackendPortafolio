package com.TurismoApp.TurismoApp.Controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
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
import com.TurismoApp.TurismoApp.Models.Entity.CheckOut;
import com.TurismoApp.TurismoApp.Models.Entity.Multa;
import com.TurismoApp.TurismoApp.Models.Entity.Pago;
import com.TurismoApp.TurismoApp.Models.Services.ICheckinService;
import com.TurismoApp.TurismoApp.Models.Services.ICheckoutService;
import com.TurismoApp.TurismoApp.Models.Services.IInventarioProductoService;
import com.TurismoApp.TurismoApp.Models.Services.IPagoService;
import com.TurismoApp.TurismoApp.Models.Services.IReservaService;
import com.TurismoApp.TurismoApp.Models.Services.CalculoPagoService.TotalesService;
import com.lowagie.text.DocumentException;

import net.bytebuddy.asm.Advice.Local;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    
    @Autowired
    private ICheckinService checkinService;

    @Autowired
    private ICheckoutService checkoutService;

    @Autowired
    private IPagoService pagoService;

    @Autowired
    private com.TurismoApp.TurismoApp.Models.Services.pdfGenerator.pdfService pdfService;

    @Autowired
    private TotalesService calcuadoService;

    @PostMapping()
    public ResponseEntity<?> crearCheckout(@RequestBody @Validated CheckOut body, BindingResult br)
            throws IOException, DocumentException {

        CheckIn foundCheckin = checkinService.findById(body.getCheckin().getIdCheckIn()).orElse(null);

        CheckOut newCheckout = new CheckOut();
        newCheckout.setCheckin(foundCheckin);
        newCheckout.setFirmado(false);
        Multa newMulta  = new Multa();
        newMulta.setDescripcion(body.getMulta().getDescripcion());
        newMulta.setValor(body.getMulta().getValor());
        newCheckout.setMulta(newMulta);


        if (br.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getAllErrors());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(checkoutService.save(newCheckout));
    }

    @GetMapping("/download/{idCheckout}")
    public ResponseEntity<?> downloadCheckin(@PathVariable(value = "idCheckout") int idCheckout,
            final HttpServletRequest request,
            final HttpServletResponse response) throws DocumentException {
        UUID filename = UUID.randomUUID();
        CheckOut foundCheckout = checkoutService.findById(idCheckout).orElse(null);

        int total = calcuadoService.getTotalReserva(
                foundCheckout.getCheckin().getReserva().getFechaLlegada(),
                foundCheckout.getCheckin().getReserva().getFechaEntrega(),
                foundCheckout.getCheckin().getReserva().getDepartamento().getValorArriendoDia(),
                foundCheckout.getCheckin().getReserva().getReservaServicioExtra());

        ByteArrayOutputStream byteArrayOutputStreamPDF = pdfService.createPdf(false ,foundCheckout.getCheckin().getReserva(), total, foundCheckout.getMulta(),
                request, response);
        ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + filename + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(inputStreamResourcePDF.contentLength()).body(inputStreamResourcePDF);
    } 


    

    
	@GetMapping("/listarCheckouts")
	public ResponseEntity<?> listarReservas() {
		return ResponseEntity.status(HttpStatus.CREATED).body(checkoutService.findAll());	
	}

	@GetMapping("{idCheckout}")
	public ResponseEntity<?> obtenerCheckin( @PathVariable(value = "idCheckout") int idCheckout) {
        Optional<CheckOut> checkout = checkoutService.findById(idCheckout);
		if(!checkout.isPresent()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(checkout);

    }

    @DeleteMapping("{idCheckout}")
	public ResponseEntity<?> eliminarCheckout( @PathVariable(value = "idCheckout") int idCheckout) {
		Optional<CheckOut> checkout = checkoutService.findById(idCheckout);
		if(!checkout.isPresent()){
			return ResponseEntity.notFound().build();
		}
		checkoutService.delete(checkout.get().getIdCheckOut());
		return ResponseEntity.ok().build(); 
	}

    @PostMapping("/confirmar/{idCheckout}")
    public ResponseEntity<?> firmarCheckout (@PathVariable(value = "idCheckout") int idCheckout , @RequestBody @Validated Pago body){
        Optional<CheckOut> checkout = checkoutService.findById(idCheckout);
		if(!checkout.isPresent()){
			return ResponseEntity.notFound().build();
		}

        if (checkout.get().getMulta().getValor() != 0){
            Pago pago = new Pago();
            LocalDate hoy = LocalDate.now();
            pago.setMedioPago(body.getMedioPago());
            pago.setTipoPago(body.getTipoPago());
            pago.setMonto(body.getMonto());
            pago.setFecha(hoy);
            pagoService.save(pago);
        }

        checkout.get().setIdCheckOut(idCheckout);
		checkout.get().setFirmado(true);
        checkoutService.save(checkout.get());
		return ResponseEntity.ok().build(); 

    }
    
}
