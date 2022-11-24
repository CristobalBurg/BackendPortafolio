package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
@Table(name = "TR_MULTA")
public class Multa {
    @Id
    @Column(name = "id_multa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMulta;
    @NotBlank
    @Column(name = "descripcion")
    private String descripcion;
    @NotBlank
    @Column(name = "valor")
    private int valor;


}

