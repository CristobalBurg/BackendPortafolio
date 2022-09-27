package com.TurismoApp.TurismoApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TR_DEPARTAMENTO")
public class Departamento {
    @Id
    @Column(name="id_departamento")
    @GeneratedValue( strategy = GenerationType.IDENTITY)    
    private int idDeparamento;
    @Column(name="id_region")
    private int idRegion;
    @Column(name="id_comuna")
    private int idComuna;
    @Column(name="direccion")
    private String direccion;
    @Column(name="ctd_Habitaciones")
    private int ctdHabitaciones;
    @Column(name="ctd_Banos")
    private int ctdBanos;
    @Column(name="valor_arriendo_dia")
    private int valorArriendoDia;
    @Column(name="id_inventario")
    private int idInventario;
    @Column(name="politicas_condiciones")
    private String politicasCondiciones;

    public Departamento() {
    }

    public Departamento(int idDeparamento, int idRegion, int idComuna, String direccion, int ctdHabitaciones, int ctdBanos, int valorArriendoDia, int idInventario, String politicasCondiciones) {
        this.idDeparamento = idDeparamento;
        this.idRegion = idRegion;
        this.idComuna = idComuna;
        this.direccion = direccion;
        this.ctdHabitaciones = ctdHabitaciones;
        this.ctdBanos = ctdBanos;
        this.valorArriendoDia = valorArriendoDia;
        this.idInventario = idInventario;
        this.politicasCondiciones = politicasCondiciones;
    }

    public int getIdDeparamento() {
        return this.idDeparamento;
    }

    public void setIdDeparamento(int idDeparamento) {
        this.idDeparamento = idDeparamento;
    }

    public int getIdRegion() {
        return this.idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public int getidComuna() {
        return this.idComuna;
    }

    public void setidComuna(int idComuna) {
        this.idComuna = idComuna;
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

    public int getIdInventario() {
        return this.idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getPoliticasCondiciones() {
        return this.politicasCondiciones;
    }

    public void setPoliticasCondiciones(String politicasCondiciones) {
        this.politicasCondiciones = politicasCondiciones;
    }

    public Departamento idDeparamento(int idDeparamento) {
        setIdDeparamento(idDeparamento);
        return this;
    }

    public Departamento idRegion(int idRegion) {
        setIdRegion(idRegion);
        return this;
    }

    public Departamento idComuna(int idComuna) {
        setidComuna(idComuna);
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

    public Departamento idInventario(int idInventario) {
        setIdInventario(idInventario);
        return this;
    }

    public Departamento politicasCondiciones(String politicasCondiciones) {
        setPoliticasCondiciones(politicasCondiciones);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " idDeparamento='" + getIdDeparamento() + "'" +
            ", idRegion='" + getIdRegion() + "'" +
            ", idComuna='" + getidComuna() + "'" +
            ", direccion='" + getDireccion() + "'" +
            ", ctdHabitaciones='" + getCtdHabitaciones() + "'" +
            ", ctdBanos='" + getCtdBanos() + "'" +
            ", valorArriendoDia='" + getValorArriendoDia() + "'" +
            ", idInventario='" + getIdInventario() + "'" +
            ", politicasCondiciones='" + getPoliticasCondiciones() + "'" +
            "}";
    }
    
}
