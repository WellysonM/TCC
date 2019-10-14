package com.backend.api.usuario.impl.usecase;

import com.backend.api.usuario.impl.bo.UsuarioBO;
import com.backend.api.usuario.spec.dto.UsuarioDTO;
import com.backend.api.usuario.spec.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtualizarUsuario {

    @Autowired
    private UsuarioBO usuarioBO;

    public void atualizarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioBO.buscarUsuarioPorId(usuarioDTO.getId());
        preencherUsuario(usuario, usuarioDTO);
        usuarioBO.atualizarUsuario(usuario);
    }

    private static void preencherUsuario(Usuario usuario, UsuarioDTO usuarioDTO) {
        usuario.setName(usuarioDTO.getName());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setAdmin(usuarioDTO.isAdmin());
    }
}
