package com.backend.api.controller;

import com.backend.api.documents.Cliente;
import com.backend.api.documents.Usuario;
import com.backend.api.repository.ClienteRepository;
import com.backend.api.repository.UsuarioRepository;
import com.backend.api.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController
//@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private PasswordEncoder passwordEncoder = new PasswordEncoder();

    @RequestMapping("/entrar")
    public String entrar() {
        return "entrar";
    }

    @GetMapping("/api/USER/menu")
    public String menu() {
        return "paginaInicial";
    }

    @GetMapping("/USER/all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @PostMapping("ADMIN/cadastrar")
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirCliente(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @PostMapping("registro")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirUsuario(@RequestBody Usuario usuario) {
        passwordEncoder.hasPassword(usuario);
        usuarioRepository.save(usuario);
    }

}

