package com.TurismoApp.TurismoApp.Models.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;


import javax.persistence.Table;

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
@Table(name = "TR_COMUNA")
public class Comuna {
    @Id
    @Column(name = "id_comuna")
    private int idComuna;
    @Column(name = "id_provincia")
    private int idProvincia;
    @Column(name = "nombre")
    private String nombre;


}
