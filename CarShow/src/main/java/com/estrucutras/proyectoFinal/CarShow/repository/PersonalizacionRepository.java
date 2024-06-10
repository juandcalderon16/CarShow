package com.estrucutras.proyectoFinal.CarShow.repository;

import com.estrucutras.proyectoFinal.CarShow.entities.Personalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalizacionRepository extends JpaRepository<Personalizacion, Long> {
    Personalizacion findByPrecio(int precio);
}
