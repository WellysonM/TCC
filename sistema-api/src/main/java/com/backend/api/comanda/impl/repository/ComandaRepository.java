package com.backend.api.comanda.impl.repository;


import com.backend.api.comanda.spec.entity.Comanda;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ComandaRepository extends MongoRepository<Comanda, String> {
    List<Comanda> findAllByMesa_Id(String mesaId);
}