package com.backend.api.categoria.impl.usecase;

import com.backend.api.categoria.impl.bo.CategoriaBO;
import com.backend.api.categoria.spec.dto.CategoriaDTO;
import com.backend.api.categoria.spec.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoverCategoria {

    @Autowired
    private CategoriaBO categoriaBO;

    public void removerCategoria(CategoriaDTO categoriaDTO) {
        Categoria categroia = categoriaBO.buscarCategoriaPorId(categoriaDTO.getId());
        categoriaBO.removerCategoria(categroia);
    }
}
