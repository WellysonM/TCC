package com.backend.api.produto.impl.usecase;

import com.backend.api.produto.impl.bo.ProdutoBO;
import com.backend.api.produto.spec.dto.ProdutoDTO;
import com.backend.api.produto.spec.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InserirProduto {

    @Autowired
    private ProdutoBO produtoBO;

    public void InserirProduto(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        preencherProduto(produto, produtoDTO);
        produtoBO.inserirProduto(produto);
    }

    private static void preencherProduto(Produto produto, ProdutoDTO produtoDTO) {
        produto.setProduto(produtoDTO.getProduto());
        produto.setPreco(produtoDTO.getPreco());
        produto.setCategoria(produtoDTO.getCategoria());
        produto.setTempoPreparo(produtoDTO.getTempoPreparo());
    }
}
