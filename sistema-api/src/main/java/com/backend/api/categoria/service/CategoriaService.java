package com.backend.api.categoria.service;

import com.backend.api.categoria.spec.ICategoria;
import com.backend.api.categoria.spec.dto.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoriaService {

    @Autowired
    private ICategoria iCategoria;

    @GetMapping("/categoria/all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<CategoriaDTO> buscarCategorias() {
        return iCategoria.buscarCategorias();
    }

    @PostMapping("/categoria/inserir")
    //@PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        iCategoria.inserirCategoria(categoriaDTO);
    }
}
