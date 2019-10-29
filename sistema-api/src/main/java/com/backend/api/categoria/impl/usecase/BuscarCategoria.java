package com.backend.api.categoria.impl.usecase;

import com.backend.api.categoria.impl.bo.CategoriaBO;
import com.backend.api.categoria.spec.dto.CategoriaDTO;
import com.backend.api.categoria.spec.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuscarCategoria {

    @Autowired
    private CategoriaBO categoriaBO;

    public List<CategoriaDTO> buscarCategorias() {
        List<Categoria> categorias = categoriaBO.buscarCategorias();
        return converterCategoriaParaDTO(categorias);
    }

    private List<CategoriaDTO> converterCategoriaParaDTO(List<Categoria> categorias) {
        List<CategoriaDTO> categoriaDTO = new ArrayList<>();
        categorias.forEach(categoria -> categoriaDTO.add(montarClienteDTO(categoria)));
        return categoriaDTO;
    }

    public static CategoriaDTO montarClienteDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO(categoria);
        return categoriaDTO;
    }
}
