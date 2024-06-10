package com.estrucutras.proyectoFinal.CarShow.entities;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tbl_cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    private String nombre;

    private String apellido;

    private int edad;

    private String userName;

    private String password;

    public Cliente(String nombre, String apellido, int edad, String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

}
