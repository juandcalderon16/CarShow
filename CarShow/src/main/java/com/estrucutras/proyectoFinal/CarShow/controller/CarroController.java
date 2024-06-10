package com.estrucutras.proyectoFinal.CarShow.controller;


import com.estrucutras.proyectoFinal.CarShow.entities.Carro;
import com.estrucutras.proyectoFinal.CarShow.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/api/base-price/{id}")
    public ResponseEntity<Integer> getPrecio(@PathVariable Long id) {
        Carro carro = carroService.buscarCarroPorId(id);
        if (carro != null) {
            return new ResponseEntity<>(carro.getPrecio(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/carroName/{id}")
    public ResponseEntity<String> getReferencia(@PathVariable Long id) {
        Carro carro = carroService.buscarCarroPorId(id);
        if (carro != null) {
            return new ResponseEntity<>(carro.getReferencia(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }
    }


}