package com.estrucutras.proyectoFinal.CarShow.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_carro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carro;

    private String referencia;

    private String marca;

    private String modelo;

    private int precio;

    @ManyToOne
    private Proveedor proveedor;

    @ManyToOne
    private EstadoCarro estadoCarro;

    public Carro(String referencia, String marca, String modelo, int precio, Proveedor proveedor
                , EstadoCarro estadoCarro) {
        this.referencia = referencia;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.proveedor = proveedor;
        this.estadoCarro = estadoCarro;
    }
}
