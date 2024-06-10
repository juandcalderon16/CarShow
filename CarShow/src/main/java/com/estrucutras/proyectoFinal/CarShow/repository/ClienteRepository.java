package com.estrucutras.proyectoFinal.CarShow.repository;

import com.estrucutras.proyectoFinal.CarShow.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByUserName(String userName);
}
