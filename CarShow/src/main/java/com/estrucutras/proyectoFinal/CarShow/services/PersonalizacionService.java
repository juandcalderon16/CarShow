package com.estrucutras.proyectoFinal.CarShow.services;

import com.estrucutras.proyectoFinal.CarShow.entities.Personalizacion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonalizacionService {

    Personalizacion editarPersonalizacion(Long id, Personalizacion personalizacion);

    Personalizacion buscarPersonalizacion(Long id);

    Personalizacion buscarPorPrecio(int precio);

    Personalizacion crearPersonalizacion(Personalizacion personalizacion);

    void eliminarPersonalizacion(Long id);

    List<Personalizacion> getPersonalizaciones();

}
