package com.backend.api.pedido.impl.usecase;

import com.backend.api.pedido.impl.bo.PedidoBO;
import com.backend.api.pedido.spec.dto.PedidoDTO;
import com.backend.api.pedido.spec.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuscarPedidosEmEspera {

    @Autowired
    private PedidoBO pedidoBO;

    public List<PedidoDTO> buscarTodosPedidosEmEspera() {
        List<Pedido> pedidos = pedidoBO.buscarTodosPedidosEmEspera();
        return converterPedidoParaDTO(pedidos);
    }

    private List<PedidoDTO> converterPedidoParaDTO(List<Pedido> pedidos) {
        List<PedidoDTO> pedidoDTO = new ArrayList<>();
        pedidos.forEach(pedido -> pedidoDTO.add(montarPedidoDTO(pedido)));
        return pedidoDTO;
    }

    private static PedidoDTO montarPedidoDTO(Pedido pedido) {
        return new PedidoDTO(pedido);
    }
}
