package com.estrucutras.proyectoFinal.CarShow.services.impl;

import com.estrucutras.proyectoFinal.CarShow.entities.EstadoFac;
import com.estrucutras.proyectoFinal.CarShow.repository.EstadoFacRepository;
import com.estrucutras.proyectoFinal.CarShow.services.EstadoFacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoFacImpl implements EstadoFacService {

    @Autowired
    EstadoFacRepository estadoFacRepository;

    @Override
    public EstadoFac getEstadoPorId(Long id) {
        return estadoFacRepository.findById(id).orElse(null);
    }
}
