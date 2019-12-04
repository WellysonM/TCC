package com.backend.api.pedido.impl.bo;

import com.backend.api.pedido.impl.repository.PedidoRepository;
import com.backend.api.pedido.spec.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoBO {

    @Autowired
    private PedidoRepository pedidoRepository;

    private static final String status = "finalizado";
    private static final String emEspera = "em espera";

    public List<Pedido> buscarPedidos() {
        return pedidoRepository.findAll(Sort.by("id").ascending());
    }

    public List<Pedido> buscarPedidosPorMesaIdEStatus(String mesaId) {
        return pedidoRepository.findAByMesa_IdAndStatusIsNotLike(mesaId, status);
    }

    public List<Pedido> buscarTodosPedidosFinalizados() {
        return pedidoRepository.findAllByStatus(status);
    }

    public List<Pedido> buscarTodosPedidosEmEspera() {
        return pedidoRepository.findAllByStatus(emEspera);
    }

    public Pedido inserirPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido buscarPedidoPorId(String id) {
        return pedidoRepository.findById(id).get();
    }

    public void removerPedido(Pedido pedido) {
        pedidoRepository.delete(pedido);
    }
}
