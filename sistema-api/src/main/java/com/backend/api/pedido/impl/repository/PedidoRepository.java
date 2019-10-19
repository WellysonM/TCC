package com.backend.api.pedido.impl.repository;


import com.backend.api.pedido.spec.entity.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
    Pedido findAByMesa_IdAndStatusIsNotLike(String mesaId, String status);
}