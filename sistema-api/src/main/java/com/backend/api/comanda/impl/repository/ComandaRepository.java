package com.backend.api.comanda.impl.repository;


import com.backend.api.comanda.spec.entity.Comanda;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComandaRepository extends MongoRepository<Comanda, String> {
}