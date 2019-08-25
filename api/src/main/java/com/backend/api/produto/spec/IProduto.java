package com.backend.api.produto.spec;

import com.backend.api.produto.spec.dto.ProdutoDTO;

import java.util.List;

public interface IProduto {

    List<ProdutoDTO> buscarProdutos();

    void removerProduto(ProdutoDTO produtoDTO);

    void inserirProduto(ProdutoDTO produtoDTO);

    void atualizarProduto(ProdutoDTO produtoDTO);
}
