package com.TurismoApp.TurismoApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TR_RESERVA")
public class Reserva {
    @Id
    @Column(name = "id_reserva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;
    @Column(name = "rut_cliente")
    private String rutCliente;
    @Column(name = "id_departamento")
    private int idDeparamento;
    @Column(name = "id_servicio_extra")
    private int idServicioExtra;
    @Column(name = "id_pago")
    private int idPago;
    @Column(name = "fecha_llegada")
    private String fechaLlegada;
    @Column(name = "fecha_entrega")
    private String fechaEntrega;

    public Reserva() {
    }

    public Reserva(int idReserva, String rutCliente, int idDeparamento, int idServicioExtra, int idPago,
            String fechaLlegada, String fechaEntrega) {
        this.idReserva = idReserva;
        this.rutCliente = rutCliente;
        this.idDeparamento = idDeparamento;
        this.idServicioExtra = idServicioExtra;
        this.idPago = idPago;
        this.fechaLlegada = fechaLlegada;
        this.fechaEntrega = fechaEntrega;
    }

    public int getIdReserva() {
        return this.idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getRutCliente() {
        return this.rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public int getIdDeparamento() {
        return this.idDeparamento;
    }

    public void setIdDeparamento(int idDeparamento) {
        this.idDeparamento = idDeparamento;
    }

    public int getIdServicioExtra() {
        return this.idServicioExtra;
    }

    public void setIdServicioExtra(int idServicioExtra) {
        this.idServicioExtra = idServicioExtra;
    }

    public int getIdPago() {
        return this.idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getFechaLlegada() {
        return this.fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getFechaEntrega() {
        return this.fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Reserva idReserva(int idReserva) {
        setIdReserva(idReserva);
        return this;
    }

    public Reserva rutCliente(String rutCliente) {
        setRutCliente(rutCliente);
        return this;
    }

    public Reserva idDeparamento(int idDeparamento) {
        setIdDeparamento(idDeparamento);
        return this;
    }

    public Reserva idServicioExtra(int idServicioExtra) {
        setIdServicioExtra(idServicioExtra);
        return this;
    }

    public Reserva idPago(int idPago) {
        setIdPago(idPago);
        return this;
    }

    public Reserva fechaLlegada(String fechaLlegada) {
        setFechaLlegada(fechaLlegada);
        return this;
    }

    public Reserva fechaEntrega(String fechaEntrega) {
        setFechaEntrega(fechaEntrega);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " idReserva='" + getIdReserva() + "'" +
                ", rutCliente='" + getRutCliente() + "'" +
                ", idDeparamento='" + getIdDeparamento() + "'" +
                ", idServicioExtra='" + getIdServicioExtra() + "'" +
                ", idPago='" + getIdPago() + "'" +
                ", fechaLlegada='" + getFechaLlegada() + "'" +
                ", fechaEntrega='" + getFechaEntrega() + "'" +
                "}";
    }

}
