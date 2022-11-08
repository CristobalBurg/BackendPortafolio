package com.TurismoApp.TurismoApp.Models.Entity;

import javax.persistence.CascadeType;
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
@Table(name="TR_CHECKOUT")
public class CheckOut {
    @Id
    @Column(name="id_check_out")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCheckOut;

    @OneToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "id_check_in")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private CheckIn checkin;

    @OneToOne(fetch = FetchType.LAZY ,  cascade = CascadeType.ALL )
    @JoinColumn(name = "id_multa")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Multa multa;
    
    @Column(name="firmado")
    private boolean firmado;

  



 

    @Override
    public String toString() {
        return "{" +
            " idCheckOut='" + getIdCheckOut() + "'" +
            ", checkin='" + getCheckin() + "'" +
            ", multa='" + getMulta() + "'" +
            ", firmado='" + isFirmado() + "'" +
            "}";
    }

    
}
