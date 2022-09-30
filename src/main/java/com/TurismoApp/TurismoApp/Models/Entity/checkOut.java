package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TR_CHECKOUT")
public class checkOut {
    @Id
    @Column(name="id_check_out")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCheckOut;
    @Column(name="id_departamento")
    private int idDepartamento;
    @Column(name="rut_cliente")
    private String rutCliente;
    @Column(name="id_pago")
    private int idPago;
    @Column(name="firmado")
    private boolean firmado;

    public checkOut() {
    }

    public checkOut(int idCheckOut, int idDepartamento, String rutCliente, int idPago, boolean firmado) {
        this.idCheckOut = idCheckOut;
        this.idDepartamento = idDepartamento;
        this.rutCliente = rutCliente;
        this.idPago = idPago;
        this.firmado = firmado;
    }

    public int getIdCheckOut() {
        return this.idCheckOut;
    }

    public void setIdCheckOut(int idCheckOut) {
        this.idCheckOut = idCheckOut;
    }

    public int getIdDepartamento() {
        return this.idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getRutCliente() {
        return this.rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
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

    public checkOut idCheckOut(int idCheckOut) {
        setIdCheckOut(idCheckOut);
        return this;
    }

    public checkOut idDepartamento(int idDepartamento) {
        setIdDepartamento(idDepartamento);
        return this;
    }

    public checkOut rutCliente(String rutCliente) {
        setRutCliente(rutCliente);
        return this;
    }

    public checkOut idPago(int idPago) {
        setIdPago(idPago);
        return this;
    }

    public checkOut firmado(boolean firmado) {
        setFirmado(firmado);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idCheckOut='" + getIdCheckOut() + "'" +
            ", idDepartamento='" + getIdDepartamento() + "'" +
            ", rutCliente='" + getRutCliente() + "'" +
            ", idPago='" + getIdPago() + "'" +
            ", firmado='" + isFirmado() + "'" +
            "}";
    }
    
}
