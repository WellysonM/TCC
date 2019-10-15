package com.backend.api.pedido.spec;

import com.backend.api.pedido.spec.dto.PedidoDTO;
import com.backend.api.pedido.spec.entity.Pedido;

import java.util.List;

public interface IPedido {

    List<PedidoDTO> buscarPedidos();

    void removerPedido(PedidoDTO pedidoDTO);

    Pedido inserirPedido(PedidoDTO pedidoDTO);

    void atualizarPedido(PedidoDTO pedidoDTO);
}