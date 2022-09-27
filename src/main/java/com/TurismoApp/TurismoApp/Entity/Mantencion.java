package com.TurismoApp.TurismoApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TR_MANTENCION")
public class Mantencion {
    @Id
    @Column(name = "id_mantencion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMantencion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "valor")
    private int valor;

    public Mantencion() {
    }

    public Mantencion(int idMantencion, String descripcion, int valor) {
        this.idMantencion = idMantencion;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public int getIdMantencion() {
        return this.idMantencion;
    }

    public void setIdMantencion(int idMantencion) {
        this.idMantencion = idMantencion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Mantencion idMantencion(int idMantencion) {
        setIdMantencion(idMantencion);
        return this;
    }

    public Mantencion descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    public Mantencion valor(int valor) {
        setValor(valor);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idMantencion='" + getIdMantencion() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", valor='" + getValor() + "'" +
            "}";
    }

    
}
