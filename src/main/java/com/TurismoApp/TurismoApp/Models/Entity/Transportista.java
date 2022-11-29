package com.TurismoApp.TurismoApp.Models.Entity;



import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "TR_TRANSPORTISTA")
public class Transportista {
    @Id
    @Column(name = "rut_transportista")
    private String rutTransportista;
    @NotBlank
    @Column(name = "nombre")
    private String nombre;
    @NotBlank
    @Column(name = "apellido")
    private String apellido;
    @NotBlank
    @Column(name = "vehiculo")
    private String vehiculo;
    @Column(name = "fecha_desde")
    private String fechaDesde;
    @Column(name = "fecha_hasta")
    private String fechaHasta;
    @NotBlank
    @Column(name = "contacto")
    private String contacto;

}
