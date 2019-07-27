package com.backend.api.usuario.service;

import com.backend.api.usuario.spec.IUsuario;
import com.backend.api.usuario.spec.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private IUsuario iUsuario;

    @PostMapping("/cadastrar")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        iUsuario.inserirUsuario(usuarioDTO);
    }
}
