package com.backend.api.cargo.service;

import com.backend.api.cargo.spec.ICargo;
import com.backend.api.cargo.spec.dto.CargoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoriaService {

    @Autowired
    private ICargo iCargo;

    @GetMapping("/cargo/all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<CargoDTO> buscarCategorias() {
        return iCargo.buscarCargos();
    }

    @PostMapping("/cargo/inserir")
    //@PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirCategoria(@RequestBody CargoDTO cargoDTO) {
        iCargo.inserirCargo(cargoDTO);
    }
}