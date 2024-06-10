package com.estrucutras.proyectoFinal.CarShow.controller;

import com.estrucutras.proyectoFinal.CarShow.services.PersonalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PersonalizacionController {

    @Autowired
    private PersonalizacionService personalizacionService;


}
