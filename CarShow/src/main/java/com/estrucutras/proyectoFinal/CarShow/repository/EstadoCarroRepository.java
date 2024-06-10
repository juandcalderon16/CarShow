package com.estrucutras.proyectoFinal.CarShow.repository;

import com.estrucutras.proyectoFinal.CarShow.entities.EstadoCarro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoCarroRepository extends JpaRepository<EstadoCarro, Long> {
}
