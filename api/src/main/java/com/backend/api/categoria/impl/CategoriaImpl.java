package com.backend.api.categoria.impl;

import com.backend.api.categoria.impl.usecase.AtualizarCategoria;
import com.backend.api.categoria.impl.usecase.BuscarCategoria;
import com.backend.api.categoria.impl.usecase.InserirCategoria;
import com.backend.api.categoria.impl.usecase.RemoverCategoria;
import com.backend.api.categoria.spec.ICategoria;
import com.backend.api.categoria.spec.dto.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaImpl implements ICategoria {

    @Autowired
    private BuscarCategoria buscar;

    @Autowired
    private InserirCategoria inserir;

    @Autowired
    private AtualizarCategoria atualizar;

    @Autowired
    private RemoverCategoria remover;

    @Override
    public List<CategoriaDTO> buscarCategorias() {
        return buscar.BuscarCategorias();
    }

    @Override
    public void removerCategoria(CategoriaDTO categoriaDTOId) {
        remover.RemoverCategoria(categoriaDTOId);
    }

    @Override
    public void inserirCategoria(CategoriaDTO categoriaDTO) {
        inserir.InserirCategoria(categoriaDTO);
    }

    @Override
    public void atualizarCategoria(CategoriaDTO categoriaDTO) {
        atualizar.atualizarCategoria(categoriaDTO);
    }
}
