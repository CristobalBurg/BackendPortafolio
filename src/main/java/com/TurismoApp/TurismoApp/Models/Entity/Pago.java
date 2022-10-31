package com.TurismoApp.TurismoApp.Models.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @Column(name = "medio_pago")
    private String medioPago;


    @OneToMany(mappedBy = "reserva" , fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @JsonIgnore
    private Set<ReservaPago> reservaPago;



    public Pago() {
    }

    public Pago(int idPago, String tipoPago, int monto, String medioPago, Set<ReservaPago> reservaPago) {
        this.idPago = idPago;
        this.tipoPago = tipoPago;
        this.monto = monto;
        this.medioPago = medioPago;
        this.reservaPago = reservaPago;
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

    public String getMedioPago() {
        return this.medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public Set<ReservaPago> getReservaPago() {
        return this.reservaPago;
    }

    public void setReservaPago(Set<ReservaPago> reservaPago) {
        this.reservaPago = reservaPago;
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

    public Pago medioPago(String medioPago) {
        setMedioPago(medioPago);
        return this;
    }

    public Pago reservaPago(Set<ReservaPago> reservaPago) {
        setReservaPago(reservaPago);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idPago='" + getIdPago() + "'" +
            ", tipoPago='" + getTipoPago() + "'" +
            ", monto='" + getMonto() + "'" +
            ", medioPago='" + getMedioPago() + "'" +
            ", reservaPago='" + getReservaPago() + "'" +
            "}";
    }


  
 
}
