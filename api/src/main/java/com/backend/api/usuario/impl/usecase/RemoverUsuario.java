package com.backend.api.usuario.impl.usecase;

import com.backend.api.usuario.impl.bo.UsuarioBO;
import com.backend.api.usuario.spec.dto.UsuarioDTO;
import com.backend.api.usuario.spec.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoverUsuario {

    @Autowired
    private UsuarioBO usuarioBO;

    public void removerUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioBO.buscarUsuarioPorId(usuarioDTO.getId());
        usuarioBO.removerUsuario(usuario);
    }
}
