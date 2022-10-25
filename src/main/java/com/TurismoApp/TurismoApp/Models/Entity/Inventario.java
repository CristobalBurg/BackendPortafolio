package com.TurismoApp.TurismoApp.Models.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idInventario")
@Table(name = "TR_INVENTARIO")
public class Inventario {
    @Id
    @Column(name = "id_inventario")
    private int idInventario;

    @OneToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL} )
    @JoinColumn(name = "id_departamento")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Departamento departamento;

    @OneToMany(mappedBy = "inventario" , fetch = FetchType.LAZY  ,cascade = {CascadeType.ALL})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    List<InventarioProducto> inventarioProductos;
 


    public Inventario() {
    }

    public Inventario(int idInventario, Departamento departamento) {
        this.idInventario = idInventario;
        this.departamento = departamento;
    }

    public int getIdInventario() {
        return this.idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Inventario idInventario(int idInventario) {
        setIdInventario(idInventario);
        return this;
    }

    public Inventario departamento(Departamento departamento) {
        setDepartamento(departamento);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idInventario='" + getIdInventario() + "'" +
            ", departamento='" + getDepartamento() + "'" +
            "}";
    }
 
}
