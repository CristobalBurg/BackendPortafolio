package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "TR_INVENTARIO_PRODUCTO")
public class InventarioProducto {

    @Id
    @Column(name = "id_inventario_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInventarioProducto;

    
    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "id_departamento")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    @JsonIgnore
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.LAZY )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @JoinColumn(name = "id_producto" )
    private Producto producto;

    @Column(name = "cantidad")
    private int cantidad;



    
}
