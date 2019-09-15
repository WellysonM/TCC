package com.backend.api.pedido.impl;

import com.backend.api.pedido.impl.usecase.AtualizarPedido;
import com.backend.api.pedido.impl.usecase.BuscarPedido;
import com.backend.api.pedido.impl.usecase.InserirPedido;
import com.backend.api.pedido.impl.usecase.RemoverPedido;
import com.backend.api.pedido.spec.IPedido;
import com.backend.api.pedido.spec.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoImpl implements IPedido {

    @Autowired
    private BuscarPedido buscar;

    @Autowired
    private InserirPedido inserir;

    @Autowired
    private AtualizarPedido atualizar;

    @Autowired
    private RemoverPedido remover;

    @Override
    public List<PedidoDTO> buscarPedidos() {
        return buscar.buscarPedidos();
    }

    @Override
    public void removerPedido(PedidoDTO pedidoDTOId) {
        remover.removerPedido(pedidoDTOId);
    }

    @Override
    public void inserirPedido(PedidoDTO pedidoDTO) {
        inserir.inserirPedido(pedidoDTO);
    }

    @Override
    public void atualizarPedido(PedidoDTO pedidoDTO) {
        atualizar.atualizarPedido(pedidoDTO);
    }
}
