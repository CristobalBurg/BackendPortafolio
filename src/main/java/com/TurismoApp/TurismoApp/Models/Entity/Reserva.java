package com.TurismoApp.TurismoApp.Models.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TR_RESERVA")
public class Reserva {
    @Id
    @Column(name = "id_reserva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;



    @Column(name = "fecha_llegada")
    private LocalDate fechaLlegada;
    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @ManyToOne(fetch = FetchType.LAZY  , cascade = CascadeType.ALL)
    @JoinColumn(name = "id_departamento")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.LAZY  , cascade = CascadeType.ALL )
    @JoinColumn(name = "rut_usuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Usuario usuario;

    @OneToMany(mappedBy = "reserva" , fetch = FetchType.LAZY  ,cascade = {CascadeType.ALL})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    List <ReservaServicioExtra> reservaServicioExtra;

    @OneToMany(mappedBy = "pago", fetch = FetchType.LAZY  , cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private List<ReservaPago> reservaPagos;



    public Reserva() {
    }

    public Reserva(int idReserva, LocalDate fechaLlegada, LocalDate fechaEntrega, Departamento departamento, Usuario usuario, List<ReservaServicioExtra> reservaServicioExtra, List<ReservaPago> reservaPagos) {
        this.idReserva = idReserva;
        this.fechaLlegada = fechaLlegada;
        this.fechaEntrega = fechaEntrega;
        this.departamento = departamento;
        this.usuario = usuario;
        this.reservaServicioExtra = reservaServicioExtra;
        this.reservaPagos = reservaPagos;
    }

    public int getIdReserva() {
        return this.idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaLlegada() {
        return this.fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public LocalDate getFechaEntrega() {
        return this.fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ReservaServicioExtra> getReservaServicioExtra() {
        return this.reservaServicioExtra;
    }

    public void setReservaServicioExtra(List<ReservaServicioExtra> reservaServicioExtra) {
        this.reservaServicioExtra = reservaServicioExtra;
    }

    public List<ReservaPago> getReservaPagos() {
        return this.reservaPagos;
    }

    public void setReservaPagos(List<ReservaPago> reservaPagos) {
        this.reservaPagos = reservaPagos;
    }

    public Reserva idReserva(int idReserva) {
        setIdReserva(idReserva);
        return this;
    }

    public Reserva fechaLlegada(LocalDate fechaLlegada) {
        setFechaLlegada(fechaLlegada);
        return this;
    }

    public Reserva fechaEntrega(LocalDate fechaEntrega) {
        setFechaEntrega(fechaEntrega);
        return this;
    }

    public Reserva departamento(Departamento departamento) {
        setDepartamento(departamento);
        return this;
    }

    public Reserva usuario(Usuario usuario) {
        setUsuario(usuario);
        return this;
    }

    public Reserva reservaServicioExtra(List<ReservaServicioExtra> reservaServicioExtra) {
        setReservaServicioExtra(reservaServicioExtra);
        return this;
    }

    public Reserva reservaPagos(List<ReservaPago> reservaPagos) {
        setReservaPagos(reservaPagos);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idReserva='" + getIdReserva() + "'" +
            ", fechaLlegada='" + getFechaLlegada() + "'" +
            ", fechaEntrega='" + getFechaEntrega() + "'" +
            ", departamento='" + getDepartamento() + "'" +
            ", usuario='" + getUsuario() + "'" +
            ", reservaServicioExtra='" + getReservaServicioExtra() + "'" +
            ", reservaPagos='" + getReservaPagos() + "'" +
            "}";
    }

        
   

}
