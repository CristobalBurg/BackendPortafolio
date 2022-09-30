package com.TurismoApp.TurismoApp.Models.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;


import javax.persistence.Table;

@Entity
@Table(name = "TR_COMUNA")
public class Comuna {
    @Id
    @Column(name = "id_comuna")
    private int idComuna;
    @Column(name = "id_provincia")
    private int idProvincia;
    @Column(name = "nombre")
    private String nombre;

    public Comuna() {
    }

    public Comuna(int idComuna, int idProvincia, String nombre) {
        this.idComuna = idComuna;
        this.idProvincia = idProvincia;
        this.nombre = nombre;
    }

    public int getIdComuna() {
        return this.idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public int getidProvincia() {
        return this.idProvincia;
    }

    public void setidProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Comuna idComuna(int idComuna) {
        setIdComuna(idComuna);
        return this;
    }

    public Comuna idProvincia(int idProvincia) {
        setidProvincia(idProvincia);
        return this;
    }

    public Comuna nombre(String nombre) {
        setNombre(nombre);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idComuna='" + getIdComuna() + "'" +
            ", idProvincia='" + getidProvincia() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }

    
}
