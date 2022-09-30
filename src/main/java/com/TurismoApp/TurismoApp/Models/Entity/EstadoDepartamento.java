package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TR_ESTADO_DEPARTAMENTO")
public class EstadoDepartamento {
    @Id
    @Column(name = "id_estado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstado;
    @Column(name = "estado")
    private String estado;
    @Column(name = "id_mantencion")
    private int idMantencion;

    public EstadoDepartamento() {
    }

    public EstadoDepartamento(int idEstado, String estado, int idMantencion) {
        this.idEstado = idEstado;
        this.estado = estado;
        this.idMantencion = idMantencion;
    }

    public int getIdEstado() {
        return this.idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdMantencion() {
        return this.idMantencion;
    }

    public void setIdMantencion(int idMantencion) {
        this.idMantencion = idMantencion;
    }

    public EstadoDepartamento idEstado(int idEstado) {
        setIdEstado(idEstado);
        return this;
    }

    public EstadoDepartamento estado(String estado) {
        setEstado(estado);
        return this;
    }

    public EstadoDepartamento idMantencion(int idMantencion) {
        setIdMantencion(idMantencion);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idEstado='" + getIdEstado() + "'" +
            ", estado='" + getEstado() + "'" +
            ", idMantencion='" + getIdMantencion() + "'" +
            "}";
    }

}
