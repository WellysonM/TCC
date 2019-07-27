package com.backend.api.cliente.impl.bo;

import com.backend.api.cliente.impl.repository.ClienteRepository;
import com.backend.api.cliente.spec.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteBO {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> buscarCliente() {
        return clienteRepository.findAll(Sort.by("nome").ascending());
    }

    public Cliente inserirCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarClientePorId(String id) {
        return clienteRepository.findById(id).get();
    }

    public void removerCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
