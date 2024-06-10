package com.estrucutras.proyectoFinal.CarShow.services.impl;

import com.estrucutras.proyectoFinal.CarShow.entities.Factura;
import com.estrucutras.proyectoFinal.CarShow.repository.FacturaRepository;
import com.estrucutras.proyectoFinal.CarShow.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public Factura getFactura(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @Override
    public Factura generarFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public void eliminarFactura(Long id) {
        facturaRepository.deleteById(id);
    }
}
