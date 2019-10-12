package com.backend.api.usuario.service;

import com.backend.api.usuario.spec.IUsuario;
import com.backend.api.usuario.spec.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private IUsuario iUsuario;

    @PostMapping("/usuario/inserir")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        iUsuario.inserirUsuario(usuarioDTO);
    }

    @GetMapping("/usuario/usuarioLogado")
    @CrossOrigin(origins = "http://localhost:8080")
    public UserDetails getUsuario(@AuthenticationPrincipal UserDetails userDetails) {
        System.out.println(userDetails);
        return userDetails;
    }

    @GetMapping("/usuarios/all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<UsuarioDTO> buscarUsuarios() {
        return iUsuario.buscarUsuarios();
    }

}
