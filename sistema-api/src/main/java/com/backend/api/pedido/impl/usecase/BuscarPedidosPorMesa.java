package com.backend.api.pedido.impl.usecase;

import com.backend.api.pedido.impl.bo.PedidoBO;
import com.backend.api.pedido.spec.dto.PedidoDTO;
import com.backend.api.pedido.spec.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscarPedidosPorMesa {

    @Autowired
    private PedidoBO pedidoBO;

    public Pedido buscarPedidosPorMesa(String mesaId) {
       Pedido pedido = pedidoBO.buscarPedidosPorMesaIdEStatus(mesaId);
        return pedido;
    }
}
