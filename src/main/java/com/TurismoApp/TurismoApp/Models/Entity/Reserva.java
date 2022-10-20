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
import javax.persistence.OneToOne;
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
    private String fechaLlegada;
    @Column(name = "fecha_entrega")
    private String fechaEntrega;

    @ManyToOne(fetch = FetchType.LAZY  , cascade = CascadeType.ALL)
    @JoinColumn(name = "id_departamento")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.LAZY  , cascade = CascadeType.ALL)
    @JoinColumn(name = "id_servicio_extra")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private ServicioExtra servicioExtra;

    @ManyToOne(fetch = FetchType.LAZY  , cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pago")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Pago pago;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "rut_usuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Usuario usuario;




    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



    public Reserva() {
    }

    public Reserva(int idReserva, String fechaLlegada, String fechaEntrega, Departamento departamento) {
        this.idReserva = idReserva;
        this.fechaLlegada = fechaLlegada;
        this.fechaEntrega = fechaEntrega;
        this.departamento = departamento;
    }

    
    public Pago getPago() {
        return this.pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public ServicioExtra getServicioExtra() {
        return this.servicioExtra;
    }

    public void setServicioExtra(ServicioExtra servicioExtra) {
        this.servicioExtra = servicioExtra;
    }

    public int getIdReserva() {
        return this.idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
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

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Reserva idReserva(int idReserva) {
        setIdReserva(idReserva);
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

    public Reserva departamento(Departamento departamento) {
        setDepartamento(departamento);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " idReserva='" + getIdReserva() + "'" +
            ", fechaLlegada='" + getFechaLlegada() + "'" +
            ", fechaEntrega='" + getFechaEntrega() + "'" +
            ", departamento='" + getDepartamento() + "'" +
            "}";
    }

   

}
