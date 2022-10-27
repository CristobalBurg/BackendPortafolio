package com.TurismoApp.TurismoApp.Models.Entity;

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

    
    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL}) 
    @JoinColumn(name = "id_departamento")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    @JsonIgnore
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @JoinColumn(name = "id_producto" )
    private Producto producto;

    @Column(name = "cantidad")
    private int cantidad;


    public InventarioProducto() {
    }

    public InventarioProducto(int idInventarioProducto, Departamento departamento, Producto producto, int cantidad) {
        this.idInventarioProducto = idInventarioProducto;
        this.departamento = departamento;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getIdInventarioProducto() {
        return this.idInventarioProducto;
    }

    public void setIdInventarioProducto(int idInventarioProducto) {
        this.idInventarioProducto = idInventarioProducto;
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

    public InventarioProducto idInventarioProducto(int idInventarioProducto) {
        setIdInventarioProducto(idInventarioProducto);
        return this;
    }

    public InventarioProducto departamento(Departamento departamento) {
        setDepartamento(departamento);
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
            ", departamento='" + getDepartamento() + "'" +
            ", producto='" + getProducto() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            "}";
    }

    
}
