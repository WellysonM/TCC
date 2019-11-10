package com.backend.api.pedido.spec;

import com.backend.api.pedido.spec.dto.PedidoDTO;

import java.util.List;

public interface IPedido {

    List<PedidoDTO> buscarPedidos();

    List<PedidoDTO> buscarPedidosPorStatusEMesaId(String mesaId);

    List<PedidoDTO> buscarTodosPedidosFinalizados();

    void inserirPedido(PedidoDTO pedidoDTO);

    void atualizarPedido(List<PedidoDTO> pedidoDTOs);
}