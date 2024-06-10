package com.estrucutras.proyectoFinal.CarShow.controller;

import com.estrucutras.proyectoFinal.CarShow.entities.Cliente;
import com.estrucutras.proyectoFinal.CarShow.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    private Cliente clienteIn;

    @PostMapping("/api/usuarios")
    public ResponseEntity<?> crearUsuario(@RequestBody Cliente usuario) {
        // Aquí puedes llamar al método correspondiente en tu servicio
        // para guardar el usuario en la base de datos
        // Suponiendo que tienes un método en ClienteService para guardar el usuario
        Cliente clienteCreado = clienteService.crearCliente(usuario);
        // Devuelve una respuesta adecuada al frontend
        if (clienteCreado != null) {
            return new ResponseEntity<>(clienteCreado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al crear el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/api/usuarios/iniciarSesion")
    public ResponseEntity<?> iniciarSesion(@RequestBody Cliente usuario) {
        // Aquí puedes llamar al método correspondiente en tu servicio
        // para guardar el usuario en la base de datos
        // Suponiendo que tienes un método en ClienteService para guardar el usuario
        clienteIn = clienteService.obtenerClientePorUserName(usuario.getUserName());
        // Devuelve una respuesta adecuada al frontend
        if (clienteIn == null || !clienteIn.getPassword().equals(usuario.getPassword())) {
            // User not found or password is incorrect, return an error response
            return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
        } else {
            // User found and password is correct, return a success response
            return new ResponseEntity<>(clienteIn, HttpStatus.OK);
        }
    }

    @GetMapping("/api/usuarios/sesionIniciada")
    public ResponseEntity<?> sesionInciada() {
        if (clienteIn != null){
            String usuarioClienteIn = clienteIn.getUserName();
            return new ResponseEntity<>(usuarioClienteIn, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
        }
    }


}
