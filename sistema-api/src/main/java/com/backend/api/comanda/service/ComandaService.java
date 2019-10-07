package com.backend.api.comanda.service;

import com.backend.api.comanda.spec.IComanda;
import com.backend.api.comanda.spec.dto.ComandaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ComandaService {

    @Autowired
    private IComanda iComanda;

    @GetMapping("/comanda/all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<ComandaDTO> buscarCategorias() {
        return iComanda.buscarComandas();
    }

    @PostMapping("/comanda/inserir")
    //@PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirCategoria(@RequestBody ComandaDTO comandaDTO) {
        iComanda.inserirComanda(comandaDTO);
    }
}
