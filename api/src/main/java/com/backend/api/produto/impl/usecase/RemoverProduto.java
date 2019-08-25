package com.backend.api.produto.impl.usecase;

import com.backend.api.produto.impl.bo.ProdutoBO;
import com.backend.api.produto.spec.dto.ProdutoDTO;
import com.backend.api.produto.spec.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoverProduto {

    @Autowired
    private ProdutoBO produtoBO;

    public void RemoverProduto(ProdutoDTO produtoDTO) {
        Produto produto = produtoBO.buscarProdutoPorId(produtoDTO.getId());
        produtoBO.removerProduto(produto);
    }
}
