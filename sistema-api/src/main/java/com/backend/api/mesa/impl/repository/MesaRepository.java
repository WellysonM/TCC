package com.backend.api.mesa.impl.repository;


import com.backend.api.mesa.spec.entity.Mesa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MesaRepository extends MongoRepository<Mesa, String> {

}