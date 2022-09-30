package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TR_PROVINCIA")
public class Provincia {
    @Id
    @Column(name = "id_provincia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProvincia;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "id_region")
    private int idRegion;

    public Provincia() {
    }
    
    public Provincia(int idProvincia, String provincia, int idRegion) {
        this.idProvincia = idProvincia;
        this.provincia = provincia;
        this.idRegion = idRegion;
    }

    public int getIdProvincia() {
        return this.idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getIdRegion() {
        return this.idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public Provincia idProvincia(int idProvincia) {
        setIdProvincia(idProvincia);
        return this;
    }

    public Provincia provincia(String provincia) {
        setProvincia(provincia);
        return this;
    }

    public Provincia idRegion(int idRegion) {
        setIdRegion(idRegion);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idProvincia='" + getIdProvincia() + "'" +
            ", provincia='" + getProvincia() + "'" +
            ", idRegion='" + getIdRegion() + "'" +
            "}";
    }
    
}
