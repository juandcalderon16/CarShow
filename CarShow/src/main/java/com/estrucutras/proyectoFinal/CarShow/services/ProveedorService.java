package com.estrucutras.proyectoFinal.CarShow.services;

import com.estrucutras.proyectoFinal.CarShow.entities.Proveedor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProveedorService {

    Proveedor obtenerPorId(Long id);

    List<Proveedor> getProveedores();

    Proveedor ingresarProveedor(Proveedor proveedor);

    void eliminarProveedor(Long id);

    void actualizarProveedor(Long id,Proveedor proveedor);

    Long contarProveedores();
}
