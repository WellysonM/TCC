package com.backend.api.produto.impl.usecase;

import com.backend.api.produto.impl.bo.ProdutoBO;
import com.backend.api.produto.spec.dto.ProdutoDTO;
import com.backend.api.produto.spec.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InserirProduto {

    @Autowired
    private ProdutoBO produtoBO;

    public void InserirProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        preencherProduto(produto, produtoDTO);
        if (PossoInserirProduto(produto)) {
            produtoBO.inserirProduto(produto);
        } else {
            produtoBO.inserirProduto(null);
        }
    }

    private static void preencherProduto(Produto produto, ProdutoDTO produtoDTO) {
        produto.setProduto(produtoDTO.getProduto());
        produto.setPreco(produtoDTO.getPreco());
        produto.setCategoria(produtoDTO.getCategoria());
        produto.setTempoPreparo(produtoDTO.getTempoPreparo());
        produto.setQuantidade(produtoDTO.getQuantidade());
    }

    private boolean PossoInserirProduto(Produto produto) {
        List<Produto> produtos = produtoBO.buscarProdutos();
        for (Produto produtoLista : produtos) {
            if (produtoLista.getProduto().equalsIgnoreCase(produto.getProduto())) {
                return false;
            }
        }
        return true;
    }
}
