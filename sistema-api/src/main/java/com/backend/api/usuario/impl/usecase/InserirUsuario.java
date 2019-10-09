package com.backend.api.usuario.impl.usecase;

import com.backend.api.security.PasswordEncoder;
import com.backend.api.usuario.impl.bo.UsuarioBO;
import com.backend.api.usuario.spec.dto.UsuarioDTO;
import com.backend.api.usuario.spec.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InserirUsuario {

    @Autowired
    private UsuarioBO usuarioBO;

    private PasswordEncoder passwordEncoder = new PasswordEncoder();

    public void inserirUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        preencherUsuario(usuario, usuarioDTO);
        passwordEncoder.hasPassword(usuario);
        usuarioBO.inserirUsuario(usuario);
    }

    private static void preencherUsuario(Usuario usuario, UsuarioDTO usuarioDTO) {
        usuario.setName(usuarioDTO.getName());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setAdmin(usuarioDTO.isAdmin());
    }
}
