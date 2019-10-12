package com.backend.api.pedido.impl.usecase;

import com.backend.api.pedido.impl.bo.PedidoBO;
import com.backend.api.pedido.spec.dto.PedidoDTO;
import com.backend.api.pedido.spec.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtualizarPedido {

    @Autowired
    private PedidoBO pedidoBO;

    public void atualizarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoBO.buscarPedidoPorId(pedidoDTO.getId());
        preencherPedido(pedido, pedidoDTO);
        pedidoBO.atualizarPedido(pedido);
    }

    private static void preencherPedido(Pedido pedido, PedidoDTO pedidoDTO) {
        pedido.setId(pedidoDTO.getId());
        pedido.setStatus(pedidoDTO.getStatus());
        pedido.setProdutos(pedidoDTO.getProdutos());
        pedido.setSubValor(pedidoDTO.getSubValor());
    }
}
