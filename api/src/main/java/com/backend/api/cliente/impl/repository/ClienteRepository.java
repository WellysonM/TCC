package com.backend.api.cliente.impl.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.api.cliente.spec.entity.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
