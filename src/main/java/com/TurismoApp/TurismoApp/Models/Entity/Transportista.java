package com.TurismoApp.TurismoApp.Models.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "TR_TRANSPORTISTA")
public class Transportista {
    @Id
    @Column(name = "rut_transportista")
    private String rutTransportista;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "vehiculo")
    private String vehiculo;
    @Column(name = "fecha_desde")
    private String fechaDesde;
    @Column(name = "fecha_hasta")
    private String fechaHasta;
    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date modified;

    public Transportista() {
    }

    public Transportista(String rutTransportista, String nombre, String apellido, String vehiculo, String fechaDesde,
            String fechaHasta) {
        this.rutTransportista = rutTransportista;
        this.nombre = nombre;
        this.apellido = apellido;
        this.vehiculo = vehiculo;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public String getRutTransportista() {
        return this.rutTransportista;
    }

    public void setRutTransportista(String rutTransportista) {
        this.rutTransportista = rutTransportista;
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

    public String getVehiculo() {
        return this.vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getFechaDesde() {
        return this.fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return this.fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Transportista rutTransportista(String rutTransportista) {
        setRutTransportista(rutTransportista);
        return this;
    }

    public Transportista nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Transportista apellido(String apellido) {
        setApellido(apellido);
        return this;
    }

    public Transportista Vehiculo(String vehiculo) {
        setVehiculo(vehiculo);
        return this;
    }

    public Transportista fechaDesde(String fechaDesde) {
        setFechaDesde(fechaDesde);
        return this;
    }

    public Transportista fechaHasta(String fechaHasta) {
        setFechaHasta(fechaHasta);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " rutTransportista='" + getRutTransportista() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", apellido='" + getApellido() + "'" +
                ", Vehiculo='" + getVehiculo() + "'" +
                ", fechaDesde='" + getFechaDesde() + "'" +
                ", fechaHasta='" + getFechaHasta() + "'" +
                "}";
    }

}
