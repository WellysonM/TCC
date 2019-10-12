package com.backend.api.cliente.spec;

import com.backend.api.cliente.spec.dto.ClienteDTO;

import java.util.List;

public interface ICliente {

    List<ClienteDTO> buscarClientes();

    void removerCliente(ClienteDTO clienteDTO);

    void inserirCliente(ClienteDTO clienteDTO);

    void atualizarCliente(ClienteDTO clienteDTO);
}
