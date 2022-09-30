package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TR_CLIENTE")
public class Cliente {
    @Id
    @Column(name = "rut_cliente")
    private String rutCliente;
    @NotBlank
    @Column(name = "nombre")
    private String nombre;
    @NotBlank
    @Column(name = "apellido")
    private String apellido;
    @NotBlank
    @Column(name = "contacto")
    private String contacto;
    @Email(message = "la wea que yo quiera")
    @Column(name = "correo")
    private String correo;
    


    public Cliente() {
    }

    public Cliente(String rutCliente, String nombre, String apellido, String contacto, String correo) {
        this.rutCliente = rutCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contacto = contacto;
        this.correo = correo;
    }

    public String getRutCliente() {
        return this.rutCliente;
    }

    public void setRutCliente(String rut) {
        this.rutCliente = rut;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContacto() {
        return this.contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Cliente rut(String rut) {
        setRutCliente(rut);
        return this;
    }

    public Cliente nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Cliente apellido(String apellido) {
        setApellido(apellido);
        return this;
    }

    public Cliente contacto(String contacto) {
        setContacto(contacto);
        return this;
    }

    public Cliente correo(String correo) {
        setCorreo(correo);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " rut='" + getRutCliente() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", apellido='" + getApellido() + "'" +
                ", contacto='" + getContacto() + "'" +
                ", correo='" + getCorreo() + "'" +
                "}";
    }

}
