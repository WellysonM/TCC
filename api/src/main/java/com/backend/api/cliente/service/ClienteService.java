package com.backend.api.cliente.service;

import com.backend.api.cliente.spec.ICliente;
import com.backend.api.cliente.spec.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteService {

    @Autowired
    private ICliente iCliente;

    @GetMapping("/USER/all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<ClienteDTO> buscarClientes() {
        return iCliente.buscarClientes();
    }

    @PostMapping("/ADMIN/cadastrar")
    //@PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirCliente(@RequestBody ClienteDTO clienteDTO) {
        iCliente.inserirCliente(clienteDTO);
    }

}
