package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TR_PAGO")
public class Pago {

    @Id
    @Column(name = "id_pago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;
    @Column(name = "tipo_pago")
    private String tipoPago;
    @Column(name = "monto")
    private int monto;

    public Pago() {
    }

    public Pago(int idPago, String tipoPago, int monto) {
        this.idPago = idPago;
        this.tipoPago = tipoPago;
        this.monto = monto;
    }

    public int getIdPago() {
        return this.idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getTipoPago() {
        return this.tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public int getMonto() {
        return this.monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Pago idPago(int idPago) {
        setIdPago(idPago);
        return this;
    }

    public Pago tipoPago(String tipoPago) {
        setTipoPago(tipoPago);
        return this;
    }

    public Pago monto(int monto) {
        setMonto(monto);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " idPago='" + getIdPago() + "'" +
                ", tipoPago='" + getTipoPago() + "'" +
                ", monto='" + getMonto() + "'" +
                "}";
    }
}
