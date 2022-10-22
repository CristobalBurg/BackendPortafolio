package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "TR_INVENTARIO_PRODUCTO")
public class InventarioProducto {

    @Id
    @Column(name = "id_inventario_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInventarioProducto;

    
    @ManyToOne(fetch = FetchType.LAZY )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @JsonIgnore

    @JoinColumn(name = "id_inventario")
    private Inventario inventario;

    @ManyToOne(fetch = FetchType.LAZY )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @JoinColumn(name = "id_producto" )
    private Producto producto;

    @Column(name = "cantidad")
    private int cantidad;


    public InventarioProducto() {
    }

    public InventarioProducto(int idInventarioProducto, Inventario inventario, Producto producto, int cantidad) {
        this.idInventarioProducto = idInventarioProducto;
        this.inventario = inventario;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getIdInventarioProducto() {
        return this.idInventarioProducto;
    }

    public void setIdInventarioProducto(int idInventarioProducto) {
        this.idInventarioProducto = idInventarioProducto;
    }
    //@JsonBackReference
    public Inventario getInventario() {
        return this.inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
    //@JsonBackReference
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

    public InventarioProducto idInventarioProducto(int idInventarioProducto) {
        setIdInventarioProducto(idInventarioProducto);
        return this;
    }

    public InventarioProducto inventario(Inventario inventario) {
        setInventario(inventario);
        return this;
    }

    public InventarioProducto producto(Producto producto) {
        setProducto(producto);
        return this;
    }

    public InventarioProducto cantidad(int cantidad) {
        setCantidad(cantidad);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " idInventarioProducto='" + getIdInventarioProducto() + "'" +
            ", inventario='" + getInventario() + "'" +
            ", producto='" + getProducto() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            "}";
    }

    
}
