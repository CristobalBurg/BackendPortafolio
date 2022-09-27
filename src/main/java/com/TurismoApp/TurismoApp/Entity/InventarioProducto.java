package com.TurismoApp.TurismoApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TR_INVENTARIO_PRODUCTO")
public class Inventario_Producto {
    @Id
    @Column(name = "id_inventario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInventario;
    @Column(name = "id_producto")
    private int idProducto;
    @Column(name = "cantidad")
    private int cantidad;

    public Inventario_Producto() {
    }

    public Inventario_Producto(int idInventario, int idProducto, int cantidad) {
        this.idInventario = idInventario;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getIdInventario() {
        return this.idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Inventario_Producto idInventario(int idInventario) {
        setIdInventario(idInventario);
        return this;
    }

    public Inventario_Producto idProducto(int idProducto) {
        setIdProducto(idProducto);
        return this;
    }

    public Inventario_Producto cantidad(int cantidad) {
        setCantidad(cantidad);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " idInventario='" + getIdInventario() + "'" +
                ", idProducto='" + getIdProducto() + "'" +
                ", cantidad='" + getCantidad() + "'" +
                "}";
    }

}
