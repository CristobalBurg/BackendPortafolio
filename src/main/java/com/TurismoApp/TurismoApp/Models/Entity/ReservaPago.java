package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TR_RESERVA_PAGO")
public class ReservaPago {

    @Id
    @Column(name ="id_reserva_pago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservaPago;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL}) 
    @JoinColumn(name = "id_reserva")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    @JsonIgnore
    private Reserva reserva;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_pago" )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private Pago pago;

    public ReservaPago() {
    }

    public ReservaPago(int idReservaPago, Reserva reserva, Pago pago) {
        this.idReservaPago = idReservaPago;
        this.reserva = reserva;
        this.pago = pago;
    }

    public int getIdReservaPago() {
        return this.idReservaPago;
    }

    public void setIdReservaPago(int idReservaPago) {
        this.idReservaPago = idReservaPago;
    }

    public Reserva getReserva() {
        return this.reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Pago getPago() {
        return this.pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public ReservaPago idReservaPago(int idReservaPago) {
        setIdReservaPago(idReservaPago);
        return this;
    }

    public ReservaPago reserva(Reserva reserva) {
        setReserva(reserva);
        return this;
    }

    public ReservaPago pago(Pago pago) {
        setPago(pago);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idReservaPago='" + getIdReservaPago() + "'" +
            ", reserva='" + getReserva() + "'" +
            ", pago='" + getPago() + "'" +
            "}";
    }
    
}
