package com.TurismoApp.TurismoApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TR_COMUNA")
public class Comuna {
    @Id
    @Column(name = "id_comuna")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComuna;
    @Column(name = "id_region")
    private int idRegion;
    @Column(name = "nombre")
    private String nombre;

    public Comuna() {
    }

    public Comuna(int idComuna, int idRegion, String nombre) {
        this.idComuna = idComuna;
        this.idRegion = idRegion;
        this.nombre = nombre;
    }

    public int getIdComuna() {
        return this.idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
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

    public Comuna idComuna(int idComuna) {
        setIdComuna(idComuna);
        return this;
    }

    public Comuna idRegion(int idRegion) {
        setIdRegion(idRegion);
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
            ", idRegion='" + getIdRegion() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }

    
}
