package com.backend.api.cliente.impl;

import com.backend.api.cliente.impl.usecase.AtualizarCliente;
import com.backend.api.cliente.impl.usecase.BuscarCliente;
import com.backend.api.cliente.impl.usecase.InserirCliente;
import com.backend.api.cliente.impl.usecase.RemoverCliente;
import com.backend.api.cliente.spec.ICliente;
import com.backend.api.cliente.spec.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteImpl implements ICliente {

    @Autowired
    private BuscarCliente buscar;

    @Autowired
    private InserirCliente inserir;

    @Autowired
    private AtualizarCliente atualizar;

    @Autowired
    private RemoverCliente remover;

    @Override
    public List<ClienteDTO> buscarClientes() {
        return buscar.BuscarClientes();
    }

    @Override
    public void removerCliente(ClienteDTO clienteDTOId) {
        remover.RemoverCliente(clienteDTOId);
    }

    @Override
    public void inserirCliente(ClienteDTO clienteDTO) {
        inserir.InserirCliente(clienteDTO);
    }

    @Override
    public void atualizarCliente(ClienteDTO clienteDTO) {
        atualizar.atualizarCliente(clienteDTO);
    }
}
