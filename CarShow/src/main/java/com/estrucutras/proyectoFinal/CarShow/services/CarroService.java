package com.estrucutras.proyectoFinal.CarShow.services;

import com.estrucutras.proyectoFinal.CarShow.entities.Carro;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CarroService {

    List<Carro> getCarros();

    Carro ingresarCarro(Carro carro);

    Carro editarCarro(Long id, Carro carro);

    void eliminarCarro(Long id);

    Carro buscarCarroPorId(Long id);

    Long contarCarros();

}
