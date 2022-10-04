package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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


    public ServicioExtra() {
    }

    public ServicioExtra(int idServicioExtra, String rutTransportista, int valor) {
        this.idServicioExtra = idServicioExtra;
        this.rutTransportista = rutTransportista;
        this.valor = valor;
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



    @Override
    public String toString() {
        return "{" +
            " idServicioExtra='" + getIdServicioExtra() + "'" +
            ", rutTransportista='" + getRutTransportista() + "'" +
            ", valor='" + getValor() + "'" +
            "}";
    }

    
}
