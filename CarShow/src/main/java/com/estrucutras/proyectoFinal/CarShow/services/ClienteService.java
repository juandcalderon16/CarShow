package com.estrucutras.proyectoFinal.CarShow.services;
import com.estrucutras.proyectoFinal.CarShow.entities.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {

    List<Cliente> getClientes();

    Cliente obtenerPorId(Long id);

    Cliente crearCliente(Cliente cliente);

    Cliente actualizaCliente(Long id,Cliente cliente);

    void eliminarCliente(Long id);

    Long contarClientes();

    Cliente obtenerClientePorUserName(String userName);

}
