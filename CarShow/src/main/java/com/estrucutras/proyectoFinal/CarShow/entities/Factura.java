package com.estrucutras.proyectoFinal.CarShow.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_factura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;

    @ManyToOne
    private PersonalizacionCarro personalizacionCarro;

    @ManyToOne
    private EstadoFac estadoFac;

    private LocalDate fecha;

    private String descripcion;

    private int MontoFInal;

    @ManyToOne
    private Vendedor vendedor;

    public Factura(PersonalizacionCarro personalizacionCarro, EstadoFac estadoFac
            ,String descripcion, int MontoFInal, Vendedor vendedor) {
        this.fecha = LocalDate.now(); // Si quieres establecer la fecha aquí también
        this.descripcion = descripcion;
        this.estadoFac = estadoFac;
        this.personalizacionCarro = personalizacionCarro;
        this.MontoFInal = MontoFInal;
        this.vendedor = vendedor;
    }

    @PrePersist
    protected void onCreate() {
        this.fecha = LocalDate.now();
    }
}
