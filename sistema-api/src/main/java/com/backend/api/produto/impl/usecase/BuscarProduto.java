package com.backend.api.produto.impl.usecase;

import com.backend.api.produto.impl.bo.ProdutoBO;
import com.backend.api.produto.spec.dto.ProdutoDTO;
import com.backend.api.produto.spec.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuscarProduto {

    @Autowired
    private ProdutoBO produtoBO;

    public List<ProdutoDTO> BuscarProdutos() {
        List<Produto> produtos = produtoBO.buscarProdutos();
        return converterProdutoParaDTO(produtos);
    }

    private List<ProdutoDTO> converterProdutoParaDTO(List<Produto> produtos) {
        List<ProdutoDTO> produtoDTO = new ArrayList<>();
        produtos.forEach(produto -> produtoDTO.add(montarProdutoDTO(produto)));
        return produtoDTO;
    }

    public static ProdutoDTO montarProdutoDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO(produto);
        return produtoDTO;
    }
}
