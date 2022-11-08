package com.TurismoApp.TurismoApp.Models.Services.SimuladorPagosService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Entity.Departamento;
import com.TurismoApp.TurismoApp.Models.Entity.Multa;
import com.TurismoApp.TurismoApp.Models.Entity.Pago;
import com.TurismoApp.TurismoApp.Models.Entity.Reserva;
import com.TurismoApp.TurismoApp.Models.Entity.ReservaPago;
import com.TurismoApp.TurismoApp.Models.Entity.ReservaServicioExtra;
import com.TurismoApp.TurismoApp.Models.Entity.ServicioExtra;
import com.TurismoApp.TurismoApp.Models.Entity.Usuario;
import com.TurismoApp.TurismoApp.Models.Services.IDeptoService;
import com.TurismoApp.TurismoApp.Models.Services.IPagoService;
import com.TurismoApp.TurismoApp.Models.Services.IReservaPagoSerice;
import com.TurismoApp.TurismoApp.Models.Services.IReservaService;
import com.TurismoApp.TurismoApp.Models.Services.IServicioExtra;
import com.TurismoApp.TurismoApp.Models.Services.IUsuarioService;
import com.TurismoApp.TurismoApp.Models.Services.CalculoPagoService.TotalesService;


@Service
public class SimuladorPagosService {


    @Autowired
    private IReservaService rService;
    @Autowired
    private IPagoService pService;
    @Autowired
    private IReservaPagoSerice rpService;
    @Autowired
    private IUsuarioService uService;
    @Autowired
    private IDeptoService dService;
    @Autowired
    private TotalesService tService;

    //SOLO SIMULAR PAGOS SOBRE RESERVAS YA CREADAS , CON ANTICIPO PAGADO
    public void simularPago (int idReserva, String tipoPago , int montoPago, String observaciones) {


	
        Reserva reservaActual = rService.findById(idReserva).orElse(null);

		int total = tService.getTotalReserva(
			reservaActual.getFechaLlegada(),
			reservaActual.getFechaEntrega(),
			reservaActual.getDepartamento().getValorArriendoDia(),
			reservaActual.getReservaServicioExtra());
	

		Usuario usuario = reservaActual.getUsuario();
		Departamento depto = dService.findById(reservaActual.getDepartamento().getIdDepartamento()).orElse(null) ;

		reservaActual.setFechaEntrega(reservaActual.getFechaLlegada());
		reservaActual.setFechaLlegada(reservaActual.getFechaEntrega());
		reservaActual.setDepartamento(depto);
		reservaActual.setUsuario(usuario);
        reservaActual.setReservaServicioExtra(reservaActual.getReservaServicioExtra());

		List<ReservaPago> reservaPagos = reservaActual.getReservaPagos();
		LocalDate hoy = LocalDate.now();
			ReservaPago item = new ReservaPago();
			Pago pago = new Pago();
			pago.setMonto(montoPago);
			pago.setMedioPago( getRandomMedioPago() );
			pago.setTipoPago(tipoPago);
			pago.setFecha(hoy);
			pago.setObservacion(observaciones);
			item.setPago(pago);
			item.setReserva(reservaActual);
			reservaPagos.add(item);

		reservaActual.setReservaPagos(reservaPagos);
        rService.save(reservaActual);

    }
	
	public String getRandomMedioPago(){
		List<String> mediosPago = Arrays.asList("DEBITO", "CREDITO", "EFECTIVO", "CHEQUE");
		Random r = new Random();

		int randomitem = r.nextInt(mediosPago.size());
		String randomElement = mediosPago.get(randomitem);
		return randomElement;
	}

}
