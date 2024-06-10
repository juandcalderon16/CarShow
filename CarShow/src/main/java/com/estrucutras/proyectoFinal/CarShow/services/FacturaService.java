package com.estrucutras.proyectoFinal.CarShow.services;

import com.estrucutras.proyectoFinal.CarShow.entities.Factura;
import org.springframework.stereotype.Service;

@Service
public interface FacturaService {

    Factura getFactura(Long id);

    Factura generarFactura(Factura factura);

    void eliminarFactura(Long id);
}
