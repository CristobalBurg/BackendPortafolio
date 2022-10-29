package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TR_MULTA")
public class Multa {
    @Id
    @Column(name = "id_multa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMulta;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "valor")
    private int valor;

    public Multa() {
    }

    public Multa(int idMulta, String descripcion, int valor) {
        this.idMulta = idMulta;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public int getIdMulta() {
        return this.idMulta;
    }

    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Multa idMulta(int idMulta) {
        setIdMulta(idMulta);
        return this;
    }

    public Multa descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    public Multa valor(int valor) {
        setValor(valor);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idMulta='" + getIdMulta() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", valor='" + getValor() + "'" +
            "}";
    }

}

