package com.backend.api.pedido.spec;

import com.backend.api.pedido.spec.dto.PedidoDTO;
import com.backend.api.pedido.spec.entity.Pedido;

import java.util.List;

public interface IPedido {

    List<PedidoDTO> buscarPedidos();

    List<PedidoDTO> buscarPedidosPorStatusEMesaId(String mesaId);

    List<PedidoDTO> buscarTodosPedidosFinalizados();

    void removerPedido(PedidoDTO pedidoDTO);

    void inserirPedido(PedidoDTO pedidoDTO);

    void atualizarPedido(List<PedidoDTO> pedidoDTOs);
}