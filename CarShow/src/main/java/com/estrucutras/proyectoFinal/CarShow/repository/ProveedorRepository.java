package com.estrucutras.proyectoFinal.CarShow.repository;

import com.estrucutras.proyectoFinal.CarShow.entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
