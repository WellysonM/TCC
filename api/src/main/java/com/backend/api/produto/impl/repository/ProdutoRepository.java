package com.backend.api.produto.impl.repository;

import com.backend.api.produto.spec.entity.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {

}