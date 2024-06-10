package com.estrucutras.proyectoFinal.CarShow.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_proveedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proveedor;

    private String nombre;

    private String email;

    private String telefono;

    public Proveedor(String nombre,String email,String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
}
