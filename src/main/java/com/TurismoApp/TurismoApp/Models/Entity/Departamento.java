package com.TurismoApp.TurismoApp.Models.Entity;

import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "departamento")
    @JsonIgnore()
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Set<Inventario> inventario;



    public Departamento(Departamento depto) {
        this.idDepartamento = depto.idDepartamento;
        this.comuna = depto.comuna;
        this.direccion = depto.direccion;
        this.ctdHabitaciones = depto.ctdHabitaciones;
        this.ctdBanos = depto.ctdBanos;
        this.valorArriendoDia = depto.valorArriendoDia;
        this.inventario = depto.inventario;
        this.politicasCondiciones = depto.politicasCondiciones;
    }


    public Departamento() {
    }

    public Departamento(int idDepartamento, String direccion, int ctdHabitaciones, int ctdBanos, int valorArriendoDia, String politicasCondiciones, String foto, Comuna comuna, Set<Inventario> inventario) {
        this.idDepartamento = idDepartamento;
        this.direccion = direccion;
        this.ctdHabitaciones = ctdHabitaciones;
        this.ctdBanos = ctdBanos;
        this.valorArriendoDia = valorArriendoDia;
        this.politicasCondiciones = politicasCondiciones;
        this.foto = foto;
        this.comuna = comuna;
        this.inventario = inventario;
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

    public Set<Inventario> getInventario() {
        return this.inventario;
    }

    public void setInventario(Set<Inventario> inventario) {
        this.inventario = inventario;
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

    public Departamento inventario(Set<Inventario> inventario) {
        setInventario(inventario);
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
            ", inventario='" + getInventario() + "'" +
            "}";
    }


    
}
