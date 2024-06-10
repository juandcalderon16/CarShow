package com.estrucutras.proyectoFinal.CarShow.services;

import com.estrucutras.proyectoFinal.CarShow.entities.Carro;
import com.estrucutras.proyectoFinal.CarShow.entities.Cliente;
import com.estrucutras.proyectoFinal.CarShow.entities.Personalizacion;
import com.estrucutras.proyectoFinal.CarShow.entities.PersonalizacionCarro;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface PersonalizacionCarroService {

    List<PersonalizacionCarro> obtenerPersoCarros();

    List<PersonalizacionCarroService> obtenerPersoCarrosDeCliente(String cliente);

    PersonalizacionCarro agregarPersonalizacionCarro(PersonalizacionCarro personalizacionCarro);

    PersonalizacionCarro obtenerPorId(Long id);

    void eliminarPersonalizacionCarro(Long id);
}
