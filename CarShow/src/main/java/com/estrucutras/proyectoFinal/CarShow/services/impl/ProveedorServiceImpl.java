package com.estrucutras.proyectoFinal.CarShow.services.impl;

import com.estrucutras.proyectoFinal.CarShow.entities.Cliente;
import com.estrucutras.proyectoFinal.CarShow.entities.Proveedor;
import com.estrucutras.proyectoFinal.CarShow.repository.ProveedorRepository;
import com.estrucutras.proyectoFinal.CarShow.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public Proveedor obtenerPorId(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Proveedor> getProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor ingresarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public void actualizarProveedor(Long id,Proveedor proveedor) {
        Proveedor proveedordb = proveedorRepository.findById(id).orElse(null);

        if (proveedordb != null) {
            proveedordb.setNombre(proveedor.getNombre());

            proveedorRepository.save(proveedordb);
        }
    }

    @Override
    public Long contarProveedores() {
        return proveedorRepository.count();
    }
}
