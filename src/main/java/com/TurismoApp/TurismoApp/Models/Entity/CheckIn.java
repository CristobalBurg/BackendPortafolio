package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "TR_CHECKIN")
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_check_in")
    private int idCheckIn;

    @OneToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "id_reserva")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Reserva reserva;

    @Column(name = "firmado")
    private boolean firmado;





    @Override
    public String toString() {
        return "{" +
            " idCheckIn='" + getIdCheckIn() + "'" +
            ", reserva='" + getReserva() + "'" +
            ", firmado='" + isFirmado() + "'" +
            "}";
    }
    

}
