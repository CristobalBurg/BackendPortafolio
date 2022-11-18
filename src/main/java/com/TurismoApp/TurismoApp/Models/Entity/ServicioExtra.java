package com.TurismoApp.TurismoApp.Models.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="TR_SERVICIO_EXTRA")
public class ServicioExtra {
    @Id
    @Column(name="id_servicio_extra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicioExtra;
    @Column(name="rut_transportista")
    private String rutTransportista;
    @Column(name="valor")
    private int valor;
    @Column
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="foto")
    private String foto;
    @Column(name = "tipo_precio")
    private String tipoPrecio;

    @OneToMany(mappedBy = "servicioExtra" , fetch = FetchType.LAZY)
    //@JsonIgnoreProperties("inventarioProducto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @JsonIgnore
    private Set<ReservaServicioExtra> reservaServicioExtra;




    
    
}
