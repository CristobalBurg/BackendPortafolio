package com.TurismoApp.TurismoApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TR_Acompanante")
public class Acompanante {
    @Id
    @Column(name="rut_acompanante")
    private String rutAcompanante;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;

    public Acompanante() {
    }

    public Acompanante(String rutAcompanante, String nombre, String apellido) {
        this.rutAcompanante = rutAcompanante;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getRutAcompanante() {
        return this.rutAcompanante;
    }

    public void setRutAcompanante(String rutAcompanante) {
        this.rutAcompanante = rutAcompanante;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Acompanante rutAcompanante(String rutAcompanante) {
        setRutAcompanante(rutAcompanante);
        return this;
    }

    public Acompanante nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Acompanante apellido(String apellido) {
        setApellido(apellido);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " rutAcompanante='" + getRutAcompanante() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            "}";
    }

}
