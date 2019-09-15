package com.backend.api.pedido.impl.usecase;

import com.backend.api.pedido.impl.bo.PedidoBO;
import com.backend.api.pedido.spec.dto.PedidoDTO;
import com.backend.api.pedido.spec.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoverPedido {

    @Autowired
    private PedidoBO pedidoBO;

    public void removerPedido(PedidoDTO pedidoDTO) {
        Pedido categroia = pedidoBO.buscarPedidoPorId(pedidoDTO.getId());
        pedidoBO.removerPedido(categroia);
    }
}
