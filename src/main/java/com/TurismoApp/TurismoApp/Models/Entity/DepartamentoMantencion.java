package com.TurismoApp.TurismoApp.Models.Entity;

import java.time.LocalDate;

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
@Table(name = "TR_DEPARTAMENTO_MANTENCION")
public class DepartamentoMantencion {
    @Id
    @Column(name = "id_departamento_mantencion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartamentoMantencion;


    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL}) 
    @JoinColumn(name = "id_departamento")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    @JsonIgnore
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_mantencion" )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private Mantencion mantencion;


    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;


    
}
