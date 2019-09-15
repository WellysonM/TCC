package com.backend.api.pedido.impl.usecase;

import com.backend.api.pedido.impl.bo.PedidoBO;
import com.backend.api.pedido.spec.dto.PedidoDTO;
import com.backend.api.pedido.spec.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InserirPedido {

    @Autowired
    private PedidoBO pedidoBO;

    public void inserirPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        preencherPedido(pedido, pedidoDTO);
        pedidoBO.inserirPedido(pedido);
    }

    private static void preencherPedido(Pedido pedido, PedidoDTO pedidoDTO) {
        pedido.setId(pedidoDTO.getId());
        pedido.setStatus(pedidoDTO.getStatus());
        pedido.setProduto(pedidoDTO.getProduto());
        pedido.setQuantidade(pedidoDTO.getQuantidade());
        pedido.setSubValor(pedidoDTO.getSubValor());
    }
}
