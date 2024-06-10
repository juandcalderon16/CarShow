package com.estrucutras.proyectoFinal.CarShow.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_estadoFac")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoFac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estadoFac;

    private String descripcion;
}
