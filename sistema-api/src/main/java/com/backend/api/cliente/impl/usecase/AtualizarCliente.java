package com.backend.api.cliente.impl.usecase;

import com.backend.api.cliente.impl.bo.ClienteBO;
import com.backend.api.cliente.spec.dto.ClienteDTO;
import com.backend.api.cliente.spec.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtualizarCliente {

    @Autowired
    private ClienteBO clienteBO;

    public void atualizarCliente(ClienteDTO clienteDTO){
        Cliente cliente = clienteBO.buscarClientePorId(clienteDTO.getId());
        preencherCliente(cliente, clienteDTO);
        clienteBO.atualizarCliente(cliente);
    }

    private static void preencherCliente(Cliente cliente, ClienteDTO clienteDTO) {
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEmail(clienteDTO.getEmail());
    }
}
