package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TR_REGISTRO_FINANCIERO")
public class RegistroFinanciero {

    @Id
    @Column(name = "id_registro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRegistro;
    @Column(name = "id_reserva")
    private int idReserva;
    @Column(name = "id_mantencion")
    private int idMantencion;



    public RegistroFinanciero() {
    }

    public RegistroFinanciero(int idRegistro, int idReserva, int idMantencion) {
        this.idRegistro = idRegistro;
        this.idReserva = idReserva;
        this.idMantencion = idMantencion;
    }

    public int getIdRegistro() {
        return this.idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getIdReserva() {
        return this.idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdMantencion() {
        return this.idMantencion;
    }

    public void setIdMantencion(int idMantencion) {
        this.idMantencion = idMantencion;
    }

    public RegistroFinanciero idRegistro(int idRegistro) {
        setIdRegistro(idRegistro);
        return this;
    }

    public RegistroFinanciero idReserva(int idReserva) {
        setIdReserva(idReserva);
        return this;
    }

    public RegistroFinanciero idMantencion(int idMantencion) {
        setIdMantencion(idMantencion);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " idRegistro='" + getIdRegistro() + "'" +
            ", idReserva='" + getIdReserva() + "'" +
            ", idMantencion='" + getIdMantencion() + "'" +
            "}";
    }
    
}
