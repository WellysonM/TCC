package com.backend.api.pedido.impl.usecase;

import com.backend.api.pedido.impl.bo.PedidoBO;
import com.backend.api.pedido.spec.dto.PedidoDTO;
import com.backend.api.pedido.spec.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuscarPedidosPorMesa {

    @Autowired
    private PedidoBO pedidoBO;

    public List<PedidoDTO> buscarPedidosPorMesa(String mesaId) {
        List<Pedido> pedidos = pedidoBO.buscarPedidosPorMesaIdEStatus(mesaId);
        return converterPedidoParaDTO(pedidos);
    }

    private List<PedidoDTO> converterPedidoParaDTO(List<Pedido> pedidos) {
        List<PedidoDTO> pedidoDTO = new ArrayList<>();
        pedidos.forEach(pedido -> pedidoDTO.add(montarPedidoDTO(pedido)));
        return pedidoDTO;
    }

    public static PedidoDTO montarPedidoDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO(pedido);
        return pedidoDTO;
    }
}
