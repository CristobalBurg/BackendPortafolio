package com.TurismoApp.TurismoApp.Models.Entity;

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
@Table(name = "TR_CHECKIN")
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_check_in")
    private int idCheckIn;

    @OneToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "id_reserva")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Reserva reserva;


    @Column(name = "firmado")
    private boolean firmado;


    public CheckIn() {
    }


    public CheckIn(int idCheckIn, Reserva reserva, boolean firmado) {
        this.idCheckIn = idCheckIn;
        this.reserva = reserva;
        this.firmado = firmado;
    }

    public int getIdCheckIn() {
        return this.idCheckIn;
    }

    public void setIdCheckIn(int idCheckIn) {
        this.idCheckIn = idCheckIn;
    }

    public Reserva getReserva() {
        return this.reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
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

    public CheckIn idCheckIn(int idCheckIn) {
        setIdCheckIn(idCheckIn);
        return this;
    }

    public CheckIn reserva(Reserva reserva) {
        setReserva(reserva);
        return this;
    }

    public CheckIn firmado(boolean firmado) {
        setFirmado(firmado);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " idCheckIn='" + getIdCheckIn() + "'" +
            ", reserva='" + getReserva() + "'" +
            ", firmado='" + isFirmado() + "'" +
            "}";
    }
    

}
