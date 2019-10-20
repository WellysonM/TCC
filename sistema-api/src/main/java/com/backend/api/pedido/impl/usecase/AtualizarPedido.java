package com.backend.api.pedido.impl.usecase;

import com.backend.api.mesa.impl.bo.MesaBO;
import com.backend.api.mesa.spec.entity.Mesa;
import com.backend.api.pedido.impl.bo.PedidoBO;
import com.backend.api.pedido.spec.dto.PedidoDTO;
import com.backend.api.pedido.spec.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtualizarPedido {

    @Autowired
    private PedidoBO pedidoBO;

    @Autowired
    private MesaBO mesaBO;

    public void atualizarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoBO.buscarPedidoPorId(pedidoDTO.getId());
        verificarMesaDoPedido(pedido, pedidoDTO);
        preencherPedido(pedido, pedidoDTO);
        pedidoBO.atualizarPedido(pedido);
    }

    private static void preencherPedido(Pedido pedido, PedidoDTO pedidoDTO) {
        pedido.setId(pedidoDTO.getId());
        pedido.setStatus(pedidoDTO.getStatus());
        pedido.setProdutos(pedidoDTO.getProdutos());
        pedido.setValorTotal(pedidoDTO.getValorTotal());
        pedido.setMesa(pedidoDTO.getMesa());
        pedido.setUsuario(pedidoDTO.getUsuario());
        pedido.setCliente(pedidoDTO.getCliente());
    }

    private void verificarMesaDoPedido(Pedido pedido, PedidoDTO pedidoDTO) {
        Mesa mesa = mesaBO.buscarMesaPorId(pedido.getMesa().getId());
        mesa.setStatus("disponivel");
        mesaBO.atualizarMesa(mesa);
        mesa = pedidoDTO.getMesa();
        mesa.setStatus("ocupada");
        mesaBO.atualizarMesa(mesa);
    }
}