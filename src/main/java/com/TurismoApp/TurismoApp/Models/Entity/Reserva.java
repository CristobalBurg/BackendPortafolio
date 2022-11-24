package com.TurismoApp.TurismoApp.Models.Entity;

import java.time.LocalDate;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
@Table(name = "TR_RESERVA")
public class Reserva {
    @Id
    @Column(name = "id_reserva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;


    @NotBlank
    @Column(name = "fecha_llegada")
    private LocalDate fechaLlegada;
    @NotBlank
    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @ManyToOne(fetch = FetchType.LAZY  , cascade = CascadeType.ALL)
    @JoinColumn(name = "id_departamento")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.LAZY  , cascade = CascadeType.ALL )
    @JoinColumn(name = "rut_usuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Usuario usuario;

    @OneToMany(mappedBy = "reserva" , fetch = FetchType.LAZY  ,cascade = {CascadeType.ALL})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    List <ReservaServicioExtra> reservaServicioExtra;

    @OneToMany(mappedBy = "reserva", fetch = FetchType.LAZY  , cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    List<ReservaPago> reservaPagos;

    @Column(name = "checked_in")
    private boolean checkedIn;

    @Column(name = "checked_out")
    private boolean checkedOut;
    
    @NotBlank
    @Column(name = "ctd_acompanantes")
    private int ctdAcomanantes;

    @OneToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "rut_transportista")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Transportista transportista;



}
