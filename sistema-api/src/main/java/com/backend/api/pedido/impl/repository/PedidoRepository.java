package com.backend.api.pedido.impl.repository;


import com.backend.api.pedido.spec.entity.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
    List<Pedido> findAllByMesa_IdAndStatusIsNotLike(String mesaId, String status);
}