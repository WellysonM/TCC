package com.backend.api.produto.impl.repository;

import com.backend.api.produto.spec.entity.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
    List<Produto> findProdutosByCategoria_Id(String categoriaId);
}