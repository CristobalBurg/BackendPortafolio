package com.TurismoApp.TurismoApp.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TR_TRABAJADOR")
public class Trabajador {
    @Id
    @Column(name="rut_trabajador")
    private String rutTrabajador;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "tipo_trabajador")
    private String tipoTrabajador;
    @Column(name = "correo")
    private String correo;
    @Column(name = "id_comuna")
    private int idComuna;

    public Trabajador() {
    }

    public Trabajador(String rutTrabajador, String nombre, String apellido, String tipoTrabajador, String correo, int idComuna) {
        this.rutTrabajador = rutTrabajador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoTrabajador = tipoTrabajador;
        this.correo = correo;
        this.idComuna = idComuna;
    }

    public String getRutTrabajador() {
        return this.rutTrabajador;
    }

    public void setRutTrabajador(String rut) {
        this.rutTrabajador = rut;
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

    public String getTipoTrabajador() {
        return this.tipoTrabajador;
    }

    public void setTipoTrabajador(String tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdComuna() {
        return this.idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public Trabajador rut(String rut) {
        setRutTrabajador(rut);
        return this;
    }

    public Trabajador nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Trabajador apellido(String apellido) {
        setApellido(apellido);
        return this;
    }

    public Trabajador tipoTrabajador(String tipoTrabajador) {
        setTipoTrabajador(tipoTrabajador);
        return this;
    }

    public Trabajador correo(String correo) {
        setCorreo(correo);
        return this;
    }

    public Trabajador idComuna(int idComuna) {
        setIdComuna(idComuna);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " rut='" + getRutTrabajador() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", tipoTrabajador='" + getTipoTrabajador() + "'" +
            ", correo='" + getCorreo() + "'" +
            ", idComuna='" + getIdComuna() + "'" +
            "}";
    }




}
