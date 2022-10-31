package com.TurismoApp.TurismoApp.Models.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TR_SERVICIO_EXTRA")
public class ServicioExtra {
    @Id
    @Column(name="id_servicio_extra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicioExtra;
    @Column(name="rut_transportista")
    private String rutTransportista;
    @Column(name="valor")
    private int valor;
    @Column(name="descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "servicioExtra" , fetch = FetchType.LAZY)
    //@JsonIgnoreProperties("inventarioProducto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @JsonIgnore
    private Set<ReservaServicioExtra> reservaServicioExtra;




    public ServicioExtra() {
    }

    public ServicioExtra(int idServicioExtra, String rutTransportista, int valor, String descripcion, Set<ReservaServicioExtra> reservaServicioExtra) {
        this.idServicioExtra = idServicioExtra;
        this.rutTransportista = rutTransportista;
        this.valor = valor;
        this.descripcion = descripcion;
        this.reservaServicioExtra = reservaServicioExtra;
    }

    public int getIdServicioExtra() {
        return this.idServicioExtra;
    }

    public void setIdServicioExtra(int idServicioExtra) {
        this.idServicioExtra = idServicioExtra;
    }

    public String getRutTransportista() {
        return this.rutTransportista;
    }

    public void setRutTransportista(String rutTransportista) {
        this.rutTransportista = rutTransportista;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<ReservaServicioExtra> getReservaServicioExtra() {
        return this.reservaServicioExtra;
    }

    public void setReservaServicioExtra(Set<ReservaServicioExtra> reservaServicioExtra) {
        this.reservaServicioExtra = reservaServicioExtra;
    }

    public ServicioExtra idServicioExtra(int idServicioExtra) {
        setIdServicioExtra(idServicioExtra);
        return this;
    }

    public ServicioExtra rutTransportista(String rutTransportista) {
        setRutTransportista(rutTransportista);
        return this;
    }

    public ServicioExtra valor(int valor) {
        setValor(valor);
        return this;
    }

    public ServicioExtra descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    public ServicioExtra reservaServicioExtra(Set<ReservaServicioExtra> reservaServicioExtra) {
        setReservaServicioExtra(reservaServicioExtra);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " idServicioExtra='" + getIdServicioExtra() + "'" +
            ", rutTransportista='" + getRutTransportista() + "'" +
            ", valor='" + getValor() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", reservaServicioExtra='" + getReservaServicioExtra() + "'" +
            "}";
    }

    
    
}
