package com.backend.api.controller;

import com.backend.api.documents.Cliente;
import com.backend.api.documents.Usuario;
import com.backend.api.repository.ClienteRepository;
import com.backend.api.repository.UsuarioRepository;
import com.backend.api.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private PasswordEncoder passwordEncoder = new PasswordEncoder();

    @GetMapping("/USER/all")
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @GetMapping("/entrar")
    public String entrar(){
        return "PAGINA INICIAL";
    }

    @PostMapping("ADMIN/cadastrar")
    @PreAuthorize("hasRole('ADMIN')")
    public void inserirCliente(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @PostMapping("registro")
    //@PreAuthorize("hasRole('ADMIN')")
    public void inserirUsuario(@RequestBody Usuario usuario) {
        passwordEncoder.hasPassword(usuario);
        usuarioRepository.save(usuario);
    }

}

