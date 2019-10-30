package com.backend.api.usuario.impl.usecase;

import com.backend.api.security.PasswordEncoder;
import com.backend.api.usuario.impl.bo.UsuarioBO;
import com.backend.api.usuario.spec.dto.UsuarioDTO;
import com.backend.api.usuario.spec.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AtualizarUsuario {

    @Autowired
    private UsuarioBO usuarioBO;

    private PasswordEncoder passwordEncoder = new PasswordEncoder();

    public void atualizarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioBO.buscarUsuarioPorId(usuarioDTO.getId());
        if (possoAtualizarSenha(usuario, usuarioDTO)) {
            preencherUsuario(usuario, usuarioDTO);
        } else {
            preencherUsuario(usuario, usuarioDTO);
            passwordEncoder.hasPassword(usuario);
        }
        if (possoAtualizarUsuario(usuario)) {
            usuarioBO.atualizarUsuario(usuario);
        } else {
            usuarioBO.atualizarUsuario(null);
        }
    }

    private static void preencherUsuario(Usuario usuario, UsuarioDTO usuarioDTO) {
        usuario.setName(usuarioDTO.getName());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setAdmin(usuarioDTO.isAdmin());
    }

    private boolean possoAtualizarUsuario(Usuario usuario) {
        List<Usuario> usuarios = usuarioBO.buscarUsuarios();
        for (Usuario usuarioLista : usuarios) {
            if (usuarioLista.getUsername().equalsIgnoreCase(usuario.getUsername())) {
                return usuarioLista.getId().equals(usuario.getId());
            }
        }
        return true;
    }

    private boolean possoAtualizarSenha(Usuario usuario, UsuarioDTO usuarioDTO) {
        return usuario.getPassword().equals(usuarioDTO.getPassword());
    }
}
