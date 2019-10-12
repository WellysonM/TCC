package com.backend.api.categoria.spec;

import com.backend.api.categoria.spec.dto.CategoriaDTO;

import java.util.List;

public interface ICategoria {

    List<CategoriaDTO> buscarCategorias();

    void removerCategoria(CategoriaDTO categoriaDTO);

    void inserirCategoria(CategoriaDTO categoriaDTO);

    void atualizarCategoria(CategoriaDTO categoriaDTO);
}
