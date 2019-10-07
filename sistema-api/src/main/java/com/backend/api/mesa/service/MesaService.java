package com.backend.api.mesa.service;

import com.backend.api.mesa.spec.IMesa;
import com.backend.api.mesa.spec.dto.MesaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MesaService {

    @Autowired
    private IMesa iMesa;

    @GetMapping("/mesa/all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<MesaDTO> buscarMesas() {
        return iMesa.buscarMesas();
    }

    @PostMapping("/mesa/inserir")
    //@PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirMesa(@RequestBody MesaDTO mesaDTO) {
        iMesa.inserirMesa(mesaDTO);
    }
}
