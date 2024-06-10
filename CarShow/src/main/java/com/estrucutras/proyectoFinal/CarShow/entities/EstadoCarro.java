package com.estrucutras.proyectoFinal.CarShow.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_estadoCarro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estadoCarro;

    private String descripcion;
}
