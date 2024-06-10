package com.estrucutras.proyectoFinal.CarShow.services;

import com.estrucutras.proyectoFinal.CarShow.entities.EstadoFac;
import org.springframework.stereotype.Service;

@Service
public interface EstadoFacService {

    EstadoFac getEstadoPorId(Long id);
}
