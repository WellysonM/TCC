package com.backend.api.pedido.spec;

import com.backend.api.pedido.spec.dto.PedidoDTO;

import java.util.List;

public interface IPedido {

    List<PedidoDTO> buscarPedidos();

    void removerPedido(PedidoDTO pedidoDTO);

    void inserirPedido(PedidoDTO pedidoDTO);

    void atualizarPedido(PedidoDTO pedidoDTO);
}
