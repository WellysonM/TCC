package com.backend.api.usuario.impl.usecase;

import com.backend.api.usuario.impl.bo.UsuarioBO;
import com.backend.api.usuario.spec.dto.UsuarioDTO;
import com.backend.api.usuario.spec.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscarUsuarioPorUsername {

    @Autowired
    private UsuarioBO usuarioBO;

    public Usuario buscarUsuarioPorUsername(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioBO.buscarUsuarioPorUsername(usuarioDTO.getUsername());
        return usuario;
    }
}