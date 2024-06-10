package com.estrucutras.proyectoFinal.CarShow.services.impl;

import com.estrucutras.proyectoFinal.CarShow.entities.Carro;
import com.estrucutras.proyectoFinal.CarShow.entities.Cliente;
import com.estrucutras.proyectoFinal.CarShow.entities.Personalizacion;
import com.estrucutras.proyectoFinal.CarShow.entities.PersonalizacionCarro;
import com.estrucutras.proyectoFinal.CarShow.repository.CarroRepository;
import com.estrucutras.proyectoFinal.CarShow.repository.ClienteRepository;
import com.estrucutras.proyectoFinal.CarShow.repository.PersonalizacionCarroRepository;
import com.estrucutras.proyectoFinal.CarShow.repository.PersonalizacionRepository;
import com.estrucutras.proyectoFinal.CarShow.services.ClienteService;
import com.estrucutras.proyectoFinal.CarShow.services.PersonalizacionCarroService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalizacionCarroServiceImpl implements PersonalizacionCarroService {

    @Autowired
    private PersonalizacionCarroRepository personalizacionCarroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PersonalizacionRepository personalizacionRepository;

    @Override
    public List<PersonalizacionCarro> obtenerPersoCarros() {
        return personalizacionCarroRepository.findAll();
    }

    @Override
    public List<PersonalizacionCarroService> obtenerPersoCarrosDeCliente(String cliente) {
        Cliente clienteEntity = clienteRepository.findByUserName(cliente);
        if (clienteEntity == null) {
            throw new EntityNotFoundException("Cliente no encontrado con nombre: " + cliente);
        }
        return personalizacionCarroRepository.findByCliente(clienteEntity);
    }

    @Override
    public PersonalizacionCarro agregarPersonalizacionCarro(PersonalizacionCarro personalizacionCarro) {
        return personalizacionCarroRepository.save(personalizacionCarro);
    }

    @Override
    public PersonalizacionCarro obtenerPorId(Long id) {
        return personalizacionCarroRepository.findById(id).orElseThrow();
    }

    @Override
    public void eliminarPersonalizacionCarro(Long id) {
        personalizacionCarroRepository.deleteById(id);
    }

}

