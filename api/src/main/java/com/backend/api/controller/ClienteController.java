package com.backend.api.controller;

import com.backend.api.documents.Cliente;
import com.backend.api.documents.Usuario;
import com.backend.api.repository.ClienteRepository;
import com.backend.api.repository.UsuarioRepository;
import com.backend.api.security.CustomUserDetailsService;
import com.backend.api.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private PasswordEncoder passwordEncoder = new PasswordEncoder();

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/entrar", method = RequestMethod.GET)
    public Usuario user(@RequestBody Usuario user) {
        System.out.println(user.getUsername());
        user = usuarioRepository.findByUsername(user.getUsername());
        System.out.println(user.getUsername());
        return user;
    }

    @RequestMapping(value = "/sair", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:8080")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/entrar?sair=true";
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

