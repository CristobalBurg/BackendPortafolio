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

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TR_DEPARTAMENTO")
public class Departamento {
    @Id
    @Column(name="id_departamento")
    @GeneratedValue( strategy = GenerationType.IDENTITY)    
    private int idDepartamento;
    @Column(name="direccion")
    private String direccion;
    @Column(name="ctd_Habitaciones")
    private int ctdHabitaciones;
    @Column(name="ctd_Banos")
    private int ctdBanos;
    @Column(name="valor_arriendo_dia")
    private int valorArriendoDia;

    @Column(name="politicas_condiciones")
    private String politicasCondiciones;

    
    @Column(name="foto")
    private String foto;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "id_comuna")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Comuna comuna;

    @OneToMany(mappedBy = "departamento" , fetch = FetchType.LAZY  ,cascade = {CascadeType.ALL})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    List<InventarioProducto> inventarioProductos;

    @OneToMany(mappedBy = "departamento" , fetch = FetchType.LAZY  ,cascade = {CascadeType.ALL})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    List<DepartamentoMantencion> departamentoMantenciones;





    @Override
    public String toString() {
        return "{" +
            " idDepartamento='" + getIdDepartamento() + "'" +
            ", direccion='" + getDireccion() + "'" +
            ", ctdHabitaciones='" + getCtdHabitaciones() + "'" +
            ", ctdBanos='" + getCtdBanos() + "'" +
            ", valorArriendoDia='" + getValorArriendoDia() + "'" +
            ", politicasCondiciones='" + getPoliticasCondiciones() + "'" +
            ", foto='" + getFoto() + "'" +
            ", comuna='" + getComuna() + "'" +
            ", inventarioProductos='" + getInventarioProductos() + "'" +
            ", departamentoMantenciones='" + getDepartamentoMantenciones() + "'" +
            "}";
    }

    
}
