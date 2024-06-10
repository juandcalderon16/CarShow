package com.estrucutras.proyectoFinal.CarShow.controller;

import com.estrucutras.proyectoFinal.CarShow.entities.*;
import com.estrucutras.proyectoFinal.CarShow.repository.CarroRepository;
import com.estrucutras.proyectoFinal.CarShow.repository.ClienteRepository;
import com.estrucutras.proyectoFinal.CarShow.repository.PersonalizacionRepository;
import com.estrucutras.proyectoFinal.CarShow.services.CarroService;
import com.estrucutras.proyectoFinal.CarShow.services.ClienteService;
import com.estrucutras.proyectoFinal.CarShow.services.PersonalizacionCarroService;
import com.estrucutras.proyectoFinal.CarShow.services.PersonalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PersoCarroController {

    @Autowired
    private PersonalizacionCarroService personalizacionCarroService;

    @Autowired
    private PersonalizacionService personalizacionService;


    @Autowired
    private CarroService carroService;

    @Autowired
    private ClienteService clienteService;

    private PersonalizacionCarro persocarro;

    @PostMapping("/api/facturacion")
    public ResponseEntity<?> crearPersoCarro(@RequestBody CrearPersoCarroRequest request) {
    try {
        Cliente cliente = clienteService.obtenerClientePorUserName(request.getUsuario());
        if (cliente == null) {
            return new ResponseEntity<>("Usuario no encontrado"  + request.getUsuario(), HttpStatus.NOT_FOUND);
        }

        Carro carro = carroService.buscarCarroPorId(request.getCarroId());
        if (carro == null) {
            return new ResponseEntity<>("Carro no encontrado", HttpStatus.NOT_FOUND);
        }

        Personalizacion personalizacion = personalizacionService.buscarPorPrecio(request.getPrecioPerso());
        if (personalizacion == null) {
            return new ResponseEntity<>("Personalización no encontrada", HttpStatus.NOT_FOUND);
        }

        int total = carro.getPrecio() + personalizacion.getPrecio();

        PersonalizacionCarro personalizacionCarro = new PersonalizacionCarro("carro "
                + carro.getReferencia() + " de modelo "
                + carro.getModelo() + " facturado a nombre de "
                + cliente.getNombre(),cliente,carro,personalizacion,total);

        persocarro = personalizacionCarroService.agregarPersonalizacionCarro(personalizacionCarro);
        return new ResponseEntity<>(persocarro, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>("Error al facturar: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
    @GetMapping("/api/facturacion/factura")
    public ResponseEntity<?> enviarPersoCarro(){
        return new ResponseEntity<>(persocarro.getId_personalizacionCarro(), HttpStatus.OK);
    }

    @GetMapping("/api/facturacion/carro")
    public ResponseEntity<?> getCarroFacturado(){
        return new ResponseEntity<>(persocarro.getDescripcion(), HttpStatus.OK);
    }

    @GetMapping("/api/facturacion/carro/precio")
    public ResponseEntity<?> getPrecioCarroFacturado(){
        return new ResponseEntity<>(persocarro.getPrecioTotal(), HttpStatus.OK);
    }

        @DeleteMapping("/api/facturacion/eliminar/{id}")
    public ResponseEntity<?> eliminarPersoCarro(@PathVariable Long id) {
        try {
            personalizacionCarroService.eliminarPersonalizacionCarro(id);
            return new ResponseEntity<>("Personalización de carro eliminada", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la personalización de carro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
