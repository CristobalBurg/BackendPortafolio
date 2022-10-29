package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TR_CHECKOUT")
public class CheckOut {
    @Id
    @Column(name="id_check_out")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCheckOut;

    @OneToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "id_check_in")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private CheckIn checkin;

    @OneToOne(fetch = FetchType.LAZY ,  cascade = CascadeType.ALL )
    @JoinColumn(name = "id_multa")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Multa multa;
    
    @Column(name="firmado")
    private boolean firmado;

  


    public CheckOut() {
    }

    public CheckOut(int idCheckOut, CheckIn checkin, Multa multa, boolean firmado) {
        this.idCheckOut = idCheckOut;
        this.checkin = checkin;
        this.multa = multa;
        this.firmado = firmado;
    }

    public int getIdCheckOut() {
        return this.idCheckOut;
    }

    public void setIdCheckOut(int idCheckOut) {
        this.idCheckOut = idCheckOut;
    }

    public CheckIn getCheckin() {
        return this.checkin;
    }

    public void setCheckin(CheckIn checkin) {
        this.checkin = checkin;
    }

    public Multa getMulta() {
        return this.multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public boolean isFirmado() {
        return this.firmado;
    }

    public boolean getFirmado() {
        return this.firmado;
    }

    public void setFirmado(boolean firmado) {
        this.firmado = firmado;
    }

    public CheckOut idCheckOut(int idCheckOut) {
        setIdCheckOut(idCheckOut);
        return this;
    }

    public CheckOut checkin(CheckIn checkin) {
        setCheckin(checkin);
        return this;
    }

    public CheckOut multa(Multa multa) {
        setMulta(multa);
        return this;
    }

    public CheckOut firmado(boolean firmado) {
        setFirmado(firmado);
        return this;
    }

 

    @Override
    public String toString() {
        return "{" +
            " idCheckOut='" + getIdCheckOut() + "'" +
            ", checkin='" + getCheckin() + "'" +
            ", multa='" + getMulta() + "'" +
            ", firmado='" + isFirmado() + "'" +
            "}";
    }

    
}
