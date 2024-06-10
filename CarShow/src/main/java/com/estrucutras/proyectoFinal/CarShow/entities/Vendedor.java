package com.estrucutras.proyectoFinal.CarShow.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_vendedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vendedor;

    private String nombre;

    private String apellido;

    private int edad;

    private String userName;

    private String password;

    public Vendedor(String nombre, String apellido, int edad, String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
}
