package com.backend.api.categoria.impl.usecase;

import com.backend.api.categoria.impl.bo.CategoriaBO;
import com.backend.api.categoria.spec.dto.CategoriaDTO;
import com.backend.api.categoria.spec.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtualizarCategoria {

    @Autowired
    private CategoriaBO categoriaBO;

    public void atualizarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaBO.buscarCategoriaPorId(categoriaDTO.getId());
        preencherCategoria(categoria, categoriaDTO);
        categoriaBO.atualizarCategoria(categoria);
    }

    private static void preencherCategoria(Categoria categoria, CategoriaDTO categoriaDTO) {
        categoria.setIcone(categoriaDTO.getIcone());
        categoria.setTitulo(categoriaDTO.getTitulo());
        categoria.setSubTitulo(categoriaDTO.getSubTitulo());
        categoria.setPreco(categoriaDTO.getPreco());
        categoria.setCor(categoriaDTO.getCor());
    }
}
