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
@Table(name = "TR_RESERVA_PAGO")
public class ReservaPago {

    @Id
    @Column(name ="id_reserva_pago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservaPago;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL}) 
    @JoinColumn(name = "id_reserva")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    @JsonIgnore
    private Reserva reserva;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_pago" )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private Pago pago;


}
