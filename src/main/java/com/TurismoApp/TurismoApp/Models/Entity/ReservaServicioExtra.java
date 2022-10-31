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
@Table(name = "TR_RESERVA_SERVICIO_EXTRA")
public class ReservaServicioExtra {
    

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservaServicioExtra;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL}) 
    @JoinColumn(name = "id_reserva")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    @JsonIgnore
    private Reserva reserva;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @JoinColumn(name = "id_servicio_extra" )
    private ServicioExtra servicioExtra;

    public ReservaServicioExtra() {
    }

    public ReservaServicioExtra(int idReservaServicioExtra, Reserva reserva, ServicioExtra servicioExtra) {
        this.idReservaServicioExtra = idReservaServicioExtra;
        this.reserva = reserva;
        this.servicioExtra = servicioExtra;
    }

    public int getIdReservaServicioExtra() {
        return this.idReservaServicioExtra;
    }

    public void setIdReservaServicioExtra(int idReservaServicioExtra) {
        this.idReservaServicioExtra = idReservaServicioExtra;
    }

    public Reserva getReserva() {
        return this.reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public ServicioExtra getServicioExtra() {
        return this.servicioExtra;
    }

    public void setServicioExtra(ServicioExtra servicioExtra) {
        this.servicioExtra = servicioExtra;
    }

    public ReservaServicioExtra idReservaServicioExtra(int idReservaServicioExtra) {
        setIdReservaServicioExtra(idReservaServicioExtra);
        return this;
    }

    public ReservaServicioExtra reserva(Reserva reserva) {
        setReserva(reserva);
        return this;
    }

    public ReservaServicioExtra servicioExtra(ServicioExtra servicioExtra) {
        setServicioExtra(servicioExtra);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " idReservaServicioExtra='" + getIdReservaServicioExtra() + "'" +
            ", reserva='" + getReserva() + "'" +
            ", servicioExtra='" + getServicioExtra() + "'" +
            "}";
    }

}
