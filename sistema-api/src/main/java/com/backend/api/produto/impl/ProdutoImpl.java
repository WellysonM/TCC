package com.backend.api.produto.impl;

import com.backend.api.produto.impl.usecase.AtualizarProduto;
import com.backend.api.produto.impl.usecase.BuscarProduto;
import com.backend.api.produto.impl.usecase.InserirProduto;
import com.backend.api.produto.impl.usecase.RemoverProduto;
import com.backend.api.produto.spec.IProduto;
import com.backend.api.produto.spec.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoImpl implements IProduto {

    @Autowired
    private BuscarProduto buscar;

    @Autowired
    private InserirProduto inserir;

    @Autowired
    private AtualizarProduto atualizar;

    @Autowired
    private RemoverProduto remover;

    @Override
    public List<ProdutoDTO> buscarProdutos() {
        return buscar.BuscarProdutos();
    }

    @Override
    public void removerProduto(String produtoDTOId) {
        remover.RemoverProduto(produtoDTOId);
    }

    @Override
    public void inserirProduto(ProdutoDTO produtoDTO) {
        inserir.InserirProduto(produtoDTO);
    }

    @Override
    public void atualizarProduto(ProdutoDTO produtoDTO) {
        atualizar.atualizarProduto(produtoDTO);
    }
}
