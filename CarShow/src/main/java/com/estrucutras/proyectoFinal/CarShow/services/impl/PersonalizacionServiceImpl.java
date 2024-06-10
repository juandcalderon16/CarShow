package com.estrucutras.proyectoFinal.CarShow.services.impl;

import com.estrucutras.proyectoFinal.CarShow.entities.Carro;
import com.estrucutras.proyectoFinal.CarShow.entities.Personalizacion;
import com.estrucutras.proyectoFinal.CarShow.repository.PersonalizacionRepository;
import com.estrucutras.proyectoFinal.CarShow.services.PersonalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalizacionServiceImpl implements PersonalizacionService {

    @Autowired
    private PersonalizacionRepository personalizacionRepository;

    @Override
    public Personalizacion editarPersonalizacion(Long id, Personalizacion personalizacion) {
        Personalizacion personalizacionDb = personalizacionRepository.findById(id).orElse(null);

        if (personalizacionDb != null) {
            personalizacionDb.setDescripcion(personalizacion.getDescripcion());
            personalizacionDb.setRines(personalizacion.getRines());
            personalizacionDb.setColor(personalizacion.getColor());
            personalizacionDb.setPrecio(personalizacion.getPrecio());
            return personalizacionRepository.save(personalizacionDb);
        }
        return null;
    }

    @Override
    public Personalizacion buscarPersonalizacion(Long id) {
        return personalizacionRepository.findById(id).orElse(null);
    }

    @Override
    public Personalizacion buscarPorPrecio(int precio) {
        return personalizacionRepository.findByPrecio(precio);
    }

    @Override
    public Personalizacion crearPersonalizacion(Personalizacion personalizacion) {
        return personalizacionRepository.save(personalizacion);
    }

    @Override
    public void eliminarPersonalizacion(Long id) {
        personalizacionRepository.deleteById(id);
    }

    @Override
    public List<Personalizacion> getPersonalizaciones() {
        return personalizacionRepository.findAll();
    }
}
