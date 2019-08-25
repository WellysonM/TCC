package com.backend.api.categoria.impl.repository;


import com.backend.api.categoria.spec.entity.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {

}