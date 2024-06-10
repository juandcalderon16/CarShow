package com.estrucutras.proyectoFinal.CarShow.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_personalizacion_x_carro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalizacionCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_personalizacionCarro;

    private String descripcion;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Carro carro;

    @ManyToOne
    private Personalizacion personalizacion;

    private int precioTotal;

    public PersonalizacionCarro(String descripcion, Cliente cliente,
                                   Carro carro, Personalizacion personalizacion,
                                   int precioTotal) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.carro = carro;
        this.personalizacion = personalizacion;
        this.precioTotal = precioTotal;
    }
}
