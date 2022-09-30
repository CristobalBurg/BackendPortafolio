package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TR_INVENTARIO")
public class Inventario {
    @Id
    @Column(name = "id_inventario")
    private int idInventario;
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    @Column(name = "cantidad")
    private int cantidad;


    public Inventario() {
    }

    public Inventario(int idInventario, Departamento departamento, Producto producto, int cantidad) {
        this.idInventario = idInventario;
        this.departamento = departamento;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getIdInventario() {
        return this.idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Inventario idInventario(int idInventario) {
        setIdInventario(idInventario);
        return this;
    }

    public Inventario departamento(Departamento departamento) {
        setDepartamento(departamento);
        return this;
    }

    public Inventario producto(Producto producto) {
        setProducto(producto);
        return this;
    }

    public Inventario cantidad(int cantidad) {
        setCantidad(cantidad);
        return this;
    }

 

    @Override
    public String toString() {
        return "{" +
            " idInventario='" + getIdInventario() + "'" +
            ", departamento='" + getDepartamento() + "'" +
            ", producto='" + getProducto() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            "}";
    }

}
