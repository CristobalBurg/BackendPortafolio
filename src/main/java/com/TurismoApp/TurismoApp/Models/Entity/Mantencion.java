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

    @OneToMany(mappedBy = "mantencion" , fetch = FetchType.LAZY)
    //@JsonIgnoreProperties("inventarioProducto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @JsonIgnore
    private Set<DepartamentoMantencion> departamentoMantenciones;


    public Mantencion() {
    }

    public Mantencion(int idMantencion, String descripcion, int valor, Set<DepartamentoMantencion> departamentoMantenciones) {
        this.idMantencion = idMantencion;
        this.descripcion = descripcion;
        this.valor = valor;
        this.departamentoMantenciones = departamentoMantenciones;
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

    public Set<DepartamentoMantencion> getDepartamentoMantenciones() {
        return this.departamentoMantenciones;
    }

    public void setDepartamentoMantenciones(Set<DepartamentoMantencion> departamentoMantenciones) {
        this.departamentoMantenciones = departamentoMantenciones;
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

    public Mantencion departamentoMantenciones(Set<DepartamentoMantencion> departamentoMantenciones) {
        setDepartamentoMantenciones(departamentoMantenciones);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idMantencion='" + getIdMantencion() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", valor='" + getValor() + "'" +
            ", departamentoMantenciones='" + getDepartamentoMantenciones() + "'" +
            "}";
    }

    
}
