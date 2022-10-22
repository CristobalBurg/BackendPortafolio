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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idInventario")
@Table(name = "TR_INVENTARIO")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private int idInventario;

    @OneToMany(mappedBy = "inventario" , fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    Set<InventarioProducto> inventarioProducto;


    public Inventario() {
    }

    public Inventario(int idInventario, Set<InventarioProducto> inventarioProducto) {
        this.idInventario = idInventario;
        this.inventarioProducto = inventarioProducto;
    }

    public int getIdInventario() {
        return this.idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public Set<InventarioProducto> getInventarioProducto() {
        return this.inventarioProducto;
    }

    public void setInventarioProducto(Set<InventarioProducto> inventarioProducto) {
        this.inventarioProducto = inventarioProducto;
    }

    public Inventario idInventario(int idInventario) {
        setIdInventario(idInventario);
        return this;
    }

    public Inventario inventarioProducto(Set<InventarioProducto> inventarioProducto) {
        setInventarioProducto(inventarioProducto);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " idInventario='" + getIdInventario() + "'" +
            ", inventarioProducto='" + getInventarioProducto() + "'" +
            "}";
    }

  
 
}
