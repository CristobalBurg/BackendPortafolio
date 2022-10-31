package com.TurismoApp.TurismoApp.Models.Entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TR_DEPARTAMENTO_MANTENCION")
public class DepartamentoMantencion {
    @Id
    @Column(name = "id_departamento_mantencion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartamentoMantencion;


    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL}) 
    @JoinColumn(name = "id_departamento")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    @JsonIgnore
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @JoinColumn(name = "id_mantencion" )
    private Mantencion mantencion;


    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;


    public DepartamentoMantencion() {
    }

    public DepartamentoMantencion(int idDepartamentoMantencion, Departamento departamento, Mantencion mantencion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idDepartamentoMantencion = idDepartamentoMantencion;
        this.departamento = departamento;
        this.mantencion = mantencion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdDepartamentoMantencion() {
        return this.idDepartamentoMantencion;
    }

    public void setIdDepartamentoMantencion(int idDepartamentoMantencion) {
        this.idDepartamentoMantencion = idDepartamentoMantencion;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Mantencion getMantencion() {
        return this.mantencion;
    }

    public void setMantencion(Mantencion mantencion) {
        this.mantencion = mantencion;
    }

    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public DepartamentoMantencion idDepartamentoMantencion(int idDepartamentoMantencion) {
        setIdDepartamentoMantencion(idDepartamentoMantencion);
        return this;
    }

    public DepartamentoMantencion departamento(Departamento departamento) {
        setDepartamento(departamento);
        return this;
    }

    public DepartamentoMantencion mantencion(Mantencion mantencion) {
        setMantencion(mantencion);
        return this;
    }

    public DepartamentoMantencion fechaInicio(LocalDate fechaInicio) {
        setFechaInicio(fechaInicio);
        return this;
    }

    public DepartamentoMantencion fechaFin(LocalDate fechaFin) {
        setFechaFin(fechaFin);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idDepartamentoMantencion='" + getIdDepartamentoMantencion() + "'" +
            ", departamento='" + getDepartamento() + "'" +
            ", mantencion='" + getMantencion() + "'" +
            ", fechaInicio='" + getFechaInicio() + "'" +
            ", fechaFin='" + getFechaFin() + "'" +
            "}";
    }
 

    
}
