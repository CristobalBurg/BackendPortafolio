package com.TurismoApp.TurismoApp.Models.Entity;

import java.time.LocalDate;
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
@Table(name = "TR_PAGO")
public class Pago {

    @Id
    @Column(name = "id_pago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;
    @Column(name = "tipo_pago")
    private String tipoPago;
    @Column(name = "monto")
    private int monto;
    @Column(name = "medio_pago")
    private String medioPago;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column
    private String observacion;


    @OneToMany(mappedBy = "reserva" , fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @JsonIgnore
    private Set<ReservaPago> reservaPago;


  
 
}
