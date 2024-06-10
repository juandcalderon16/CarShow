package com.estrucutras.proyectoFinal.CarShow.controller;

import com.estrucutras.proyectoFinal.CarShow.entities.*;
import com.estrucutras.proyectoFinal.CarShow.repository.VendedorRepository;
import com.estrucutras.proyectoFinal.CarShow.services.EstadoFacService;
import com.estrucutras.proyectoFinal.CarShow.services.FacturaService;
import com.estrucutras.proyectoFinal.CarShow.services.PersonalizacionCarroService;
import com.estrucutras.proyectoFinal.CarShow.services.PersonalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private PersonalizacionCarroService personalizacionCarroService;

    @Autowired
    private VendedorRepository vendedorRepository;


    private Factura fac;

    @Autowired
    private EstadoFacService estadoFacService;

    @PostMapping("/api/facturacion/crearFac")
    public ResponseEntity<?> crearFactura(@RequestBody CrearFacturaRequest request) {
        try {
            PersonalizacionCarro personalizacionCarro = personalizacionCarroService.obtenerPorId(request.getPersonalizacionId());
            if (personalizacionCarro == null) {
                return new ResponseEntity<>("Usuario no encontrado"  + request.getPersonalizacionId(), HttpStatus.NOT_FOUND);
            }

            EstadoFac estado = estadoFacService.getEstadoPorId(request.getEstadoId());
            if (estado == null) {
                return new ResponseEntity<>("estado no encontrado", HttpStatus.NOT_FOUND);
            }

            int total = personalizacionCarro.getPrecioTotal();

            String descripcion = personalizacionCarro.getDescripcion();

            Vendedor vendedor = vendedorRepository.findById(1L).orElse(null);

            Factura factura = new Factura( personalizacionCarro
                    , estado, descripcion,total,vendedor);

            fac = facturaService.generarFactura(factura);

            return new ResponseEntity<>(fac, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al facturar: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/facturacion/carro/fecha")
    public ResponseEntity<?> getFechaCarroFacturado(){
        return new ResponseEntity<>(fac.getFecha(), HttpStatus.OK);
    }

}
