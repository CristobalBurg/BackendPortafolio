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
@Table(name="TR_MANTENCION")
public class Mantencion {
    @Id
    @Column(name = "id_mantencion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMantencion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "valor")
    private int valor;

    @OneToMany(mappedBy = "mantencion" , fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @JsonIgnore
    private Set<DepartamentoMantencion> departamentoMantenciones;


    
}
