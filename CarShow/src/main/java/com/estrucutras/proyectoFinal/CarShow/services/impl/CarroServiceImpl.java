package com.estrucutras.proyectoFinal.CarShow.services.impl;

import com.estrucutras.proyectoFinal.CarShow.entities.Carro;
import com.estrucutras.proyectoFinal.CarShow.entities.Cliente;
import com.estrucutras.proyectoFinal.CarShow.repository.CarroRepository;
import com.estrucutras.proyectoFinal.CarShow.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Override
    public List<Carro> getCarros() {
        return carroRepository.findAll();
    }

    @Override
    public Carro ingresarCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    @Override
    public Carro editarCarro(Long id, Carro carro) {
        Carro carroDb = carroRepository.findById(id).orElse(null);

        if (carroDb != null) {
            carroDb.setMarca(carro.getMarca());
            carroDb.setModelo(carro.getModelo());
            carroDb.setPrecio(carro.getPrecio());
            return carroRepository.save(carroDb);
        }
        return null;
    }


    @Override
    public void eliminarCarro(Long id) {
        carroRepository.deleteById(id);
    }

    @Override
    public Carro buscarCarroPorId(Long id) {
        return carroRepository.findById(id).orElse(null);
    }


    @Override
    public Long contarCarros() {
        return carroRepository.count();
    }
}
