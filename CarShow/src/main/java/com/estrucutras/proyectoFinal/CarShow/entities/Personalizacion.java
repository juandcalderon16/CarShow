package com.estrucutras.proyectoFinal.CarShow.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_personalizacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personalizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_personalizacion;

    private String descripcion;

    private String rines;

    private String color;

    private int precio;

    @ManyToOne
    private ProveedorPerso proveedorPerso;

    public Personalizacion(String descripcion, String rines, String color, int precio,
                           ProveedorPerso proveedorPerso) {
        this.descripcion = descripcion;
        this.rines = rines;
        this.color = color;
        this.precio = precio;
        this.proveedorPerso = proveedorPerso;
    }
}
