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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idProducto")
@Table(name = "TR_PRODUCTO")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;
    @Column(name = "valor")
    private int valor;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "producto" , fetch = FetchType.LAZY)
    //@JsonIgnoreProperties("inventarioProducto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @JsonIgnore

    private Set<InventarioProducto> inventarioProducto;



    public Producto() {
    }

    public Producto(int idProducto, int valor, String nombre, Set<InventarioProducto> inventarioProducto) {
        this.idProducto = idProducto;
        this.valor = valor;
        this.nombre = nombre;
        this.inventarioProducto = inventarioProducto;
    }

    public int getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<InventarioProducto> getInventarioProducto() {
        return this.inventarioProducto;
    }

    public void setInventarioProducto(Set<InventarioProducto> inventarioProducto) {
        this.inventarioProducto = inventarioProducto;
    }

    public Producto idProducto(int idProducto) {
        setIdProducto(idProducto);
        return this;
    }

    public Producto valor(int valor) {
        setValor(valor);
        return this;
    }

    public Producto nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Producto inventarioProducto(Set<InventarioProducto> inventarioProducto) {
        setInventarioProducto(inventarioProducto);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " idProducto='" + getIdProducto() + "'" +
            ", valor='" + getValor() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", inventarioProducto='" + getInventarioProducto() + "'" +
            "}";
    }


}
