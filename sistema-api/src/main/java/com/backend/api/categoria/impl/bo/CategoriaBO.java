package com.backend.api.categoria.impl.bo;

import com.backend.api.categoria.impl.repository.CategoriaRepository;
import com.backend.api.categoria.spec.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaBO {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarCategorias() {
        return categoriaRepository.findAll(Sort.by("titulo").ascending());
    }

    public Categoria inserirCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria buscarCategoriaPorId(String id) {
        return categoriaRepository.findById(id).get();
    }

    public void removerCategoria(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }
}
