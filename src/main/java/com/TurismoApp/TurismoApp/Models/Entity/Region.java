package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TR_REGION")
public class Region {
    @Id
    @Column(name = "id_region")
    private int idRegion;
    @Column(name = "nombre")
    private String nombre;

    public Region() {
    }

    public Region(int idRegion, String nombre) {
        this.idRegion = idRegion;
        this.nombre = nombre;
    }

    public int getIdRegion() {
        return this.idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Region idRegion(int idRegion) {
        setIdRegion(idRegion);
        return this;
    }

    public Region nombre(String nombre) {
        setNombre(nombre);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idRegion='" + getIdRegion() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }

    
}
