package com.TurismoApp.TurismoApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TR_PRODUCTO")
public class Producto {
    @Id
    @Column(name = "id_producto")
    private int idProducto;
    @Column(name = "valor")
    private int valor;
    @Column(name = "nombre")
    private String nombre;

    public Producto() {
    }

    public Producto(int idProducto, int valor, String nombre) {
        this.idProducto = idProducto;
        this.valor = valor;
        this.nombre = nombre;
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



    @Override
    public String toString() {
        return "{" +
            " idProducto='" + getIdProducto() + "'" +
            ", valor='" + getValor() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }

}
