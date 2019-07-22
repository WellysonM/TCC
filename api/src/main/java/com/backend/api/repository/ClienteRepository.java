package com.backend.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.api.documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
