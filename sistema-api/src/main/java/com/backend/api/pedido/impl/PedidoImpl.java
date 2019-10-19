package com.backend.api.pedido.impl;

import com.backend.api.pedido.impl.usecase.*;
import com.backend.api.pedido.spec.IPedido;
import com.backend.api.pedido.spec.dto.PedidoDTO;
import com.backend.api.pedido.spec.entity.Pedido;
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

    @Autowired
    private BuscarPedidosPorMesa buscarPedidosPorMesa;

    @Override
    public List<PedidoDTO> buscarPedidos() {
        return buscar.buscarPedidos();
    }

    @Override
    public Pedido buscarPedidosPorStatusEMesaId(String mesaId) {
        return buscarPedidosPorMesa.buscarPedidosPorMesa(mesaId);
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
