package com.TurismoApp.TurismoApp.Models.Entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "TR_DEPARTAMENTO")
public class Departamento {
    @Id
    @Column(name="id_departamento")
    @GeneratedValue( strategy = GenerationType.IDENTITY)    
    private int idDepartamento;
    @Column(name="direccion")
    private String direccion;
    @Column(name="ctd_Habitaciones")
    private int ctdHabitaciones;
    @Column(name="ctd_Banos")
    private int ctdBanos;
    @Column(name="valor_arriendo_dia")
    private int valorArriendoDia;

    @Column(name="politicas_condiciones")
    private String politicasCondiciones;

    
    @Column(name="foto")
    private String foto;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "id_comuna")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Comuna comuna;

    @OneToMany(mappedBy = "departamento" , fetch = FetchType.LAZY  ,cascade = {CascadeType.ALL})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    List<InventarioProducto> inventarioProductos;

    @OneToMany(mappedBy = "mantencion" , fetch = FetchType.LAZY  ,cascade = {CascadeType.ALL})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    List<DepartamentoMantencion> departamentoMantenciones;



    public Departamento() {
    }

    public Departamento(int idDepartamento, String direccion, int ctdHabitaciones, int ctdBanos, int valorArriendoDia, String politicasCondiciones, String foto, Comuna comuna, List<InventarioProducto> inventarioProductos, List<DepartamentoMantencion> departamentoMantenciones) {
        this.idDepartamento = idDepartamento;
        this.direccion = direccion;
        this.ctdHabitaciones = ctdHabitaciones;
        this.ctdBanos = ctdBanos;
        this.valorArriendoDia = valorArriendoDia;
        this.politicasCondiciones = politicasCondiciones;
        this.foto = foto;
        this.comuna = comuna;
        this.inventarioProductos = inventarioProductos;
        this.departamentoMantenciones = departamentoMantenciones;
    }

    public int getIdDepartamento() {
        return this.idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCtdHabitaciones() {
        return this.ctdHabitaciones;
    }

    public void setCtdHabitaciones(int ctdHabitaciones) {
        this.ctdHabitaciones = ctdHabitaciones;
    }

    public int getCtdBanos() {
        return this.ctdBanos;
    }

    public void setCtdBanos(int ctdBanos) {
        this.ctdBanos = ctdBanos;
    }

    public int getValorArriendoDia() {
        return this.valorArriendoDia;
    }

    public void setValorArriendoDia(int valorArriendoDia) {
        this.valorArriendoDia = valorArriendoDia;
    }

    public String getPoliticasCondiciones() {
        return this.politicasCondiciones;
    }

    public void setPoliticasCondiciones(String politicasCondiciones) {
        this.politicasCondiciones = politicasCondiciones;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Comuna getComuna() {
        return this.comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public List<InventarioProducto> getInventarioProductos() {
        return this.inventarioProductos;
    }

    public void setInventarioProductos(List<InventarioProducto> inventarioProductos) {
        this.inventarioProductos = inventarioProductos;
    }

    public List<DepartamentoMantencion> getDepartamentoMantenciones() {
        return this.departamentoMantenciones;
    }

    public void setDepartamentoMantenciones(List<DepartamentoMantencion> departamentoMantenciones) {
        this.departamentoMantenciones = departamentoMantenciones;
    }

    public Departamento idDepartamento(int idDepartamento) {
        setIdDepartamento(idDepartamento);
        return this;
    }

    public Departamento direccion(String direccion) {
        setDireccion(direccion);
        return this;
    }

    public Departamento ctdHabitaciones(int ctdHabitaciones) {
        setCtdHabitaciones(ctdHabitaciones);
        return this;
    }

    public Departamento ctdBanos(int ctdBanos) {
        setCtdBanos(ctdBanos);
        return this;
    }

    public Departamento valorArriendoDia(int valorArriendoDia) {
        setValorArriendoDia(valorArriendoDia);
        return this;
    }

    public Departamento politicasCondiciones(String politicasCondiciones) {
        setPoliticasCondiciones(politicasCondiciones);
        return this;
    }

    public Departamento foto(String foto) {
        setFoto(foto);
        return this;
    }

    public Departamento comuna(Comuna comuna) {
        setComuna(comuna);
        return this;
    }

    public Departamento inventarioProductos(List<InventarioProducto> inventarioProductos) {
        setInventarioProductos(inventarioProductos);
        return this;
    }

    public Departamento departamentoMantenciones(List<DepartamentoMantencion> departamentoMantenciones) {
        setDepartamentoMantenciones(departamentoMantenciones);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idDepartamento='" + getIdDepartamento() + "'" +
            ", direccion='" + getDireccion() + "'" +
            ", ctdHabitaciones='" + getCtdHabitaciones() + "'" +
            ", ctdBanos='" + getCtdBanos() + "'" +
            ", valorArriendoDia='" + getValorArriendoDia() + "'" +
            ", politicasCondiciones='" + getPoliticasCondiciones() + "'" +
            ", foto='" + getFoto() + "'" +
            ", comuna='" + getComuna() + "'" +
            ", inventarioProductos='" + getInventarioProductos() + "'" +
            ", departamentoMantenciones='" + getDepartamentoMantenciones() + "'" +
            "}";
    }

    
}
