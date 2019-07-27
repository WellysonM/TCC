package com.backend.api.cliente.impl.usecase;

import com.backend.api.cliente.impl.bo.ClienteBO;
import com.backend.api.cliente.spec.dto.ClienteDTO;
import com.backend.api.cliente.spec.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoverCliente {

    @Autowired
    private ClienteBO clienteBO;

    public void RemoverCliente(ClienteDTO clienteDTO){
        Cliente cliente = clienteBO.buscarClientePorId(clienteDTO.getId());
        clienteBO.removerCliente(cliente);
    }
}
