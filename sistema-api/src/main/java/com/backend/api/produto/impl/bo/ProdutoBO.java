package com.backend.api.produto.impl.bo;

import com.backend.api.produto.impl.repository.ProdutoRepository;
import com.backend.api.produto.spec.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoBO {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarProdutos() {
        return produtoRepository.findAll(Sort.by("produto").ascending());
    }

    public Produto inserirProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto buscarProdutoPorId(String id) {
        return produtoRepository.findById(id).get();
    }

    public void removerProduto(Produto produto) {
        produtoRepository.delete(produto);
    }
}
