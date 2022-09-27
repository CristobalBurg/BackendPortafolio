package com.TurismoApp.TurismoApp.Entity;

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
    @Column(name = "valor")
    private int valor;

    public Multa() {
    }

    public Multa(int idMulta, int valor) {
        this.idMulta = idMulta;
        this.valor = valor;
    }

    public int getIdMulta() {
        return this.idMulta;
    }

    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
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

    public Multa valor(int valor) {
        setValor(valor);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idMulta='" + getIdMulta() + "'" +
            ", valor='" + getValor() + "'" +
            "}";
    }
}

