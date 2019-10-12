package com.backend.api.cliente.impl.usecase;

import com.backend.api.cliente.impl.bo.ClienteBO;
import com.backend.api.cliente.spec.dto.ClienteDTO;
import com.backend.api.cliente.spec.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuscarCliente {

    @Autowired
    private ClienteBO clienteBO;

    public List<ClienteDTO> BuscarClientes() {
        List<Cliente> clientes = clienteBO.buscarCliente();
        return converterClienteParaDTO(clientes);
    }

    private List<ClienteDTO> converterClienteParaDTO(List<Cliente> clientes) {
        List<ClienteDTO> clienteDTO = new ArrayList<>();
        clientes.forEach(cliente -> clienteDTO.add(montarClienteDTO(cliente)));
        return clienteDTO;
    }

    public static ClienteDTO montarClienteDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO(cliente);
        return clienteDTO;
    }
}
