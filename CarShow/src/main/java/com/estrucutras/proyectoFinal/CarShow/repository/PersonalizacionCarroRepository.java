package com.estrucutras.proyectoFinal.CarShow.repository;

import com.estrucutras.proyectoFinal.CarShow.entities.Cliente;
import com.estrucutras.proyectoFinal.CarShow.entities.PersonalizacionCarro;
import com.estrucutras.proyectoFinal.CarShow.services.PersonalizacionCarroService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalizacionCarroRepository extends JpaRepository<PersonalizacionCarro, Long> {
    List<PersonalizacionCarroService> findByCliente(Cliente clienteEntity);
}
