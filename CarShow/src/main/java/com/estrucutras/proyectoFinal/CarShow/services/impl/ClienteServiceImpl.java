package com.estrucutras.proyectoFinal.CarShow.services.impl;

import com.estrucutras.proyectoFinal.CarShow.entities.Cliente;
import com.estrucutras.proyectoFinal.CarShow.repository.ClienteRepository;
import com.estrucutras.proyectoFinal.CarShow.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizaCliente(Long id, Cliente cliente) {
        Cliente clientedb = clienteRepository.findById(id).orElse(null);

        if (clientedb != null) {
            clientedb.setUserName(cliente.getUserName());
            return clienteRepository.save(clientedb);
        }
        return null;
    }

    @Override
    public void eliminarCliente(Long id) {

        clienteRepository.deleteById(id);
    }

    @Override
    public Long contarClientes() {
        return clienteRepository.count();
    }

    @Override
    public Cliente obtenerClientePorUserName(String userName) {
        return clienteRepository.findByUserName(userName);
    }

}
