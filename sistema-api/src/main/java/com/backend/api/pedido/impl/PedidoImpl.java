package com.backend.api.pedido.impl;

import com.backend.api.pedido.impl.usecase.*;
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
    private BuscarPedidosPorMesa buscarPedidosPorMesa;

    @Autowired
    BuscarPedidosFinalizados buscarPedidosFinalizados;

    @Override
    public List<PedidoDTO> buscarPedidos() {
        return buscar.buscarPedidos();
    }

    @Override
    public List<PedidoDTO> buscarPedidosPorStatusEMesaId(String mesaId) {
        return buscarPedidosPorMesa.buscarPedidosPorMesa(mesaId);
    }

    @Override
    public List<PedidoDTO> buscarTodosPedidosFinalizados() {
        return buscarPedidosFinalizados.buscarTodosPedidosFinalizados();
    }

    @Override
    public void inserirPedido(PedidoDTO pedidoDTO) {
        inserir.inserirPedido(pedidoDTO);
    }

    @Override
    public void atualizarPedido(List<PedidoDTO> pedidoDTOs) {
        atualizar.atualizarPedido(pedidoDTOs);
    }
}
