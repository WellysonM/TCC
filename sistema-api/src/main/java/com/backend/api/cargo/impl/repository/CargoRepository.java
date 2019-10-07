package com.backend.api.cargo.impl.repository;


import com.backend.api.cargo.spec.entity.Cargo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CargoRepository extends MongoRepository<Cargo, String> {

}