package com.TurismoApp.TurismoApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TR_CHECKIN")
public class CheckIn {
    @Id
    @Column(name = "id_check_in")
    private int idCheckIn;
    @Column(name = "id_departamento")
    private int idDeparamento;
    @Column(name = "id_reserva")
    private int idReserva;
    @Column(name = "id_pago")
    private int idPago;
    @Column(name = "firmado")
    private boolean firmado;

    public CheckIn() {
    }

    public CheckIn(int idCheckIn, int idDeparamento, int idReserva, int idPago, boolean firmado) {
        this.idCheckIn = idCheckIn;
        this.idDeparamento = idDeparamento;
        this.idReserva = idReserva;
        this.idPago = idPago;
        this.firmado = firmado;
    }

    public int getIdCheckIn() {
        return this.idCheckIn;
    }

    public void setIdCheckIn(int idCheckIn) {
        this.idCheckIn = idCheckIn;
    }

    public int getIdDeparamento() {
        return this.idDeparamento;
    }

    public void setIdDeparamento(int idDeparamento) {
        this.idDeparamento = idDeparamento;
    }

    public int getIdReserva() {
        return this.idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdPago() {
        return this.idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
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

    public CheckIn idDeparamento(int idDeparamento) {
        setIdDeparamento(idDeparamento);
        return this;
    }

    public CheckIn idReserva(int idReserva) {
        setIdReserva(idReserva);
        return this;
    }

    public CheckIn idPago(int idPago) {
        setIdPago(idPago);
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
                ", idDeparamento='" + getIdDeparamento() + "'" +
                ", idReserva='" + getIdReserva() + "'" +
                ", idPago='" + getIdPago() + "'" +
                ", firmado='" + isFirmado() + "'" +
                "}";
    }

}
