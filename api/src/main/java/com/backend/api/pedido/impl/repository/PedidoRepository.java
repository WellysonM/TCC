package com.backend.api.pedido.impl.repository;


import com.backend.api.pedido.spec.entity.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, String> {

}