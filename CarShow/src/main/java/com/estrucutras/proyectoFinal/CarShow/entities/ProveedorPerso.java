package com.estrucutras.proyectoFinal.CarShow.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_proveedor_perso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorPerso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proveedorPerso;

    private String nombre;

    private String email;

    private String telefono;

    public ProveedorPerso(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
}
