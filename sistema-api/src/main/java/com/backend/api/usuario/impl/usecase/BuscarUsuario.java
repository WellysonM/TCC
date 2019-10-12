package com.backend.api.usuario.impl.usecase;

import com.backend.api.usuario.impl.bo.UsuarioBO;
import com.backend.api.usuario.spec.dto.UsuarioDTO;
import com.backend.api.usuario.spec.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuscarUsuario {

    @Autowired
    private UsuarioBO usuarioBO;

    public List<UsuarioDTO> BuscarUsuario() {
        List<Usuario> usuarios = usuarioBO.buscarUsuarios();
        return converterUsuarioParaDTO(usuarios);
    }

    private List<UsuarioDTO> converterUsuarioParaDTO(List<Usuario> usuarios) {
        List<UsuarioDTO> usuarioDTO = new ArrayList<>();
        usuarios.forEach(usuario -> usuarioDTO.add(montarUsuarioDTO(usuario)));
        return usuarioDTO;
    }

    public static UsuarioDTO montarUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        return usuarioDTO;
    }
}
